package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class OknoLogowania extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField txtNazwa;
	private JTextField poniedzialek;
	private JTextField wtorek;
	private JTextField sroda;
	private JTextField czwartek;
	private JTextField piatek;
	private JTextField sobota;
	private JTextField login;
	private JTextField telefon;
	private JTextField adres;
	private JButton Zaloguj;
	
	public JPanel getContentPane() {
		return contentPane;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JTextField getTxtNazwa() {
		return txtNazwa;
	}

	public JTextField getPoniedzialek() {
		return poniedzialek;
	}

	public JTextField getWtorek() {
		return wtorek;
	}

	public JTextField getSroda() {
		return sroda;
	}

	public JTextField getCzwartek() {
		return czwartek;
	}

	public JTextField getPiatek() {
		return piatek;
	}

	public JTextField getSobota() {
		return sobota;
	}

	public JTextField getLogin() {
		return login;
	}

	public JTextField getTelefon() {
		return telefon;
	}

	public JTextField getAdres() {
		return adres;
	}

	public JButton getZaloguj() {
		return Zaloguj;
	}


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					OknoLogowania frame = new OknoLogowania();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public OknoLogowania() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(228, 192, 180, 20);
		contentPane.add(passwordField);
		
		JLabel lblWitamyWPrzychodni = new JLabel("Witamy w przychodni ");
		lblWitamyWPrzychodni.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWitamyWPrzychodni.setBounds(10, 11, 208, 35);
		contentPane.add(lblWitamyWPrzychodni);
		
		txtNazwa = new JTextField();
		txtNazwa.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNazwa.setEditable(false);
		txtNazwa.setText("NAZWA");
		txtNazwa.setBounds(20, 43, 132, 26);
		contentPane.add(txtNazwa);
		txtNazwa.setColumns(10);
		
		JLabel lblGodzinyPrzyjec = new JLabel("Godziny przyjec ");
		lblGodzinyPrzyjec.setBounds(10, 94, 142, 14);
		contentPane.add(lblGodzinyPrzyjec);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 111, 180, 140);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Sroda");
		label.setBounds(10, 52, 46, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Wtorek");
		label_1.setBounds(10, 30, 56, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Poniedzialek");
		label_2.setBounds(10, 8, 74, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Czwartek");
		label_3.setBounds(10, 74, 74, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Piatek");
		label_4.setBounds(10, 96, 46, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Sobota");
		label_5.setBounds(10, 118, 46, 14);
		panel.add(label_5);
		
		poniedzialek = new JTextField();
		poniedzialek.setEditable(false);
		poniedzialek.setBounds(94, 6, 76, 17);
		panel.add(poniedzialek);
		poniedzialek.setColumns(10);
		
		wtorek = new JTextField();
		wtorek.setEditable(false);
		wtorek.setColumns(10);
		wtorek.setBounds(94, 27, 76, 17);
		panel.add(wtorek);
		
		sroda = new JTextField();
		sroda.setEditable(false);
		sroda.setColumns(10);
		sroda.setBounds(94, 49, 76, 17);
		panel.add(sroda);
		
		czwartek = new JTextField();
		czwartek.setEditable(false);
		czwartek.setColumns(10);
		czwartek.setBounds(94, 71, 76, 17);
		panel.add(czwartek);
		
		piatek = new JTextField();
		piatek.setEditable(false);
		piatek.setColumns(10);
		piatek.setBounds(94, 93, 76, 17);
		panel.add(piatek);
		
		sobota = new JTextField();
		sobota.setEditable(false);
		sobota.setColumns(10);
		sobota.setBounds(94, 115, 76, 17);
		panel.add(sobota);
		
		login = new JTextField();
		login.setBounds(228, 136, 180, 20);
		contentPane.add(login);
		login.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(228, 111, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblHaslo = new JLabel("Haslo");
		lblHaslo.setBounds(228, 167, 46, 14);
		contentPane.add(lblHaslo);
		
		JLabel lblNrTelefonu = new JLabel("Nr telefonu");
		lblNrTelefonu.setBounds(205, 33, 74, 14);
		contentPane.add(lblNrTelefonu);
		
		JLabel lblAdres = new JLabel("Adres");
		lblAdres.setBounds(205, 55, 46, 14);
		contentPane.add(lblAdres);
		
		telefon = new JTextField();
		telefon.setEditable(false);
		telefon.setColumns(10);
		telefon.setBounds(289, 31, 117, 17);
		contentPane.add(telefon);
		
		adres = new JTextField();
		adres.setEditable(false);
		adres.setColumns(10);
		adres.setBounds(289, 52, 117, 35);
		contentPane.add(adres);
		
		Zaloguj = new JButton("Zaloguj");
		Zaloguj.setBounds(319, 223, 89, 23);
		contentPane.add(Zaloguj);
	}
}
