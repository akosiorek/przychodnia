package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class dbDAO {

	private final static String PROPS = "resources//db.properties";
	private final static String URL = "url";
	private final static String DRIVER = "driver";
	private final static String USER_NAME = "userName";
	private final static String PASSWORD = "password";
	
	private Connection connection;
	private Statement statement;

	private String userName;
	private String password;
	private String driver;
	private String url;
	public dbDAO() {
		
		connection = null;
		readProperties();
	}
	
	
	private void readProperties() {
		
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
	
	public void establishConnection() {
		
		try {
			Class.forName(driver).newInstance();
			connection = DriverManager.getConnection(url, userName, password);
			System.out.println("Connected to a database");
		} catch (Exception e) {
			System.err.println("No connection");
            System.err.println(e.getMessage());
		}
	}
	
	
	public void closeConnection() {
		
		if(statement != null)
			try {
				statement.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
                System.err.println(e1.getMessage());
				e1.printStackTrace();
			}
		
		if(connection != null) {
			
			try {
				connection.close();
				System.out.println("Disconnected from the database");
			} catch (SQLException e) {
				System.err.println("Couldn't close the connection");
                System.err.println(e.getMessage());
			}
		}
	}
	
	public ResultSet executeQuery(String query) {
		
		ResultSet rs = null;
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			
		} catch(SQLException e) {
			
			System.err.println("Couldn't execute the following statement:");
			System.err.println(query);
            System.err.println(e.getMessage());
			if(statement != null)
				try {
					statement.close();
				} catch (SQLException e1) {
                    System.err.println(e1.getMessage());
					e1.printStackTrace();
				}
		}
		
		return rs;
	}
	
	public int executeUpdate(String query) {
		
		establishConnection();
		
		int result = -1;
		try {
			statement = connection.createStatement();
			result = statement.executeUpdate(query);
			
		} catch(SQLException e) {
			
			System.err.println("Couldn't execute the following statement:");
			System.err.println(query);
            System.err.println(e.getMessage());
			if(statement != null)
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
                    System.err.println(e1.getMessage());
				}
		}
		
		closeConnection();
		
		System.out.println(result);
		return result;
	}
	
	public static void main(String[] args) {

        dbDAO db = new dbDAO();
        db.establishConnection();

        ResultSet rs = db.executeQuery("select tablespace_name, table_name from all_tables");
        try {
            while(rs.next()) {

                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.closeConnection();
			
	}
}
