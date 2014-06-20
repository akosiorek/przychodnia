package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class dbDAO {

	private final static String PROPS = "resources//db.properties";
	private final static String URL = "url";
	private final static String DRIVER = "driver";
	private final static String USER_NAME = "userName";
	private final static String PASSWORD = "password";
	
	private static Connection connection;
	private static Statement statement;

	private static String userName;
	private static String password;
	private static String driver;
	private static String url;

	protected dbDAO() {}

    static {
        readProperties();
    }

	
	private static void readProperties() {
		
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(PROPS));
			
			driver = prop.getProperty(DRIVER);
			url = prop.getProperty(URL);
			userName = prop.getProperty(USER_NAME);
			password = prop.getProperty(PASSWORD);
			
		} catch(IOException e) {
			System.err.println("Couldn't read any database properties");
            System.err.println(e.getMessage());
		}		
	}
	
	public static void establishConnection() throws ConnectExpection {

		try {
			Class.forName(driver).newInstance();
			connection = DriverManager.getConnection(url, userName, password);
			System.out.println("Connected to a database");
		} catch (Exception e) {
            throw new ConnectExpection("Couldn't establish connection\n" + e.getMessage());
		}
	}

	
	public static void closeConnection() throws ConnectExpection {
		
		if(statement != null)
			try {
				statement.close();
			} catch (Exception e) {
                throw new ConnectExpection("Couldn't close statement\n" + e.getMessage());
			}
		
		if(connection != null) {
			try {
				connection.close();
				System.out.println("Disconnected from the database");
			} catch (SQLException e) {
                throw new ConnectExpection("Couldn't close connection\n" + e.getMessage());
			}
		}
	}
	
	public static ResultSet executeQuery(String query) throws QueryException {
		
		ResultSet rs = null;
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
		} catch(SQLException e) {
            throw new QueryException("Couldn't execute the following statement:\n" + query + "\n" + e.getMessage());
		}
        System.out.println("Executed query: " + query);

		return rs;
	}

    public static List<String[]> executeQueryList(String query, boolean withHeader) throws QueryException {

        ArrayList<String[]> resultList = new ArrayList<String[]>();
        ResultSet rs = executeQuery(query);

        try {

            if(withHeader) {

               String[] header = new String[rs.getMetaData().getColumnCount()];
               for(int i = 0; i < header.length; ++i) {

                   header[i] = rs.getMetaData().getColumnName(i + 1);
               }
                resultList.add(header);
            }


            while(rs.next()) {
                String[] result = new String[rs.getMetaData().getColumnCount()];
                for(int i = 0; i < result.length; ++i) {

                    result[i] = rs.getString(i + 1);
                }
                resultList.add(result);

            }
        } catch (SQLException e) {
            throw new QueryException("Couldn't read ResultSet from query:\n" + query + "\n" + e.getMessage());
        }
        return resultList;
    }
	
	public static void executeUpdate(String query) throws QueryException {

		try {
			statement = connection.createStatement();
			if(statement.executeUpdate(query) == -1) {
                throw new QueryException("Failed to execute an update query:\n" + query + "\n");
            }
			
		} catch(SQLException e) {
            throw new QueryException("Couldn't execute the following statement:\n" + query + "\n" + e.getMessage());
		}
        System.out.println("Executed update: " + query);
	}
	
	public static void main(String[] args) throws ConnectExpection, QueryException {

        dbDAO db = new dbDAO();
        db.establishConnection();

        ResultSet rs = db.executeQuery("select tablespace_name, table_name from user_tables");
        try {
            while(rs.next()) {

                System.out.println(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.closeConnection();
	}

    @Override
    protected void finalize() throws Throwable {

        try {
            closeConnection();
        } catch (ConnectExpection err) {
            System.err.println("Error on dbDAO.finalize()");
        } finally {
            super.finalize();
        }
    }


    public static void startTransaction() {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void enableAutoCommit() throws SQLException {
        connection.setAutoCommit(true);
    }

    public static void commit() {

        try {
            connection.commit();
            enableAutoCommit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollback() {

        try {
            connection.rollback();
            enableAutoCommit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
