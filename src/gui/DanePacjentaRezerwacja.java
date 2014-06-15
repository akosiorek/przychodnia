package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class DanePacjentaRezerwacja extends IDanePacjenta {

	public void init(JPanel panelWyszukaj) {
		JLabel label_12 = new JLabel("Imie ");
		label_12.setBounds(301, 42, 52, 14);
		panelWyszukaj.add(label_12);
		
		JLabel label_13 = new JLabel("Drugie imie");
		label_13.setBounds(301, 70, 78, 14);
		panelWyszukaj.add(label_13);
		
		JLabel label_14 = new JLabel("Nazwisko");
		label_14.setBounds(301, 98, 78, 14);
		panelWyszukaj.add(label_14);
		
		JLabel label_15 = new JLabel("Pesel");
		label_15.setBounds(301, 126, 52, 14);
		panelWyszukaj.add(label_15);
		
		imie = new JTextField();
		imie.setText("IMIE");
		imie.setForeground(Color.LIGHT_GRAY);
		imie.setEditable(false);
		imie.setColumns(10);
		imie.setBounds(414, 29, 120, 20);
		panelWyszukaj.add(imie);
		
		drugieImie = new JTextField();
		drugieImie.setText("DRUGIE IMIE");
		drugieImie.setForeground(Color.LIGHT_GRAY);
		drugieImie.setEditable(false);
		drugieImie.setColumns(10);
		drugieImie.setBounds(414, 63, 120, 20);
		panelWyszukaj.add(drugieImie);
		
		nazwisko = new JTextField();
		nazwisko.setText("NAZWISKO");
		nazwisko.setForeground(Color.LIGHT_GRAY);
		nazwisko.setEditable(false);
		nazwisko.setColumns(10);
		nazwisko.setBounds(414, 97, 120, 20);
		panelWyszukaj.add(nazwisko);
		
		pesel = new JTextField();
		pesel.setText("PESEL");
		pesel.setForeground(Color.LIGHT_GRAY);
		pesel.setEditable(false);
		pesel.setColumns(10);
		pesel.setBounds(414, 131, 120, 20);
		panelWyszukaj.add(pesel);
		
		telefon = new JTextField();
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(251, -2, 12, 154);
		panelWyszukaj.add(verticalStrut);
		
		JLabel lblNewLabel = new JLabel("DANE PACJENTA");
		lblNewLabel.setBounds(291, 14, 142, 14);
		panelWyszukaj.add(lblNewLabel);
	}

}
