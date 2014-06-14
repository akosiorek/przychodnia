package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

public class Pacjent extends JPanel {
	public Pacjent() {
		//initializePacjent(null);
	}
	private JTextField imie;
	private JTextField drugieImie;
	private JTextField nazwisko;
	private JTextField pesel;
	private JTextField telefon;
	private JButton Zatwierdz;
	private JPanel pakietyPacjenta;
	private JButton btnUsunPakiet;
	private JComboBox<String> listaPakietowDostepnych;
	private JButton btnDoadajPakiet;
	private JComboBox<String> chooseBox;
	private JTextField value;
	private JTextArea errorField;
	private JButton btnWyszukaj_1;
	private JButton btnUsunPacjenta_1;
	private DefaultListModel<String> listaPakietowPacjentaModel;
	private DefaultComboBoxModel<String> listaPakietowDostepnychModel;
	private JScrollPane scrollPane;
	private JList<String> listaPakietowPacjenta;
	
	
	public DefaultComboBoxModel<String> getListaPakietowDostepnychModel() {
		return listaPakietowDostepnychModel;
	}
	
	public DefaultListModel<String> getListaPakietowPacjentaModel() {
		return listaPakietowPacjentaModel;
	}

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

	public JButton getZatwierdz() {
		return Zatwierdz;
	}

	public JPanel getPakietyPacjenta() {
		return pakietyPacjenta;
	}

	public JButton getBtnUsunPakiet() {
		return btnUsunPakiet;
	}

	public JList<String> getListaPakietowPacjenta() {
		return listaPakietowPacjenta;
	}

	public JComboBox<String> getListaPakietowDostepnych() {
		return listaPakietowDostepnych;
	}

	public JButton getBtnDoadajPakiet() {
		return btnDoadajPakiet;
	}

	public JComboBox<String> getChooseBox() {
		return chooseBox;
	}

	public JTextField getValue() {
		return value;
	}

	public JTextArea getErrorField() {
		return errorField;
	}

	public JButton getBtnWyszukaj_1() {
		return btnWyszukaj_1;
	}

	public JButton getBtnUsunPacjenta_1() {
		return btnUsunPacjenta_1;
	}


	
	public void initializePacjent(JTabbedPane pacjenci){
		JPanel pacjent = new JPanel();
		pacjenci.addTab("Pacjent", null, pacjent, null);
		pacjent.setLayout(null);
		
		JLabel lblWyszukajPacjenta = new JLabel("Wyszukaj \r\npacjenta");
		lblWyszukajPacjenta.setBounds(20, 11, 126, 21);
		pacjent.add(lblWyszukajPacjenta);
		
		chooseBox = new JComboBox<String>();
		chooseBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Pesel", "Nazwisko", "Imie"}));
		chooseBox.setBounds(20, 43, 210, 21);
		pacjent.add(chooseBox);
		
		value = new JTextField();
		value.setBounds(20, 75, 210, 22);
		pacjent.add(value);
		
		errorField = new JTextArea();
		errorField.setLineWrap(true);
		errorField.setEditable(false);
		errorField.setBounds(20, 108, 210, 37);
		pacjent.add(errorField);
		
		btnWyszukaj_1 = new JButton("Wyszukaj");
		btnWyszukaj_1.setBounds(140, 10, 90, 23);
		pacjent.add(btnWyszukaj_1);
		
		btnUsunPacjenta_1 = new JButton("Usun pacjenta");
		btnUsunPacjenta_1.setBounds(104, 156, 126, 21);
		pacjent.add(btnUsunPacjenta_1);
			
		JTabbedPane zakladkiPacjenta = new JTabbedPane(JTabbedPane.TOP);
		zakladkiPacjenta.setBounds(0, 187, 240, 231);
		pacjent.add(zakladkiPacjenta);
		
		JPanel danePacjenta = new JPanel();
		zakladkiPacjenta.addTab("Dane pacjenta", null, danePacjenta, null);
		danePacjenta.setLayout(null);
		
		JLabel label_6 = new JLabel("Imie ");
		label_6.setBounds(10, 15, 52, 14);
		danePacjenta.add(label_6);
		
		JLabel label_7 = new JLabel("Drugie imie");
		label_7.setBounds(10, 44, 77, 14);
		danePacjenta.add(label_7);
		
		JLabel label_8 = new JLabel("Nazwisko");
		label_8.setBounds(10, 73, 77, 14);
		danePacjenta.add(label_8);
		
		JLabel label_9 = new JLabel("Pesel");
		label_9.setBounds(10, 102, 52, 14);
		danePacjenta.add(label_9);
		
		JLabel label_10 = new JLabel("Nr telefonu");
		label_10.setBounds(10, 131, 77, 14);
		danePacjenta.add(label_10);
		
		imie = new JTextField();
		imie.setText("IMIE");
		imie.setForeground(Color.LIGHT_GRAY);
		imie.setColumns(10);
		imie.setBounds(97, 11, 128, 20);
		danePacjenta.add(imie);
		
		drugieImie = new JTextField();
		drugieImie.setText("DRUGIE IMIE");
		drugieImie.setForeground(Color.LIGHT_GRAY);
		drugieImie.setColumns(10);
		drugieImie.setBounds(97, 41, 128, 20);
		danePacjenta.add(drugieImie);
		
		nazwisko = new JTextField();
		nazwisko.setText("NAZWISKO");
		nazwisko.setForeground(Color.LIGHT_GRAY);
		nazwisko.setColumns(10);
		nazwisko.setBounds(97, 73, 128, 20);
		danePacjenta.add(nazwisko);
		
		pesel = new JTextField();
		pesel.setText("PESEL");
		pesel.setForeground(Color.LIGHT_GRAY);
		pesel.setColumns(10);
		pesel.setBounds(97, 104, 128, 20);
		danePacjenta.add(pesel);
		
		telefon = new JTextField();
		telefon.setText("000 000 000");
		telefon.setForeground(Color.LIGHT_GRAY);
		telefon.setColumns(10);
		telefon.setBounds(97, 135, 128, 20);
		danePacjenta.add(telefon);
		
		Zatwierdz = new JButton("Zatwierdz zmiany");
		Zatwierdz.setBounds(78, 166, 147, 23);
		danePacjenta.add(Zatwierdz);
		
		pakietyPacjenta = new JPanel();
		zakladkiPacjenta.addTab("Pakiety pacjenta", null, pakietyPacjenta, null);
		pakietyPacjenta.setLayout(null);
		
		btnUsunPakiet = new JButton("Usun pakiet");
		btnUsunPakiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnUsunPakiet.setBounds(108, 96, 117, 23);
		pakietyPacjenta.add(btnUsunPakiet);
	
		listaPakietowDostepnychModel = new DefaultComboBoxModel<String>();
		listaPakietowDostepnych = new JComboBox<String>(listaPakietowDostepnychModel);
		listaPakietowDostepnych.setBounds(10, 132, 215, 23);
		pakietyPacjenta.add(listaPakietowDostepnych);
		
		btnDoadajPakiet = new JButton("Dodaj pakiet");
		btnDoadajPakiet.setBounds(108, 166, 117, 23);
		pakietyPacjenta.add(btnDoadajPakiet);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 215, 74);
		pakietyPacjenta.add(scrollPane);
		
		listaPakietowPacjentaModel = new DefaultListModel<String>();
		listaPakietowPacjenta = new JList<String>(listaPakietowPacjentaModel);
		listaPakietowPacjenta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listaPakietowPacjenta);
	}
}
