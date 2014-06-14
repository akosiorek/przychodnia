package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

public class WizytyPrzeszle extends JPanel {

	JDateChooser dataOd;
	JDateChooser dataDo;
	JButton btnWyszukaj_3;
	JTextArea wizyty ;
	
	WizytyPrzeszle(){
		// init(null);
	}
	
	public void init(JTabbedPane dane){
		
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		dane.addTab("Wizyty przeszle", null, this, null);
		dane.setEnabledAt(1, true);
		this.setLayout(null);
		
		wizyty = new JTextArea();
		wizyty.setBounds(10, 77, 532, 135);
		this.add(wizyty);
		
		dataOd = new JDateChooser();
		dataOd.getCalendarButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		dataOd.setBounds(60, 23, 141, 20);
		this.add(dataOd);
		
		dataDo = new JDateChooser();
		dataDo.setBounds(60, 46, 141, 20);
		this.add(dataDo);
		
		JLabel lblOd = new JLabel("Data od");
		lblOd.setBounds(10, 23, 46, 14);
		this.add(lblOd);
		
		JLabel lblDo = new JLabel("Data do");
		lblDo.setBounds(10, 52, 46, 14);
		this.add(lblDo);
		
		btnWyszukaj_3 = new JButton("Wyszukaj");
		btnWyszukaj_3.setBounds(265, 23, 89, 23);
		this.add(btnWyszukaj_3);
	}

	public JDateChooser getDataOd() {
		return dataOd;
	}

	public JDateChooser getDataDo() {
		return dataDo;
	}

	public JButton getBtnWyszukaj() {
		return btnWyszukaj_3;
	}

	public JTextArea getWizyty() {
		return wizyty;
	}
}
