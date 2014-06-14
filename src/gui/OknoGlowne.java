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

public class OknoGlowne {



	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private Pacjent pacjent;
	
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

	private NowyPacjent nowyPacjent;


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
		
		JTabbedPane tabbedPane_4 = new JTabbedPane(JTabbedPane.TOP);
		internalFrame_1.getContentPane().add(tabbedPane_4, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		tabbedPane_4.addTab("Historia wizyt", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 567, 154);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblWyszukajPo_1 = new JLabel("Wyszukaj po");
		lblWyszukajPo_1.setBounds(23, 11, 77, 21);
		panel_3.add(lblWyszukajPo_1);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(110, 11, 110, 21);
		panel_3.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(110, 43, 110, 22);
		panel_3.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(110, 76, 110, 21);
		panel_3.add(comboBox_5);
		
		JButton btnNewButton = new JButton("Wyszukaj");
		btnNewButton.setBounds(110, 108, 89, 23);
		panel_3.add(btnNewButton);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 165, 557, 251);
		panel_2.add(tabbedPane_1);
		
		JPanel panel_4 = new JPanel();
		tabbedPane_1.addTab("Pacjent", null, panel_4, null);
		panel_4.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(368, 11, 158, 187);
		panel_4.add(panel_6);
		
		JLabel label = new JLabel("Imie ");
		label.setBounds(33, 25, 66, 14);
		panel_4.add(label);
		
		JLabel label_1 = new JLabel("Drugie imie");
		label_1.setBounds(33, 64, 86, 14);
		panel_4.add(label_1);
		
		JLabel label_2 = new JLabel("Nazwisko");
		label_2.setBounds(33, 103, 86, 14);
		panel_4.add(label_2);
		
		JLabel label_3 = new JLabel("Pesel");
		label_3.setBounds(33, 142, 66, 14);
		panel_4.add(label_3);
		
		JLabel label_4 = new JLabel("Nr telefonu");
		label_4.setBounds(33, 181, 86, 14);
		panel_4.add(label_4);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText("IMIE");
		textField_1.setForeground(Color.LIGHT_GRAY);
		textField_1.setColumns(10);
		textField_1.setBounds(146, 20, 86, 20);
		panel_4.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText("DRUGIE IMIE");
		textField_2.setForeground(Color.LIGHT_GRAY);
		textField_2.setColumns(10);
		textField_2.setBounds(146, 60, 86, 20);
		panel_4.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setText("NAZWISKO");
		textField_3.setForeground(Color.LIGHT_GRAY);
		textField_3.setColumns(10);
		textField_3.setBounds(146, 100, 86, 20);
		panel_4.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setText("PESEL");
		textField_4.setForeground(Color.LIGHT_GRAY);
		textField_4.setColumns(10);
		textField_4.setBounds(146, 140, 86, 20);
		panel_4.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setText("000 000 000");
		textField_5.setForeground(Color.LIGHT_GRAY);
		textField_5.setColumns(10);
		textField_5.setBounds(146, 180, 86, 20);
		panel_4.add(textField_5);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane_1.addTab("Wizyty przeszle", null, panel_5, null);
		tabbedPane_1.setEnabledAt(1, true);
		panel_5.setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(10, 77, 532, 135);
		panel_5.add(editorPane);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		dateChooser.setBounds(60, 23, 141, 20);
		panel_5.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(60, 46, 141, 20);
		panel_5.add(dateChooser_1);
		
		JLabel lblOd = new JLabel("Od");
		lblOd.setBounds(10, 23, 46, 14);
		panel_5.add(lblOd);
		
		JLabel lblDo = new JLabel("Do");
		lblDo.setBounds(10, 52, 46, 14);
		panel_5.add(lblDo);
		
		Panel panel_9 = new Panel();
		tabbedPane_1.addTab("Wizyty przyszle", null, panel_9, null);
		panel_9.setLayout(null);
		
		JList list_2 = new JList();
		list_2.setBounds(10, 11, 532, 149);
		panel_9.add(list_2);
		
		JButton btnNewButton_3 = new JButton("Usun wizyte");
		btnNewButton_3.setBounds(10, 177, 127, 23);
		panel_9.add(btnNewButton_3);
		
		JPanel panel_7 = new JPanel();
		tabbedPane_4.addTab("Rezerwacja wizyty", null, panel_7, null);
		panel_7.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBounds(0, 0, 567, 154);
		panel_7.add(panel_8);
		
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
		panel_7.add(list);
		
		List list_1 = new List();
		list_1.setMultipleMode(true);
		list_1.setBounds(166, 196, 193, 152);
		panel_7.add(list_1);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(377, 194, 169, 154);
		panel_7.add(calendar);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(24, 387, 123, 20);
		panel_7.add(dateChooser_2);
		
		Button button_2 = new Button("Utworz wizyte");
		button_2.setBounds(377, 387, 150, 20);
		panel_7.add(button_2);
		
		JLabel lblNewLabel_1 = new JLabel("Lekarz specjalista");
		lblNewLabel_1.setBounds(24, 176, 123, 14);
		panel_7.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Lekarze");
		lblNewLabel_2.setBounds(166, 176, 46, 14);
		panel_7.add(lblNewLabel_2);
		
		JLabel lblDataWizyty = new JLabel("Data wizyty");
		lblDataWizyty.setBounds(24, 362, 86, 14);
		panel_7.add(lblDataWizyty);
		
		JLabel lblNewLabel_3 = new JLabel("Rodzaj uslugi");
		lblNewLabel_3.setBounds(166, 362, 150, 14);
		panel_7.add(lblNewLabel_3);
		
		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setBounds(166, 387, 139, 20);
		panel_7.add(comboBox_9);
		
		JButton button = new JButton("Wyszukaj");
		button.setBounds(21, 325, 126, 23);
		panel_7.add(button);
		internalFrame_1.setVisible(true);
		internalFrame.setVisible(true);
	}
}
