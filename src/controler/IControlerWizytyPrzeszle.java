package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gui.WizytyPrzeszle;

public abstract class IControlerWizytyPrzeszle {

	private WizytyPrzeszle m_wizytyPrzeszle;
	private String pesel;
	
	public WizytyPrzeszle getWizytyPrzeszle() {
		return m_wizytyPrzeszle;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	IControlerWizytyPrzeszle(WizytyPrzeszle wizytyPrzeszle){
		m_wizytyPrzeszle = wizytyPrzeszle;
	}
	
	public void setListaWizyt(List<String> lista){
		String text = m_wizytyPrzeszle.getWizyty().getText();
		for (String elem : lista)
			text = "\n" + elem;
		m_wizytyPrzeszle.getWizyty().setText(text);
		m_wizytyPrzeszle.repaint();
	}
	

	abstract public List<String> checkWizyty(Date dataOd, Date dataDo, String pesel) ;
	
	public void addWyszukajWizyteActionListener(){
		m_wizytyPrzeszle.getBtnWyszukaj().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(CheckPacjent.checkPesel(pesel))
					setListaWizyt(checkWizyty(m_wizytyPrzeszle.getDataOd().getDate(),m_wizytyPrzeszle.getDataOd().getDate(),pesel));
			}
		
		});
	}
}
