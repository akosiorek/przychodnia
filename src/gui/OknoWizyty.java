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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;

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
		
		textField = new JTextField();
		textField.setText("IMIE");
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(452, 32, 86, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("DRUGIE IMIE");
		textField_1.setForeground(Color.LIGHT_GRAY);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(452, 66, 86, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("NAZWISKO");
		textField_2.setForeground(Color.LIGHT_GRAY);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(452, 100, 86, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("PESEL");
		textField_3.setForeground(Color.LIGHT_GRAY);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(452, 134, 86, 20);
		panel.add(textField_3);
		
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
		
		textField_4 = new JTextField();
		textField_4.setText("IMIE");
		textField_4.setForeground(Color.LIGHT_GRAY);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(121, 36, 135, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("DRUGIE IMIE");
		textField_5.setForeground(Color.LIGHT_GRAY);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(121, 70, 135, 20);
		panel.add(textField_5);
		
		textField_7 = new JTextField();
		textField_7.setText("PESEL");
		textField_7.setForeground(Color.LIGHT_GRAY);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(121, 138, 135, 20);
		panel.add(textField_7);
		
		JLabel lblWizyta = new JLabel("WIZYTA");
		lblWizyta.setBounds(90, 11, 142, 14);
		panel.add(lblWizyta);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(121, 107, 135, 20);
		panel.add(dateChooser);
		
		JButton btnNewButton = new JButton("Zatwierdz wizyte");
		btnNewButton.setBounds(10, 202, 137, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Anuluj ");
		btnNewButton_1.setBounds(193, 202, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
