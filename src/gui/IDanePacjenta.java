package gui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public abstract class IDanePacjenta extends JPanel{
	protected JTextField imie;
	protected JTextField drugieImie;
	protected JTextField nazwisko;
	protected JTextField pesel;
	protected JTextField telefon;
	
	public JTextField getImie() {
		return imie;
	}

	public JTextField getDrugieImie() {
		return drugieImie;
	}

	public JTextField getNazwisko() {
		return nazwisko;
	}

	public JTextField getPesel() {
		return pesel;
	}

	public JTextField getTelefon() {
		return telefon;
	}

}
