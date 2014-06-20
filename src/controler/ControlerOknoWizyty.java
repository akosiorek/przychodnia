package controler;

import db.QueryException;
import db.SafeDAO;
import db.dbDAO;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControlerOknoWizyty extends IControlerOknoWizyty{

	@Override
	public void utworzWizyte(HashMap<String, String> wizyta) {

        for(Map.Entry<String, String> entry : wizyta.entrySet()) {

            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        String[] lekarz = wizyta.get("LEKARZ").split(" ");
        String koszt = wizyta.get("KOSZT").isEmpty() ? "0" : wizyta.get("KOSZT");

        dbDAO.startTransaction();
        try {
            List<String[]> pacjentResult = dbDAO.executeQueryList("SELECT id FROM pacjent WHERE pesel = " + wizyta.get("PESEL"), false);
            if(pacjentResult.isEmpty()) {
                throw new QueryException("Nie ma pacjenta o peselu = " + wizyta.get("PESEL"));
            }
            String pacjentId = pacjentResult.get(0)[0];

            List<String[]> lekarzResult = dbDAO.executeQueryList("SELECT lekarz.id FROM lekarz JOIN terminarz ON lekarz.id = terminarz.lekarz_id"
                    + " where terminarz.termin = DATE '" + wizyta.get("TERMIN")
                    + "' and lekarz.imie = '" + lekarz[0] + "' and lekarz.nazwisko = '" + lekarz[1] + "'", false);
            if(lekarzResult.isEmpty()) {
                throw new QueryException("Lekarz " + wizyta.get("LEKARZ") + " nie ma terminu " + wizyta.get("TERMIN"));
            }
            String lekarzId = lekarzResult.get(0)[0];

            String wizytaId = dbDAO.executeQueryList("SELECT MAX(id) + 1 FROM wizyta", false).get(0)[0];

            dbDAO.executeUpdate("INSERT INTO wizyta(id, termin, status, nazwa, koszt, typ, lekarz_id, pacjent_id) VALUES ("
                    + wizytaId
                    + ", DATE '" + wizyta.get("TERMIN")
                    + "'," + wizyta.get("STATUS")
                    + ", '" + wizyta.get("NAZWA")
                    + "', " + koszt
                    + ", " + wizyta.get("TYP")
                    + ", " + lekarzId
                    + ", " + pacjentId
                    + ")");

            dbDAO.commit();

        } catch (QueryException e) {
            System.err.println("Transaction failed; Rolling back");
            dbDAO.rollback();
        }
    }

}
