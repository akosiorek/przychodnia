package controler;

import db.ConnectExpection;
import db.QueryException;
import db.SafeDAO;
import db.dbDAO;
import gui.Pacjent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by adam on 6/14/14.
 */
public class ControlerPacjenta extends IControlerPacjent {

    ControlerPacjenta(Pacjent pacjentWindow) {
        super(pacjentWindow);
    }

    @Override
    public MPair<Integer, HashMap<String, String>> checkDanePacjenta(String key, String value) {

        MPair<Integer, HashMap<String, String>> pair = QueryManager.findPacjent(key, value);
        if(pair.first != 1) return pair;

        pair.second.put("PAKIET", QueryManager.pakietIdToName(pair.second.get("PAKIET_ID")));
        return pair;
    }

    @Override
    public ArrayList<String> readPakiety() {
        ArrayList<String> pakiety = new ArrayList<String>();
        String query = "SELECT nazwa FROM pakiet";
        List<String[]> results = SafeDAO.select(query);
        for(String[] result : results) {
            pakiety.add(result[0]);
        }
        return pakiety;
    }

    @Override
    public void removePacjent(String pesel) {

        String query = "DELETE FROM pacjent WHERE pesel = " + pesel;
        SafeDAO.update(query);
    }

    @Override
    public void updateDanePacjenta(HashMap<String, String> danePacjenta, String pesel) {

        StringBuilder builder = new StringBuilder();
        builder.append("UPDATE pacjent SET");
        Iterator it = danePacjenta.entrySet().iterator();
        while(it.hasNext()) {

            Map.Entry<String, String> entry = (Map.Entry<String, String>)it.next();
            String sep = entry.getKey().equalsIgnoreCase("PESEL")
                    || entry.getKey().equalsIgnoreCase("TELEFON") ? "'" : "";

            builder.append(" ");
            builder.append(entry.getKey());
            builder.append(" = ");
            builder.append(sep);
            builder.append(entry.getValue());
            builder.append(sep);
            if(it.hasNext()) {
                builder.append(",");
            }
        }

        builder.append("WHERE pesel = ");
        builder.append(pesel);

        SafeDAO.update(builder.toString());
    }

    @Override
    public void updatePakietPacjenta(String pakietPacjenta, String pesel) {

        String query = "UPDATE pacjent SET pakiet_id = (SELECT id FROM pakiet WHERE nazwa = '" +
                pakietPacjenta + "') WHERE pesel = " + pesel;

        SafeDAO.update(query);
    }
}

