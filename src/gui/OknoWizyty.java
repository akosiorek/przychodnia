package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import com.toedter.calendar.JDateChooser;

public class OknoWizyty extends JFrame {

	private JPanel contentPane;
	private JTextField imie;
	public JPanel getContentPane() {
		return contentPane;
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

	public JTextField getLekarz() {
		return lekarz;
	}

	public JTextField getTypUslugi() {
		return typUslugi;
	}

	public JTextField getKoszt() {
		return koszt;
	}

	public JTextField getData() {
		return data;
	}

	private JTextField drugieImie;
	private JTextField nazwisko;
	private JTextField pesel;
	private JTextField lekarz;
	private JTextField typUslugi;
	private JTextField koszt;
	private JTextField data;
	private JButton zatwierdz;
	private JButton anuluj;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OknoWizyty frame = new OknoWizyty();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JButton getZatwierdz() {
		return zatwierdz;
	}

	public JButton getAnuluj() {
		return anuluj;
	}

	/**
	 * Create the frame.
	 */
	public OknoWizyty() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 11, 621, 180);
		contentPane.add(panel);
		
		JLabel lblSpecjalista = new JLabel("Lekarz");
		lblSpecjalista.setBounds(22, 36, 89, 21);
		panel.add(lblSpecjalista);
		
		JLabel label_1 = new JLabel("Imie ");
		label_1.setBounds(354, 36, 52, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Drugie imie");
		label_2.setBounds(354, 69, 78, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Nazwisko");
		label_3.setBounds(354, 102, 65, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Pesel");
		label_4.setBounds(354, 135, 65, 14);
		panel.add(label_4);
		
		imie = new JTextField();
		imie.setText("IMIE");
		imie.setForeground(Color.LIGHT_GRAY);
		imie.setEditable(false);
		imie.setColumns(10);
		imie.setBounds(452, 32, 86, 20);
		panel.add(imie);
		
		drugieImie = new JTextField();
		drugieImie.setText("DRUGIE IMIE");
		drugieImie.setForeground(Color.LIGHT_GRAY);
		drugieImie.setEditable(false);
		drugieImie.setColumns(10);
		drugieImie.setBounds(452, 66, 86, 20);
		panel.add(drugieImie);
		
		nazwisko = new JTextField();
		nazwisko.setText("NAZWISKO");
		nazwisko.setForeground(Color.LIGHT_GRAY);
		nazwisko.setEditable(false);
		nazwisko.setColumns(10);
		nazwisko.setBounds(452, 100, 86, 20);
		panel.add(nazwisko);
		
		pesel = new JTextField();
		pesel.setText("PESEL");
		pesel.setForeground(Color.LIGHT_GRAY);
		pesel.setEditable(false);
		pesel.setColumns(10);
		pesel.setBounds(452, 134, 86, 20);
		panel.add(pesel);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(295, 11, 10, 180);
		panel.add(verticalStrut);
		
		JLabel lblPacjent = new JLabel("PACJENT");
		lblPacjent.setBounds(408, 11, 142, 14);
		panel.add(lblPacjent);
		
		JLabel lblTypUslugi = new JLabel("Typ uslugi");
		lblTypUslugi.setBounds(22, 69, 89, 21);
		panel.add(lblTypUslugi);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(22, 104, 89, 21);
		panel.add(lblData);
		
		JLabel lblCena = new JLabel("Cena");
		lblCena.setBounds(22, 137, 89, 21);
		panel.add(lblCena);
		
		lekarz = new JTextField();
		lekarz.setText("LEKARZ");
		lekarz.setForeground(Color.LIGHT_GRAY);
		lekarz.setEditable(false);
		lekarz.setColumns(10);
		lekarz.setBounds(121, 36, 135, 20);
		panel.add(lekarz);
		
		typUslugi = new JTextField();
		typUslugi.setText("TYP USLUGI");
		typUslugi.setForeground(Color.LIGHT_GRAY);
		typUslugi.setEditable(false);
		typUslugi.setColumns(10);
		typUslugi.setBounds(121, 70, 135, 20);
		panel.add(typUslugi);
		
		koszt = new JTextField();
		koszt.setText("CENA");
		koszt.setForeground(Color.LIGHT_GRAY);
		koszt.setEditable(false);
		koszt.setColumns(10);
		koszt.setBounds(121, 138, 135, 20);
		panel.add(koszt);
		
		JLabel lblWizyta = new JLabel("WIZYTA");
		lblWizyta.setBounds(90, 11, 142, 14);
		panel.add(lblWizyta);
		
		data = new JTextField();
		data.setText("DATA");
		data.setForeground(Color.LIGHT_GRAY);
		data.setEditable(false);
		data.setColumns(10);
		data.setBounds(121, 105, 135, 20);
		panel.add(data);
		
		zatwierdz = new JButton("Zatwierdz wizyte");
		zatwierdz.setBounds(10, 202, 137, 23);
		contentPane.add(zatwierdz);
		
		anuluj = new JButton("Anuluj ");
		anuluj.setBounds(193, 202, 89, 23);
		contentPane.add(anuluj);
	}
}
