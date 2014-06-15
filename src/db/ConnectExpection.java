package db;

/**
 * Created by adam on 6/14/14.
 */
public class ConnectExpection extends Exception {

    public ConnectExpection(String msg) {
        super(msg);
        System.err.println(msg);
    }
}
