package controler;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import gui.Rezerwacja;

public class ControlerRezerwacja extends IControlerRezerwacja{

	ControlerRezerwacja(Rezerwacja rezerwacjaWindow) {
		super(rezerwacjaWindow);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<String> znajdzLekarzy(Date data, String specjalizacja) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> readUslugi() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> readSpecjalisci() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MPair<Integer, HashMap<String, String>> checkDanePacjenta(
			String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

}
