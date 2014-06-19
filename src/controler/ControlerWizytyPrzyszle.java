package controler;

import db.SafeDAO;
import gui.WizytyPrzyszle;

public class ControlerWizytyPrzyszle extends IControlerWizytyPrzyszle {

	ControlerWizytyPrzyszle(WizytyPrzyszle wizytyPrzyszle) {
		super(wizytyPrzyszle);
	}

	@Override
	public void removeWizyta(String wizyta) {


        String ID = wizyta.split(" ")[0];
        SafeDAO.update("DELETE FROM wizyta WHERE id = " + ID);
    }

}
