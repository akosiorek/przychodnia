package controler;

import java.util.HashMap;

import gui.DanePacjenta;

public class ControlerDanePacjenta {

	DanePacjenta m_danePacjenta;
	
	ControlerDanePacjenta(DanePacjenta danePacjenta){
		m_danePacjenta = danePacjenta;
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
