package controler;

import db.ConnectExpection;
import db.QueryException;
import db.dbDAO;
import gui.NowyPacjent;

import java.util.ArrayList;

public class ControlerNowyPacjent extends IControlerNowyPacjent {

    private final static dbDAO db = new dbDAO();

	 public ControlerNowyPacjent(NowyPacjent nowyPacjentWindow) {
		super(nowyPacjentWindow);
		// TODO Auto-generated constructor stub
	}

	public boolean zapiszDanePacjenta(ArrayList<String> dane){

        String query = "INSERT INTO pacjent(imie, imie2, nazwisko, pesel, nr_tel) VALUES(" +
                "'" + dane.get(0) +"'," +
                "'" + dane.get(1) +"'," +
                "'" + dane.get(2) +"'," +
                "" + dane.get(3) +"," +
                "" + dane.get(4) +")";

        try {
            db.establishConnection();
            db.executeUpdate(query);
            System.out.println("Executed: " + query);
            db.closeConnection();
        } catch (ConnectExpection connectExpection) {
            connectExpection.printStackTrace();
            return false;
        } catch (QueryException e) {
            e.printStackTrace();
            return false;
        }
        return true;
	 }
}
