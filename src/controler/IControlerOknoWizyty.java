package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import gui.OknoWizyty;

public abstract class IControlerOknoWizyty {
	OknoWizyty m_oknoWizyty;
	HashMap<String,String> m_wizyta;
	IControlerOknoWizyty(){	}

	public void createOknoWizyty(HashMap<String,String> wizyta){
		m_oknoWizyty = new OknoWizyty();
		m_oknoWizyty.getImie().setText(wizyta.get("IMIE"));
		m_oknoWizyty.getNazwisko().setText(wizyta.get("NAZWISKO"));
		m_oknoWizyty.getDrugieImie().setText(wizyta.get("DRUGIE_IMIE"));
		m_oknoWizyty.getPesel().setText(wizyta.get("PESEL"));
		m_oknoWizyty.getLekarz().setText(wizyta.get("LEKARZ"));
		m_oknoWizyty.getData().setText(wizyta.get("TERMIN"));
		m_oknoWizyty.getTypUslugi().setText(wizyta.get("TYP"));
		m_oknoWizyty.getKoszt().setText(wizyta.get("KOSZT"));
		m_wizyta = wizyta;
		addZatwierdzActionListener();
		addAnulujActionListener();
		m_oknoWizyty.setVisible(true);
	}
	
	public void addZatwierdzActionListener(){
		m_oknoWizyty.getZatwierdz().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				utworzWizyte(m_wizyta);
				m_oknoWizyty.dispose();
			}
			
		});
	}
	
	public void addAnulujActionListener(){
		m_oknoWizyty.getAnuluj().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				m_oknoWizyty.dispose();
			}
			
		});
	}
	
	abstract public void utworzWizyte(HashMap<String,String> wizyta);
}
