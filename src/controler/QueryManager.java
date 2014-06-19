package controler;

import db.SafeDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by adam on 6/19/14.
 */
public class QueryManager {

    static public MPair<Integer, HashMap<String, String>> findPacjent(String searchKey, String value) {

        MPair<Integer, HashMap<String, String>> pair = new  MPair<Integer, HashMap<String, String>>();

        String sep = searchKey.equalsIgnoreCase("pesel") ? "" : "'";
        String query = "SELECT imie, imie2, nazwisko, pesel, nr_tel, pakiet_id FROM pacjent where " +
                searchKey + " = " + sep + value + sep;

        List<String[]> result = SafeDAO.select(query);

        pair.first = result.size();
        if(pair.first != 1) return pair;

        String[] values = result.get(0);
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("IMIE", values[0]);
        map.put("DRUGIE_IMIE", values[1]);
        map.put("NAZWISKO", values[2]);
        map.put("PESEL", values[3]);
        map.put("TELEFON", values[4]);
        map.put("PAKIET_ID", values[5]);

        pair.second = map;
        return pair;
    }

    static public String pakietIdToName(String ID) {

        return SafeDAO.select("SELECT nazwa FROM pakiet WHERE id = " + ID).get(0)[0];
    }


    static List<String> findWizyty(String pesel, java.sql.Date date, String relOp) {

        ArrayList<String> wizyty = new ArrayList<String>();
        String query = "SELECT * FROM wizyta WHERE termin " + relOp + " DATE '" + date.toString() + "'";
        List<String[]> results = SafeDAO.select(query, true);

        results.get(0)[1] += "                  ";

        for(String[] result : results) {
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < result.length; ++i) {

                builder.append(result[i]);
                int length = result[i] != null ? result[i].length() : 4;
                System.out.println(Math.abs(results.get(0)[i].length() - length));
                for(int j = 0; j < Math.abs(results.get(0)[i].length() - length) + 2; ++j) {
                    builder.append(" ");
                }

            }
            wizyty.add(builder.toString());
        }
        return wizyty;
    }
}
