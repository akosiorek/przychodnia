package controler;

import db.ConnectExpection;
import db.QueryException;
import db.SafeDAO;
import db.dbDAO;
import org.joda.time.DateTime;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ControlerOknoLogowania extends IControlerOknoLogowania {

    private static final String CONFIG_FILE = "resources//placowka.properties";
    private static final String ID_KEY = "ID";
    private static int ID;

    private String nazwa;
    private String nrTelefonu;
    private String adres;
    private Map<String, Hours> days;
    private static final Map<Integer, String> intToDayMap;

    static {
        Map<Integer, String> aMap = new TreeMap<Integer, String>();
        aMap.put(1, "poniedzialek");
        aMap.put(2, "wtorek");
        aMap.put(3, "sroda");
        aMap.put(4, "czwartek");
        aMap.put(5, "piatek");
        aMap.put(6, "sobota");
        aMap.put(7, "niedziela");
        intToDayMap = Collections.unmodifiableMap(aMap);

        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(CONFIG_FILE));

            ID = Integer.valueOf(prop.getProperty(ID_KEY));

        } catch(IOException e) {
            System.err.println("Couldn't load configuration file");
            System.err.println(e.getMessage());
        }
    }

	public ControlerOknoLogowania(ControlerOkien controler) {
		super(controler);
        String nameQuery = "SELECT nazwa, nr_tel, adres FROM placowka WHERE id = " + Integer.toString(ID);
        String daysQuery = "SELECT dzien_tyg, od, do FROM godziny_przyjec WHERE placowka_id = " + Integer.toString(ID);

        days = new TreeMap<String, Hours>();
        List<String[]> params = SafeDAO.select(nameQuery);
        List<String[]> daysResult = SafeDAO.select(daysQuery);

        for(String[] day : daysResult) {
            days.put(intToDayMap.get(Integer.valueOf(day[0])), new Hours(day[1], day[2]));
        }

        if(params.isEmpty()) {
            nazwa = nrTelefonu = adres = "BRAK WARTOŚCI";
        } else {
            nazwa = params.get(0)[0];
            nrTelefonu = params.get(0)[1];
            adres = params.get(0)[2];
        }

        displayDanePrzychodni();
    }

	@Override
	public Map<String, Hours> readDays() {
		return days;
	}

	@Override
	public String readNazwa() {
		return nazwa;
	}

	@Override
	public String readNrTelefonu() {
		return nrTelefonu;
	}

	@Override
	public String readAdres() {
		return adres;
	}

	@Override
	public boolean validatePassword(String login, String password) {
		// TODO Auto-generated method stub
		return true;
	}
}
