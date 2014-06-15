package db;

import javax.management.Query;

/**
 * Created by adam on 6/14/14.
 */
public class QueryException extends Exception {

    public QueryException(String msg) {
        super(msg);
        System.err.println(msg);
    }
}
