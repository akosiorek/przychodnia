package gui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Historia extends JPanel {
	public Historia() {
		//initHistoria(null);
	}

	DanePacjenta danePacjenta;
	WizytyPrzeszle wizytyPrzeszle;
	WizytyPrzyszle wizytyPrzyszle;
	
	public void initHistoria(JTabbedPane panelWizyt){
		
		panelWizyt.addTab("Historia wizyt", null, this, null);
		this.setLayout(null);
		
		JPanel wyszukaj = new JPanel();
		wyszukaj.setBounds(0, 0, 567, 154);
		this.add(wyszukaj);
		wyszukaj.setLayout(null);
		
		JLabel lblWyszukajPo_1 = new JLabel("Wyszukaj pacjenta");
		lblWyszukajPo_1.setBounds(23, 11, 141, 21);
		wyszukaj.add(lblWyszukajPo_1);
		
		JComboBox wyszukajBox = new JComboBox();
		wyszukajBox.setBounds(174, 11, 199, 21);
		wyszukaj.add(wyszukajBox);
		
		JTextField valueField_2 = new JTextField();
		valueField_2.setBounds(174, 43, 199, 22);
		wyszukaj.add(valueField_2);
		
		JTextField errorField_2 = new JTextField();
		errorField_2.setEditable(false);
		errorField_2.setBounds(174, 76, 199, 21);
		wyszukaj.add(errorField_2);
		
		JButton btnWyszukaj_2 = new JButton("Wyszukaj");
		btnWyszukaj_2.setBounds(174, 108, 89, 23);
		wyszukaj.add(btnWyszukaj_2);
		
		JTabbedPane dane = new JTabbedPane(JTabbedPane.TOP);
		dane.setBounds(0, 165, 557, 251);
		this.add(dane);
		
		danePacjenta = new DanePacjenta();
		danePacjenta.init(dane);
		
		wizytyPrzeszle = new WizytyPrzeszle();
		wizytyPrzeszle.init(dane);
		
		wizytyPrzyszle = new WizytyPrzyszle();
		wizytyPrzyszle.init(dane);
		
	}
}
