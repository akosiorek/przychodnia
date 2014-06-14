package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gui.Pacjent;

public abstract class IControlerPacjent {
	private Pacjent m_pacjentWindow;
	private HashMap<String,String> currentPacjent;
	
	IControlerPacjent(Pacjent pacjentWindow){
		m_pacjentWindow = pacjentWindow;
		initPakiety();
		addWyszukajActionListener();
		addUsunPacjentaActionListener();
	}
	
	public void addWyszukajActionListener(){
		m_pacjentWindow.getBtnWyszukaj_1().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				findPacjent();
			}
		});
	}
	
	public void addUsunPacjentaActionListener(){
		m_pacjentWindow.getBtnUsunPacjenta_1().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (CheckPacjent.checkPesel(m_pacjentWindow.getPesel().getText()))
					removePacjent(m_pacjentWindow.getPesel().getText());
			}			
		});
	}
	
	public void addDodajPakietActionListener(){
		m_pacjentWindow.getBtnDoadajPakiet().addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String pakiety = (String)(m_pacjentWindow.getListaPakietowDostepnych().getSelectedItem());
				updatePakietPacjenta(pakiety, true);
				m_pacjentWindow.getListaPakietowPacjentaModel().addElement(pakiety);
				m_pacjentWindow.repaint();
			}
			
		});
	}
	
	public void addUsunPakietActionListener(){
		m_pacjentWindow.getBtnUsunPakiet().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String pakiety = m_pacjentWindow.getListaPakietowPacjenta().getSelectedValue();
				updatePakietPacjenta(pakiety, false);
				m_pacjentWindow.getListaPakietowPacjentaModel().removeElement(pakiety);
				m_pacjentWindow.repaint();
				
			}
			
		});
	}
	
	public void addZatwierdzZmianyActionListener(){
		m_pacjentWindow.getZatwierdz().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(isDanePacjentaChanged()){
					if(isDanePacjentaValid()){
						HashMap<String,String> danePacjenta = new HashMap<String,String>();
						danePacjenta.put("IMIE",m_pacjentWindow.getImie().getText());
						danePacjenta.put("DRUGIE_IMIE",m_pacjentWindow.getDrugieImie().getText());
						danePacjenta.put("NAZWISKO",m_pacjentWindow.getNazwisko().getText());
						danePacjenta.put("PESEL",m_pacjentWindow.getPesel().getText());
						danePacjenta.put("TELEFON",m_pacjentWindow.getTelefon().getText());
						updateDanePacjenta(danePacjenta);
					}
					else 
						m_pacjentWindow.getErrorField().setText("Podano nieprawidlowe dane");
				}
			}
			
		});
	}
	
	
	public boolean isDanePacjentaChanged(){
		 if(currentPacjent.get("IMIE") != m_pacjentWindow.getImie().getText()) return true;
		 if(currentPacjent.get("DRUGIE_IMIE") != m_pacjentWindow.getDrugieImie().getText()) return true;
		 if(currentPacjent.get("NAZWISKO") != m_pacjentWindow.getNazwisko().getText()) return true;
		 if(currentPacjent.get("PESEL") != m_pacjentWindow.getPesel().getText()) return true;
		 if(currentPacjent.get("TELEFON") != m_pacjentWindow.getTelefon().getText()) return true;
		 return false;
	}
	
	public boolean isDanePacjentaValid(){
		if(!CheckPacjent.checkString(m_pacjentWindow.getImie().getText())){
			m_pacjentWindow.getErrorField().setText("Nie prawidlowe imie");
			return false;
		}
		
		if(!CheckPacjent.checkString(m_pacjentWindow.getDrugieImie().getText())){
			m_pacjentWindow.getErrorField().setText("Nie prawidlowe drugie imie");
			return false;
		}
		
		if(!CheckPacjent.checkString(m_pacjentWindow.getNazwisko().getText())){
			m_pacjentWindow.getErrorField().setText("Nie prawidlowe nazwisko");
			return false;
		}
		
		if(!CheckPacjent.checkPesel(m_pacjentWindow.getPesel().getText())){
			m_pacjentWindow.getErrorField().setText("Nie prawidlowy pesel");
			return false;
		}
		
		if(!CheckPacjent.checkNrTelefonu(m_pacjentWindow.getTelefon().getText())){
			m_pacjentWindow.getErrorField().setText("Nie prawidlowy numer telefonu");
			return false;
		}
		return true;
	}
	
	abstract public MPair<Integer,HashMap<String,String> > checkDanePacjenta(String key,String value);
	abstract public ArrayList<String> readPakiety();
	abstract public void removePacjent(String pesel);
	abstract public void updateDanePacjenta(HashMap<String,String> danePacjenta);
	abstract public void updatePakietPacjenta(String pakietPacjenta, boolean add);
	
	public void initPakiety(){
		ArrayList<String> pakiety = readPakiety();
		for( int i = 0; i < pakiety.size(); ++i)
			m_pacjentWindow.getListaPakietowDostepnychModel().addElement(pakiety.get(i));
	}
	
	public void clearPacjentData() {
		m_pacjentWindow.getImie().setText("");
		m_pacjentWindow.getDrugieImie().setText("");
		m_pacjentWindow.getNazwisko().setText("");
		m_pacjentWindow.getPesel().setText("");
		m_pacjentWindow.getTelefon().setText("");
		m_pacjentWindow.getListaPakietowPacjentaModel().removeAllElements();
		m_pacjentWindow.repaint();
	}
	
	public void setPacjentData(HashMap<String,String> danePacjenta) {
		currentPacjent = danePacjenta;
		m_pacjentWindow.getImie().setText(danePacjenta.get("IMIE"));
		m_pacjentWindow.getDrugieImie().setText(danePacjenta.get("DRUGIE_IMIE"));
		m_pacjentWindow.getNazwisko().setText(danePacjenta.get("NAZWISKO"));
		m_pacjentWindow.getPesel().setText(danePacjenta.get("PESEL"));
		m_pacjentWindow.getTelefon().setText(danePacjenta.get("TELEFON"));
		
		for( int i = 5; i < danePacjenta.size(); ++i)
			m_pacjentWindow.getListaPakietowPacjentaModel().addElement(danePacjenta.get("PAKIET" + Integer.toString(i)));
	}
	
	public void findPacjent(){
		String key = m_pacjentWindow.getChooseBox().toString();
		String value = m_pacjentWindow.getValue().getText();
		MPair<Integer,HashMap<String,String>> pacjent = checkDanePacjenta(key,value);
		
		if (pacjent.first == 1)
			setPacjentData(pacjent.second);
		else if(pacjent.first > 0 )
			m_pacjentWindow.getErrorField().setText("Podana wartosc nie jest unikalna");
		else 
			m_pacjentWindow.getErrorField().setText("Nie istnieje pacjent posiadajacy podane dane");
	}

}
