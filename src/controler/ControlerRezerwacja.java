package controler;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import db.SafeDAO;
import gui.Rezerwacja;

import javax.management.Query;

public class ControlerRezerwacja extends IControlerRezerwacja{

	ControlerRezerwacja(Rezerwacja rezerwacjaWindow) {
		super(rezerwacjaWindow);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<String> znajdzLekarzy(Date data, String specjalizacja) {

        long dateInSeconds = data.getTime();
        String thisDay =  new java.sql.Date(dateInSeconds).toString();
        String query = "SELECT lekarz.imie, lekarz.nazwisko FROM lekarz JOIN spec_lek ON spec_lek.lekarz_id = lekarz.id JOIN specjalizacja ON spec_lek.specjalizacja_id = specjalizacja.id JOIN terminarz ON lekarz.id = terminarz.lekarz_id"
        + " where specjalizacja.nazwa = '" + specjalizacja + "' and terminarz.termin = DATE '" + thisDay + "'";
        List<String[]> results = SafeDAO.select(query);
        ArrayList<String> lekarze = new ArrayList<String>();
        for(String[] result : results) {
            lekarze.add(result[0] + " " + result[1]);
        }
        return lekarze;
	}

	@Override
	public ArrayList<String> readUslugi() {
		ArrayList<String> uslugi = new ArrayList<String>();
        for(int i = 0; i < 10; ++i) {
            uslugi.add(Integer.toString(i));
        }
		return uslugi;
	}

	@Override
	public ArrayList<String> readSpecjalisci() {
		String query = "SELECT nazwa FROM specjalizacja";
        List<String[]> results = SafeDAO.select(query);
        ArrayList<String> specjalisci = new ArrayList<String>();
        for(String[] result : results) {
            specjalisci.add(result[0]);
        }
		return specjalisci;
	}

	@Override
	public MPair<Integer, HashMap<String, String>> checkDanePacjenta(
			String key, String value) {

        return QueryManager.findPacjent(key, value);
	}

}
