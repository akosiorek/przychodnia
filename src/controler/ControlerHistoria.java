package controler;

import java.util.HashMap;
import java.util.List;

import gui.Historia;

public class ControlerHistoria extends IControlerHistoria {

	ControlerHistoria(Historia historyWindow) {
		super(historyWindow);
	}

	@Override
	public MPair<Integer, HashMap<String, String>> checkDanePacjenta(
			String key, String value) {

		return QueryManager.findPacjent(key, value);
	}

	@Override
	public List<String> findWizytyPrzyszle(String pesel) {

        return QueryManager.findWizyty(pesel, new java.sql.Date(new java.util.Date().getTime()), ">");
	}

}
