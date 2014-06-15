package controler;

import db.ConnectExpection;
import db.QueryException;
import db.dbDAO;
import gui.Pacjent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by adam on 6/14/14.
 */
public class ControlerPacjenta extends IControlerPacjent {

    private static final dbDAO db = new dbDAO();

    ControlerPacjenta(Pacjent pacjentWindow) {
        super(pacjentWindow);
    }

    @Override
    public MPair<Integer, HashMap<String, String>> checkDanePacjenta(String key, String value) {

        MPair<Integer, HashMap<String, String>> pair = new  MPair<Integer, HashMap<String, String>>();

        String sep = key.compareToIgnoreCase("pesel") == 0 ? "'" : "";
        String query = "SELECT imie, imie2, nazwisko, pesel, nr_tel, pakiet_id FROM pacjent where " +
                key + " = " + sep + value + sep;

        List<String[]> result = null;
        try {
            db.establishConnection();
            result = db.executeQueryList(query);
            db.closeConnection();
        } catch (QueryException e) {
            e.printStackTrace();
        } catch (ConnectExpection connectExpection) {
            connectExpection.printStackTrace();
        }

        pair.first = result.size();
        if(pair.first != 1) return pair;

        String[] values = result.get(0);
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("IMIE", values[0]);
        map.put("DRUGIE_IMIE", values[1]);
        map.put("NAZWISKO", values[2]);
        map.put("PESEL", values[3]);
        map.put("TELEFON", values[4]);

        String pakietId = values[5];
        query = "SELECT nazwa FROM pakiet WHERE id = " + pakietId;
        try {
            db.establishConnection();
            result = db.executeQueryList(query);
            db.closeConnection();
        } catch (QueryException e) {
            e.printStackTrace();
        } catch (ConnectExpection connectExpection) {
            connectExpection.printStackTrace();
        }
        map.put("PAKIET", result.get(0)[0]);

        pair.second = map;
        return pair;
    }

    @Override
    public ArrayList<String> readPakiety() {
        ArrayList<String> pakiety = new ArrayList<String>();
        String query = "SELECT nazwa FROM pakiet";
        try {
            db.establishConnection();
            ResultSet rs = db.executeQuery(query);
            while(rs.next()) {
                pakiety.add(rs.getString(1));
            }
            db.closeConnection();
        } catch (ConnectExpection connectExpection) {
            connectExpection.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (QueryException e) {
            e.printStackTrace();
        }

        return pakiety;
    }

    @Override
    public void removePacjent(String pesel) {

        String query = "DELETE FROM pacjent WHERE pesel = " + pesel;
        try {
            db.establishConnection();
            db.executeUpdate(query);
            db.closeConnection();
        } catch (QueryException e) {
            e.printStackTrace();
        } catch (ConnectExpection connectExpection) {
            connectExpection.printStackTrace();
        }
    }

    @Override
    public void updateDanePacjenta(HashMap<String, String> danePacjenta, String pesel) {

        StringBuilder builder = new StringBuilder();
        builder.append("UPDATE TABLE pacjent SET");
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

        try {
            db.establishConnection();
            db.executeUpdate(builder.toString());
            db.closeConnection();
        } catch (QueryException e) {
            e.printStackTrace();
        } catch (ConnectExpection connectExpection) {
            connectExpection.printStackTrace();
        }
    }

    @Override
    public void updatePakietPacjenta(String pakietPacjenta, String pesel) {

        String query = "UPDATE TABLE pacjent SET pakiet_id = " + pakietPacjenta
                + " WHERE pesel = " + pesel;
        try {
            db.establishConnection();
            db.executeUpdate(query);
            db.closeConnection();
        } catch (QueryException e) {
            e.printStackTrace();
        } catch (ConnectExpection connectExpection) {
            connectExpection.printStackTrace();
        }
    }
}
