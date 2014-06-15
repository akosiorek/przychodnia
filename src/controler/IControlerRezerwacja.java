package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import gui.OknoWizyty;
import gui.Rezerwacja;

public abstract class IControlerRezerwacja {
	Rezerwacja m_rezerwacjaWindow;
	IControlerOknoWizyty controlerOknoWizyty;
	ControlerDanePacjenta controlerDanePacjenta;
	
	public Rezerwacja getM_rezerwacjaWindow() {
		return m_rezerwacjaWindow;
	}

	public IControlerOknoWizyty getControlerOknoWizyty() {
		return controlerOknoWizyty;
	}

	public ControlerDanePacjenta getControlerDanePacjenta() {
		return controlerDanePacjenta;
	}

	IControlerRezerwacja (Rezerwacja rezerwacjaWindow){
		m_rezerwacjaWindow = rezerwacjaWindow;
		controlerDanePacjenta = new ControlerDanePacjenta(m_rezerwacjaWindow.getDanePacjenta());
		controlerOknoWizyty = new ControlerOknoWizyty();
	}
	
	public void addWyszukajActionListener(){
		m_rezerwacjaWindow.getBtnWyszukaj().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				findPacjent();
			}
		});
	}
	
	public void addWyszukajLekarzyActionListener(){
		m_rezerwacjaWindow.getWyszukajLekarza().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				wyswietlLekarzy();
			}
		});		
	}
	
	
	public void addUtworzWizyteActionListener(){
		m_rezerwacjaWindow.getWyszukajLekarza().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				HashMap<String,String> wizyta = utworzWizyte();
				if(wizyta != null)
					controlerOknoWizyty.createOknoWizyty(wizyta);
			}
		});
	}
		
	public void findPacjent(){
		String key = m_rezerwacjaWindow.getWyszukajBox().toString();
		String value = m_rezerwacjaWindow.getValueField().getText();
		MPair<Integer,HashMap<String,String>> pacjent = checkDanePacjenta(key,value);
		
		if (pacjent.first == 1)
			controlerDanePacjenta.setDanePacjenta(pacjent.second);
		else if(pacjent.first > 0 )
			m_rezerwacjaWindow.getErrorField().setText("Podana wartosc nie jest unikalna");
		else 
			m_rezerwacjaWindow.getErrorField().setText("Nie istnieje pacjent posiadajacy podane dane");
	}
	
	public void initUslugi(){
		ArrayList<String> pakiety = readUslugi();
		for( int i = 0; i < pakiety.size(); ++i)
			m_rezerwacjaWindow.getListaUslug().addElement(pakiety.get(i));
	}
	
	public void initSpecjalisci(){
		ArrayList<String> uslugi = readUslugi();
		for( int i = 0; i < uslugi.size(); ++i)
			m_rezerwacjaWindow.getListaSpecjalistow().addElement(uslugi.get(i));
	}
	
	public void wyswietlLekarzy(){
		Date data = m_rezerwacjaWindow.getKalendarzLekarza().getDate();
		String specjalizacja = m_rezerwacjaWindow.getSpecjalisci().getSelectedValue();
		ArrayList<String> lekarze = znajdzLekarzy(data,specjalizacja);
		m_rezerwacjaWindow.getListaLekarzy().removeAllElements();
		for( int i = 0; i < lekarze.size(); ++i)
			m_rezerwacjaWindow.getListaLekarzy().addElement(lekarze.get(i));
	}
	
	public HashMap<String,String> utworzWizyte(){
		HashMap<String,String> wizyta = new HashMap<String,String>();
		if(CheckPacjent.checkNumer(m_rezerwacjaWindow.getKoszt().getText()))
			wizyta.put("KOSZT",  m_rezerwacjaWindow.getKoszt().getText());
		else {
			m_rezerwacjaWindow.getErrorField().setText("Nieprawidlowa wartosc kosztu");
			return null;
		}
		wizyta.put("TERMIN", m_rezerwacjaWindow.getKalendarzLekarza().getDate().toString());
		wizyta.put("LEKARZ", m_rezerwacjaWindow.getLekarze().getSelectedValue());
		wizyta.put("IMIE",  m_rezerwacjaWindow.getDanePacjenta().getImie().getText());
		wizyta.put("NAZWISKO",  m_rezerwacjaWindow.getDanePacjenta().getNazwisko().getText());
		wizyta.put("DRUGIE_IMIE",  m_rezerwacjaWindow.getDanePacjenta().getDrugieImie().getText());
		wizyta.put("PESEL",  m_rezerwacjaWindow.getDanePacjenta().getPesel().getText());
		wizyta.put("STATUS", "0");
		wizyta.put("NAZWA", "nazwa to nie notatka");
		wizyta.put("TYP",  m_rezerwacjaWindow.getUslugi().getSelectedItem().toString());
		return wizyta;
	}
	
	abstract public ArrayList<String> znajdzLekarzy(Date data, String specjalizacja);
	abstract public ArrayList<String> readUslugi();
	abstract public ArrayList<String> readSpecjalisci();
	abstract public MPair<Integer,HashMap<String,String> > checkDanePacjenta(String key,String value);
	
}
