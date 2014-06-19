package controler;

import gui.Historia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class IControlerHistoria {
		
	private Historia m_historyWindow;
	ControlerDanePacjenta controlerDanePacjenta;
	IControlerWizytyPrzyszle controlerWizytyPrzyszle;
	IControlerWizytyPrzeszle controlerWizytyPrzeszle;
	
	IControlerHistoria(Historia historyWindow){
        m_historyWindow = historyWindow;
		controlerDanePacjenta = new ControlerDanePacjenta(m_historyWindow.getDanePacjenta());
		controlerWizytyPrzyszle = new ControlerWizytyPrzyszle(m_historyWindow.getWizytyPrzyszle());
		controlerWizytyPrzeszle = new ControlerWizytyPrzeszle(m_historyWindow.getWizytyPrzeszle());

        m_historyWindow.getValueField().setText("91022806116");
        addWyszukajActionListener();
	}
	
	public void addWyszukajActionListener(){
		m_historyWindow.getBtnWyszukaj_2().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				findPacjent();
			}
		});
	}
	
	public void findPacjent(){
		String key = m_historyWindow.getWyszukajBox().getSelectedItem().toString();
		String value = m_historyWindow.getValueField().getText();
		MPair<Integer,HashMap<String,String>> pacjent = checkDanePacjenta(key,value);
		
		if (pacjent.first == 1){
			controlerDanePacjenta.setDanePacjenta(pacjent.second);
			String pesel = pacjent.second.get("PESEL");
			controlerWizytyPrzeszle.setPesel(pesel);
			controlerWizytyPrzyszle.setListaWizyt(findWizytyPrzyszle(pesel));
		}
		else if(pacjent.first > 0 )
			m_historyWindow.getErrorField().setText("Podana wartosc nie jest unikalna");
		else 
			m_historyWindow.getErrorField().setText("Nie istnieje pacjent posiadajacy podane dane");
	}
	
	abstract public MPair<Integer,HashMap<String,String> > checkDanePacjenta(String key,String value);
	abstract public List<String> findWizytyPrzyszle(String pesel);
}
