package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import gui.Pacjent;

public abstract class IControlerPacjent {
	private Pacjent m_pacjentWindow;
	
	IControlerPacjent(Pacjent pacjentWindow){
		m_pacjentWindow = pacjentWindow;
		
	}
	
	public void addWyszukajActionListener(){
		m_pacjentWindow.getBtnWyszukaj_1().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				findPacjent();
			}
		});
	}
	
	abstract public boolean checkUniqueValue(String key,String value);
	abstract public ArrayList<String> getPacjentData(String key,String value);
	
	public void setPacjentData(String key, String value) {
		
	}
	public void findPacjent(){
		String key = m_pacjentWindow.getChooseBox().toString();
		String value = m_pacjentWindow.getValue().getText();
		
		if(checkUniqueValue(key,value))
			setPacjentData(key,value);
		else
			m_pacjentWindow.getErrorField().setText("Podana wartosc nie jest unikalna");
	}



}
