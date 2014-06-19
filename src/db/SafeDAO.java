package db;

import java.util.List;

/**
 * Created by adam on 6/15/14.
 */
public class SafeDAO {

    public static List<String[]> select(String query) {

        List<String[]> results = null;
        try {
            results = dbDAO.executeQueryList(query, false);
        } catch (QueryException e) {
            e.printStackTrace();
        }
        return results;
    }

    public static List<String[]> select(String query, boolean withHeader) {

        List<String[]> results = null;
        try {
            results = dbDAO.executeQueryList(query, withHeader);
        } catch (QueryException e) {
            e.printStackTrace();
        }
        return results;
    }

    public static void update(String query) {

        try {
            dbDAO.executeUpdate(query);
        } catch (QueryException e) {
            e.printStackTrace();
        }
    }
}
