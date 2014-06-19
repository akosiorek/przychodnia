package controler;

import db.ConnectExpection;
import db.QueryException;
import db.SafeDAO;
import db.dbDAO;
import gui.NowyPacjent;

import java.util.ArrayList;

public class ControlerNowyPacjent extends IControlerNowyPacjent {

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

        SafeDAO.update(query);
        return true;
	 }
}
