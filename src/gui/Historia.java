package gui;

import javax.swing.DefaultComboBoxModel;
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
	JComboBox<String> wyszukajBox;
	JTextField valueField;
	JTextField errorField;
	JButton btnWyszukaj_2;
	
	public JButton getBtnWyszukaj_2() {
		return btnWyszukaj_2;
	}


	public JComboBox<String> getWyszukajBox() {
		return wyszukajBox;
	}


	public JTextField getValueField() {
		return valueField;
	}


	public JTextField getErrorField() {
		return errorField;
	}


	public DanePacjenta getDanePacjenta() {
		return danePacjenta;
	}


	public WizytyPrzeszle getWizytyPrzeszle() {
		return wizytyPrzeszle;
	}


	public WizytyPrzyszle getWizytyPrzyszle() {
		return wizytyPrzyszle;
	}


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
		
		wyszukajBox = new JComboBox<String>(new DefaultComboBoxModel<String>(new String[] {"Pesel", "Nazwisko", "Imie"}));
		wyszukajBox.setBounds(174, 11, 199, 21);
		wyszukaj.add(wyszukajBox);
		
		valueField = new JTextField();
		valueField.setBounds(174, 43, 199, 22);
		wyszukaj.add(valueField);
		
		errorField = new JTextField();
		errorField.setEditable(false);
		errorField.setBounds(174, 76, 199, 21);
		wyszukaj.add(errorField);
		
		btnWyszukaj_2 = new JButton("Wyszukaj");
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
