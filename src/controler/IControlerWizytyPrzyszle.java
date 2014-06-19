package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import gui.WizytyPrzyszle;

public abstract class IControlerWizytyPrzyszle {

	private WizytyPrzyszle m_wizytyPrzyszle;
	
	IControlerWizytyPrzyszle(WizytyPrzyszle wizytyPrzyszle){
		m_wizytyPrzyszle = wizytyPrzyszle;

        addUsunWizyteActionListener();
	}
	
	public void setListaWizyt(List<String> lista){
		m_wizytyPrzyszle.getListaWizytModel().removeAllElements();
		for (String elem : lista)
			m_wizytyPrzyszle.getListaWizytModel().addElement(elem);
	}
	

	abstract public void removeWizyta(String wizyta) ;
	
	public void addUsunWizyteActionListener(){
		m_wizytyPrzyszle.getBtnUsunWizyte().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String wizyta = m_wizytyPrzyszle.getListaWizyt().getSelectedValue();
				m_wizytyPrzyszle.getListaWizytModel().removeElement(wizyta);
				removeWizyta(wizyta);
				m_wizytyPrzyszle.repaint();
			}
		
		});
	}
}
