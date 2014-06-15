package controler;

import java.util.HashMap;

import gui.DanePacjentaHistoria;
import gui.DanePacjentaRezerwacja;
import gui.IDanePacjenta;

public class ControlerDanePacjenta {

	IDanePacjenta m_danePacjenta;
	
	ControlerDanePacjenta(IDanePacjenta danePacjentaRezerwacja){
		m_danePacjenta = danePacjentaRezerwacja;
	}
	
	public void setDanePacjenta(HashMap<String,String> dane){
		m_danePacjenta.getImie().setText(dane.get("IMIE"));
		m_danePacjenta.getDrugieImie().setText(dane.get("DRUGIE_IMIE"));
		m_danePacjenta.getNazwisko().setText(dane.get("NAZWISKO"));
		m_danePacjenta.getPesel().setText(dane.get("PESEL"));
		m_danePacjenta.getTelefon().setText(dane.get("TELEFON"));
		m_danePacjenta.repaint();
	}
}
