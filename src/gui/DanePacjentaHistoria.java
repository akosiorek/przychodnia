package gui;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class DanePacjentaHistoria extends IDanePacjenta {

	public void init(JTabbedPane dane){
		dane.addTab("Pacjent", null, this, null);
		this.setLayout(null);
		
		JPanel zdjecie = new JPanel();
		zdjecie.setBounds(368, 11, 158, 187);
		this.add(zdjecie);
		
		JLabel label = new JLabel("Imie ");
		label.setBounds(33, 25, 66, 14);
		this.add(label);
		
		JLabel label_1 = new JLabel("Drugie imie");
		label_1.setBounds(33, 64, 86, 14);
		this.add(label_1);
		
		JLabel label_2 = new JLabel("Nazwisko");
		label_2.setBounds(33, 103, 86, 14);
		this.add(label_2);
		
		JLabel label_3 = new JLabel("Pesel");
		label_3.setBounds(33, 142, 66, 14);
		this.add(label_3);
		
		JLabel label_4 = new JLabel("Nr telefonu");
		label_4.setBounds(33, 181, 86, 14);
		this.add(label_4);
		
		imie = new JTextField();
		imie.setEditable(false);
		imie.setText("IMIE");
		imie.setForeground(Color.LIGHT_GRAY);
		imie.setColumns(10);
		imie.setBounds(146, 20, 86, 20);
		this.add(imie);
		
		drugieImie = new JTextField();
		drugieImie.setEditable(false);
		drugieImie.setText("DRUGIE IMIE");
		drugieImie.setForeground(Color.LIGHT_GRAY);
		drugieImie.setColumns(10);
		drugieImie.setBounds(146, 60, 86, 20);
		this.add(drugieImie);
		
		nazwisko = new JTextField();
		nazwisko.setEditable(false);
		nazwisko.setText("NAZWISKO");
		nazwisko.setForeground(Color.LIGHT_GRAY);
		nazwisko.setColumns(10);
		nazwisko.setBounds(146, 100, 86, 20);
		this.add(nazwisko);
		
		pesel = new JTextField();
		pesel.setEditable(false);
		pesel.setText("PESEL");
		pesel.setForeground(Color.LIGHT_GRAY);
		pesel.setColumns(10);
		pesel.setBounds(146, 140, 86, 20);
		this.add(pesel);
		
		telefon = new JTextField();
		telefon.setEditable(false);
		telefon.setText("000 000 000");
		telefon.setForeground(Color.LIGHT_GRAY);
		telefon.setColumns(10);
		telefon.setBounds(146, 180, 86, 20);
		this.add(telefon);
	}
}
