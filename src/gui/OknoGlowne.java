package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.JEditorPane;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import java.awt.List;
import com.toedter.calendar.JCalendar;
import java.awt.Button;
import java.awt.Panel;
import javax.swing.JList;
import javax.swing.JTextArea;

public class OknoGlowne {

	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private Pacjent pacjent;
	private NowyPacjent nowyPacjent;
	private Historia historia;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OknoGlowne window = new OknoGlowne();
					window.frmPrzychodnia.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OknoGlowne() {
		initialize();
	}
	
	private JFrame frmPrzychodnia;
	public JFrame getFrmPrzychodnia() {
		return frmPrzychodnia;
	}

	public void setFrmPrzychodnia(JFrame frmPrzychodnia) {
		this.frmPrzychodnia = frmPrzychodnia;
	}
	
	public Pacjent getPacjent() {
		return pacjent;
	}

	public void setPacjent(Pacjent pacjent) {
		this.pacjent = pacjent;
	}

	public NowyPacjent getNowyPacjent() {
		return nowyPacjent;
	}

	public void setNowyPacjent(NowyPacjent nowyPacjent) {
		this.nowyPacjent = nowyPacjent;
	}


	/**
	 * Initialize the contents of the frame.
	 */

	
	private void initialize() {
		frmPrzychodnia = new JFrame();
		frmPrzychodnia.setTitle("Przychodnia");
		frmPrzychodnia.setBounds(100, 100, 870, 509);
		frmPrzychodnia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrzychodnia.getContentPane().setLayout(null);
		
		JInternalFrame internalFrame = new JInternalFrame("Zarzadzanie pacjentami");
		internalFrame.setBounds(0, 0, 261, 475);
		frmPrzychodnia.getContentPane().add(internalFrame);
		
		JTabbedPane pacjenci = new JTabbedPane(JTabbedPane.TOP);
		internalFrame.getContentPane().add(pacjenci, BorderLayout.CENTER);
		
		nowyPacjent = new NowyPacjent();
		nowyPacjent.initializeNowyPacjent(pacjenci);
		pacjent = new Pacjent();
		pacjent.initializePacjent(pacjenci);	
		
		JInternalFrame internalFrame_1 = new JInternalFrame("Zarzadzanie wizytami");
		internalFrame_1.setBounds(260, 0, 588, 475);
		frmPrzychodnia.getContentPane().add(internalFrame_1);
		
		JTabbedPane panelWizyt = new JTabbedPane(JTabbedPane.TOP);
		internalFrame_1.getContentPane().add(panelWizyt, BorderLayout.CENTER);
		
		historia = new Historia();
		historia.initHistoria(panelWizyt);
		
		JPanel rezerwacja = new JPanel();
		panelWizyt.addTab("Rezerwacja wizyty", null, rezerwacja, null);
		rezerwacja.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBounds(0, 0, 567, 154);
		rezerwacja.add(panel_8);
		
		JLabel lblWyszukajPacjenta = new JLabel("Wyszukaj pacjenta");
		lblWyszukajPacjenta.setBounds(10, 11, 110, 54);
		panel_8.add(lblWyszukajPacjenta);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(131, 11, 110, 21);
		panel_8.add(comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBounds(131, 43, 110, 22);
		panel_8.add(comboBox_7);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setBounds(131, 76, 110, 21);
		panel_8.add(comboBox_8);
		
		JButton btnWyszukaj = new JButton("Wyszukaj");
		btnWyszukaj.setBounds(131, 108, 89, 23);
		panel_8.add(btnWyszukaj);
		
		JLabel label_12 = new JLabel("Imie ");
		label_12.setBounds(326, 32, 52, 14);
		panel_8.add(label_12);
		
		JLabel label_13 = new JLabel("Drugie imie");
		label_13.setBounds(326, 65, 78, 14);
		panel_8.add(label_13);
		
		JLabel label_14 = new JLabel("Nazwisko");
		label_14.setBounds(326, 98, 78, 14);
		panel_8.add(label_14);
		
		JLabel label_15 = new JLabel("Pesel");
		label_15.setBounds(326, 131, 52, 14);
		panel_8.add(label_15);
		
		textField_11 = new JTextField();
		textField_11.setText("IMIE");
		textField_11.setForeground(Color.LIGHT_GRAY);
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(414, 32, 86, 20);
		panel_8.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setText("DRUGIE IMIE");
		textField_12.setForeground(Color.LIGHT_GRAY);
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBounds(414, 66, 86, 20);
		panel_8.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setText("NAZWISKO");
		textField_13.setForeground(Color.LIGHT_GRAY);
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBounds(414, 100, 86, 20);
		panel_8.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setText("PESEL");
		textField_14.setForeground(Color.LIGHT_GRAY);
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		textField_14.setBounds(414, 134, 86, 20);
		panel_8.add(textField_14);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(269, 0, 12, 154);
		panel_8.add(verticalStrut);
		
		JLabel lblNewLabel = new JLabel("DANE PACJENTA");
		lblNewLabel.setBounds(370, 11, 142, 14);
		panel_8.add(lblNewLabel);
		
		List list = new List();
		list.setMultipleMode(true);
		list.setBounds(24, 196, 123, 119);
		rezerwacja.add(list);
		
		List list_1 = new List();
		list_1.setMultipleMode(true);
		list_1.setBounds(166, 196, 193, 152);
		rezerwacja.add(list_1);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(377, 194, 169, 154);
		rezerwacja.add(calendar);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(24, 387, 123, 20);
		rezerwacja.add(dateChooser_2);
		
		Button button_2 = new Button("Utworz wizyte");
		button_2.setBounds(377, 387, 150, 20);
		rezerwacja.add(button_2);
		
		JLabel lblNewLabel_1 = new JLabel("Lekarz specjalista");
		lblNewLabel_1.setBounds(24, 176, 123, 14);
		rezerwacja.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Lekarze");
		lblNewLabel_2.setBounds(166, 176, 46, 14);
		rezerwacja.add(lblNewLabel_2);
		
		JLabel lblDataWizyty = new JLabel("Data wizyty");
		lblDataWizyty.setBounds(24, 362, 86, 14);
		rezerwacja.add(lblDataWizyty);
		
		JLabel lblNewLabel_3 = new JLabel("Rodzaj uslugi");
		lblNewLabel_3.setBounds(166, 362, 150, 14);
		rezerwacja.add(lblNewLabel_3);
		
		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setBounds(166, 387, 139, 20);
		rezerwacja.add(comboBox_9);
		
		JButton button = new JButton("Wyszukaj");
		button.setBounds(21, 325, 126, 23);
		rezerwacja.add(button);
		internalFrame_1.setVisible(true);
		internalFrame.setVisible(true);
	}
}
