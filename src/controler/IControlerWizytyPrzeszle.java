package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import gui.WizytyPrzeszle;

public abstract class IControlerWizytyPrzeszle {

	private WizytyPrzeszle m_wizytyPrzeszle;
	private String pesel;
	
	public WizytyPrzeszle getM_wizytyPrzeszle() {
		return m_wizytyPrzeszle;
	}

	public String getPesel() {
		return pesel;
	}

	IControlerWizytyPrzeszle(WizytyPrzeszle wizytyPrzeszle){
		m_wizytyPrzeszle = wizytyPrzeszle;
	}
	
	public void setListaWizyt(ArrayList<String> lista){
		String text = m_wizytyPrzeszle.getWizyty().getText();
		for (String elem : lista)
			text = "\n" + elem;
		m_wizytyPrzeszle.getWizyty().setText(text);
		m_wizytyPrzeszle.repaint();
	}
	

	abstract public ArrayList<String> checkWizyty(Date dataOd, Date dataDo,String pesel) ;
	
	public void addWyszukajWizyteActionListener(){
		m_wizytyPrzeszle.getBtnWyszukaj().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setListaWizyt(checkWizyty(m_wizytyPrzeszle.getDataOd().getDate(),m_wizytyPrzeszle.getDataOd().getDate(),pesel));
			}
		
		});
	}
}
