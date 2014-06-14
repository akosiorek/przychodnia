package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gui.NowyPacjent;

public abstract class IControlerNowyPacjent {

	NowyPacjent m_nowyPacjentWindow;

	public IControlerNowyPacjent(NowyPacjent nowyPacjentWindow){
		m_nowyPacjentWindow = nowyPacjentWindow;
		addActionZatwierdz();
		addActionAnuluj();
	}
	
	public void addActionZatwierdz(){
		m_nowyPacjentWindow.getBtnZatwierdz().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dodajPacjenta();
			}			
		});
	}
	public void addActionAnuluj(){
		m_nowyPacjentWindow.getBtnAnuluj().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				clearText();
			}			
		});
	}
	
	public boolean checkString(String string){
		if(string.length() == 0) return false;
		 Pattern p = Pattern.compile("[a-zA-Z]{"+Integer.toString(string.length())+"}");
		 Matcher m = p.matcher(string);
		 return  m.matches();
	}
	
	public boolean checkNumer(String numer){
		Pattern p = Pattern.compile("[0-9]{"+Integer.toString(numer.length())+"}");
		Matcher m = p.matcher(numer);
		return  m.matches();
	}
	public boolean checkPesel(String pesel){
		//System.out.println(pesel.length());
		if(pesel.length() != 11)
			return false;
		return checkNumer(pesel);
	}
	
	public boolean checkNrTelefonu(String numer){
		System.out.println(numer.length());
		if(numer.length() != 9)
			return false;
		return checkNumer(numer);
	}
	
	abstract public boolean zapiszDanePacjenta(ArrayList<String> dane);
	
	public void clearText(){
		
		m_nowyPacjentWindow.getTxtImie().setText("");
		m_nowyPacjentWindow.getTxtDrugieImie().setText("");
		m_nowyPacjentWindow.getTxtNazwisko().setText("");
		m_nowyPacjentWindow.getTxtPesel().setText("");
		m_nowyPacjentWindow.getTxtTelefon().setText("");
		m_nowyPacjentWindow.getTxtpnKomunikatBledu().setText("");
		m_nowyPacjentWindow.repaint();
		// TODO ewentualnie odswiezyc okno
	}
	public void textChange(boolean val){
		
		m_nowyPacjentWindow.getTxtImie().setEditable(val);
		m_nowyPacjentWindow.getTxtDrugieImie().setEditable(val);
		m_nowyPacjentWindow.getTxtNazwisko().setEditable(val);
		m_nowyPacjentWindow.getTxtPesel().setEditable(val);
		m_nowyPacjentWindow.getTxtTelefon().setEditable(val);
		// TODO ewentualnie odswiezyc okno
	}

	public boolean sprawdzDanePacjenta(ArrayList<String> out){
		m_nowyPacjentWindow.getTxtpnKomunikatBledu().setText("");
		m_nowyPacjentWindow.getTxtpnKomunikatBledu().setText("Sprawdzanie danych");
		textChange(false);
		
		if(!checkString(m_nowyPacjentWindow.getTxtImie().getText())){
			m_nowyPacjentWindow.getTxtpnKomunikatBledu().setText("Nie prawidlowe imie");
			textChange(true);
			return false;
		}
		else out.add(m_nowyPacjentWindow.getTxtImie().getText());
		
		if(!checkString(m_nowyPacjentWindow.getTxtDrugieImie().getText())){
			m_nowyPacjentWindow.getTxtpnKomunikatBledu().setText("Nie prawidlowe drugie imie");
			textChange(true);
			return false;
		}
		else out.add(m_nowyPacjentWindow.getTxtDrugieImie().getText());
		
		if(!checkString(m_nowyPacjentWindow.getTxtNazwisko().getText())){
			m_nowyPacjentWindow.getTxtpnKomunikatBledu().setText("Nie prawidlowe nazwisko");
			textChange(true);
			return false;
		}
		else out.add(m_nowyPacjentWindow.getTxtNazwisko().getText());
		
		if(!checkPesel(m_nowyPacjentWindow.getTxtPesel().getText())){
			m_nowyPacjentWindow.getTxtpnKomunikatBledu().setText("Nie prawidlowy pesel");
			textChange(true);
			return false;
		}
		else out.add(m_nowyPacjentWindow.getTxtPesel().getText());
		
		if(!checkNrTelefonu(m_nowyPacjentWindow.getTxtTelefon().getText())){
			m_nowyPacjentWindow.getTxtpnKomunikatBledu().setText("Nie prawidlowy numer telefonu");
			textChange(true);
			return false;
		}
		else out.add(m_nowyPacjentWindow.getTxtTelefon().getText());
		
		m_nowyPacjentWindow.getTxtpnKomunikatBledu().setText("Podane dane sa prawidlowe");
		textChange(true);
		return false;		
	}
	
	public boolean dodajPacjenta(){

		ArrayList<String> dane = new ArrayList<String>();
		if(!sprawdzDanePacjenta(dane)) 
			return false;
		if(zapiszDanePacjenta(dane))
			m_nowyPacjentWindow.getTxtpnKomunikatBledu().setText("Dane zapisane");
		else m_nowyPacjentWindow.getTxtpnKomunikatBledu().setText("Blad bazy danych. Skontaktuj sie z administratorem.");
		return true;
	}
}
