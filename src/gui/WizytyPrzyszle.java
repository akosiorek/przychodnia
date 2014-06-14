package gui;

import java.awt.Panel;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class WizytyPrzyszle extends JPanel{
	WizytyPrzyszle(){
		// init(null);
	}
	

	private DefaultListModel<String> listaWizytModel;
	private JList<String> listaWizyt;
	private JButton btnUsunWizyte;
	
	public DefaultListModel<String> getListaWizytModel() {
		return listaWizytModel;
	}

	public JList<String> getListaWizyt() {
		return listaWizyt;
	}

	public JButton getBtnUsunWizyte() {
		return btnUsunWizyte;
	}

	public void init(JTabbedPane dane){
		dane.addTab("Wizyty przyszle", null, this, null);
		this.setLayout(null);
		
		listaWizytModel = new DefaultListModel<String>();
		listaWizyt = new JList<String>(listaWizytModel);
		listaWizyt.setBounds(10, 11, 532, 149);
		this.add(listaWizyt);
		
		btnUsunWizyte = new JButton("Usun wizyte");
		btnUsunWizyte.setBounds(10, 177, 127, 23);
		this.add(btnUsunWizyte);
	}
}
