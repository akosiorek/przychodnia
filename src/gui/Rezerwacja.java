package gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.List;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;

public class Rezerwacja extends JPanel {
	public Rezerwacja() {
		//init(null);
	}
	
	private DanePacjentaRezerwacja danePacjenta;
	JComboBox<String> wyszukajBox;
	JTextField valueField;
	JTextField errorField;
	JButton btnWyszukaj;
	JCalendar kalendarzLekarza;
	JButton utworzWizyte;
	JComboBox<String> uslugi;
	private DefaultComboBoxModel<String> listaUslug;
	JButton wyszukajLekarza;
	private DefaultListModel<String> listaSpecjalistow;
	private DefaultListModel<String> listaLekarzy;
	JList<String> specjalisci;
	JList<String> lekarze;
	private JTextField koszt;
	
	public JTextField getKoszt() {
		return koszt;
	}

	public DefaultComboBoxModel<String> getListaUslug() {
		return listaUslug;
	}

	public DefaultListModel<String> getListaSpecjalistow() {
		return listaSpecjalistow;
	}

	public DefaultListModel<String> getListaLekarzy() {
		return listaLekarzy;
	}

	public DanePacjentaRezerwacja getDanePacjenta() {
		return danePacjenta;
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

	public JButton getBtnWyszukaj() {
		return btnWyszukaj;
	}

	public JList<String> getSpecjalisci() {
		return specjalisci;
	}

	public JList<String> getLekarze() {
		return lekarze;
	}

	public JCalendar getKalendarzLekarza() {
		return kalendarzLekarza;
	}


	public JButton getUtworzWizyte() {
		return utworzWizyte;
	}

	public JComboBox<String> getUslugi() {
		return uslugi;
	}

	public JButton getWyszukajLekarza() {
		return wyszukajLekarza;
	}

	public void init(JTabbedPane panelWizyt){
		
		panelWizyt.addTab("Rezerwacja wizyty", null, this, null);
		this.setLayout(null);
		
		JPanel panelWyszukaj = new JPanel();
		panelWyszukaj.setLayout(null);
		panelWyszukaj.setBounds(0, 0, 567, 154);
		this.add(panelWyszukaj);
		
		JLabel lblWyszukajPacjenta = new JLabel("Wyszukaj pacjenta");
		lblWyszukajPacjenta.setBounds(20, 8, 110, 21);
		panelWyszukaj.add(lblWyszukajPacjenta);
		
		wyszukajBox = new JComboBox<String>();
		wyszukajBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Pesel", "Nazwisko", "Imie"}));
		wyszukajBox.setBounds(20, 29, 198, 21);
		panelWyszukaj.add(wyszukajBox);
		
		valueField = new JTextField();
		valueField.setBounds(20, 64, 198, 22);
		panelWyszukaj.add(valueField);
		
		errorField = new JTextField();
		errorField.setEditable(false);
		errorField.setBounds(20, 97, 198, 21);
		panelWyszukaj.add(errorField);
		
		btnWyszukaj = new JButton("Wyszukaj");
		btnWyszukaj.setBounds(129, 129, 89, 23);
		panelWyszukaj.add(btnWyszukaj);
		
		danePacjenta = new DanePacjentaRezerwacja();
		danePacjenta.init(panelWyszukaj);
		
		kalendarzLekarza = new JCalendar();
		kalendarzLekarza.setBounds(377, 194, 169, 154);
		this.add(kalendarzLekarza);
		
		utworzWizyte = new JButton("Utworz wizyte");
		utworzWizyte.setBounds(377, 387, 150, 20);
		this.add(utworzWizyte);
		
		JLabel lblNewLabel_1 = new JLabel("Lekarz specjalista");
		lblNewLabel_1.setBounds(24, 176, 123, 14);
		this.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Lekarze");
		lblNewLabel_2.setBounds(166, 176, 46, 14);
		this.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Rodzaj uslugi");
		lblNewLabel_3.setBounds(166, 362, 150, 14);
		this.add(lblNewLabel_3);
		
		listaUslug = new DefaultComboBoxModel<String>();
		uslugi = new JComboBox<String>(listaUslug);
		uslugi.setBounds(166, 387, 193, 20);
		this.add(uslugi);
		
		wyszukajLekarza = new JButton("Wyszukaj");
		wyszukajLekarza.setBounds(24, 328, 123, 23);
		this.add(wyszukajLekarza);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 196, 123, 121);
		add(scrollPane);
		
		listaSpecjalistow = new DefaultListModel<String>();
		specjalisci = new JList<String>(listaSpecjalistow);
		specjalisci.setSize(123, 119);
		scrollPane.setViewportView(specjalisci);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(166, 194, 193, 154);
		add(scrollPane_1);
		
		listaLekarzy = new DefaultListModel<String>();
		lekarze = new JList<String>(listaLekarzy);
		scrollPane_1.setViewportView(lekarze);
		
		JLabel lblKoszt = new JLabel("Koszt");
		lblKoszt.setBounds(24, 362, 123, 14);
		add(lblKoszt);
		
		koszt = new JTextField();
		koszt.setBounds(24, 387, 123, 20);
		add(koszt);
		koszt.setColumns(10);
	}
}
