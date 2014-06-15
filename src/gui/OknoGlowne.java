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


	private Pacjent pacjent;
	private NowyPacjent nowyPacjent;
	private Historia historia;
	public Historia getHistoria() {
		return historia;
	}

	public Rezerwacja getRezerwacja() {
		return rezerwacja;
	}

	private Rezerwacja rezerwacja;
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
		
		rezerwacja = new Rezerwacja();
		rezerwacja.init(panelWizyt);
		
		internalFrame_1.setVisible(true);
		internalFrame.setVisible(true);
	}
}
