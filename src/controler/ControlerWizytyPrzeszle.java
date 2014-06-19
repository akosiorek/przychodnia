package controler;

import java.util.Date;
import java.util.List;

import gui.WizytyPrzeszle;

public class ControlerWizytyPrzeszle extends IControlerWizytyPrzeszle {

	ControlerWizytyPrzeszle(WizytyPrzeszle wizytyPrzeszle) {
		super(wizytyPrzeszle);
	}

	@Override
	public List<String> checkWizyty(Date dataOd, Date dataDo, String pesel) {
        return QueryManager.findWizyty(pesel, new java.sql.Date(dataDo.getTime()), "<");
	}

}
