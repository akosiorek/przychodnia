package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class NowyPacjent extends JPanel {
	
	private JTextField txtImie;
	public JTextField getTxtImie() {
		return txtImie;
	}

	public void setTxtImie(JTextField txtImie) {
		this.txtImie = txtImie;
	}

	public JTextField getTxtDrugieImie() {
		return txtDrugieImie;
	}

	public void setTxtDrugieImie(JTextField txtDrugieImie) {
		this.txtDrugieImie = txtDrugieImie;
	}

	public JTextField getTxtNazwisko() {
		return txtNazwisko;
	}

	public void setTxtNazwisko(JTextField txtNazwisko) {
		this.txtNazwisko = txtNazwisko;
	}

	public JTextField getTxtPesel() {
		return txtPesel;
	}

	public void setTxtPesel(JTextField txtPesel) {
		this.txtPesel = txtPesel;
	}

	public JTextField getTxtTelefon() {
		return txtTelefon;
	}

	public void setTxtTelefon(JTextField txtTelefon) {
		this.txtTelefon = txtTelefon;
	}

	public JButton getBtnAnuluj() {
		return btnAnuluj;
	}

	public void setBtnAnuluj(JButton btnAnuluj) {
		this.btnAnuluj = btnAnuluj;
	}

	public JButton getBtnZatwierdz() {
		return btnZatwierdz;
	}

	public void setBtnZatwierdz(JButton btnZatwierdz) {
		this.btnZatwierdz = btnZatwierdz;
	}

	public JTextPane getTxtpnKomunikatBledu() {
		return txtpnKomunikatBledu;
	}

	public void setTxtpnKomunikatBledu(JTextPane txtpnKomunikatBledu) {
		this.txtpnKomunikatBledu = txtpnKomunikatBledu;
	}

	private JTextField txtDrugieImie;
	private JTextField txtNazwisko;
	private JTextField txtPesel;
	private JTextField txtTelefon;
	private JButton btnAnuluj;
	private JButton btnZatwierdz;
	private JTextPane txtpnKomunikatBledu;
	
	public void initializeNowyPacjent(JTabbedPane pacjenci){
		
		pacjenci.addTab("Nowy pacjent", null, this, null);
		setMyLayout();
		
		JLabel lblImie = new JLabel("Imie ");
		add(lblImie, "2, 4");
		
		txtImie = new JTextField();
		txtImie.setForeground(Color.LIGHT_GRAY);
		txtImie.setText("IMIE");
		add(txtImie, "6, 4, left, default");
		txtImie.setColumns(10);
		
		JLabel lblDrugieImie = new JLabel("Drugie imie");
		add(lblDrugieImie, "2, 8");
		
		txtDrugieImie = new JTextField();
		txtDrugieImie.setForeground(Color.LIGHT_GRAY);
		txtDrugieImie.setText("DRUGIE IMIE");
		add(txtDrugieImie, "6, 8, left, default");
		txtDrugieImie.setColumns(10);
		
		JLabel lblNazwisko = new JLabel("Nazwisko");
		add(lblNazwisko, "2, 12");
		
		txtNazwisko = new JTextField();
		txtNazwisko.setForeground(Color.LIGHT_GRAY);
		txtNazwisko.setText("NAZWISKO");
		add(txtNazwisko, "6, 12, left, default");
		txtNazwisko.setColumns(10);
		
		JLabel lblPesel = new JLabel("Pesel");
		add(lblPesel, "2, 16");
		
		txtPesel = new JTextField();
		txtPesel.setForeground(Color.LIGHT_GRAY);
		txtPesel.setText("PESEL");
		add(txtPesel, "6, 16, left, default");
		txtPesel.setColumns(10);
		
		JLabel lblNrTelefonu = new JLabel("Nr telefonu");
		add(lblNrTelefonu, "2, 20");
		
		txtTelefon = new JTextField();
		txtTelefon.setForeground(Color.LIGHT_GRAY);
		txtTelefon.setText("000 000 000");
		add(txtTelefon, "6, 20, left, default");
		txtTelefon.setColumns(10);
		
		btnAnuluj = new JButton("Anuluj");
		add(btnAnuluj, "2, 24");
		
		btnZatwierdz = new JButton("Zatwierdz");
		add(btnZatwierdz, "6, 24, left, default");
		
		txtpnKomunikatBledu = new JTextPane();
		txtpnKomunikatBledu.setFont(new Font("Tahoma", Font.ITALIC, 12));
		txtpnKomunikatBledu.setText("Komunikat bledu");
		add(txtpnKomunikatBledu, "1, 26, 6, 1, fill, fill");
	}
	
	private void setMyLayout(){
	setLayout(new FormLayout(new ColumnSpec[] {
			ColumnSpec.decode("10dlu"),
			ColumnSpec.decode("left:max(40dlu;default)"),
			FormFactory.RELATED_GAP_COLSPEC,
			ColumnSpec.decode("max(7dlu;min)"),
			FormFactory.RELATED_GAP_COLSPEC,
			ColumnSpec.decode("default:grow"),},
		new RowSpec[] {
			FormFactory.RELATED_GAP_ROWSPEC,
			FormFactory.DEFAULT_ROWSPEC,
			FormFactory.RELATED_GAP_ROWSPEC,
			FormFactory.DEFAULT_ROWSPEC,
			FormFactory.RELATED_GAP_ROWSPEC,
			FormFactory.DEFAULT_ROWSPEC,
			FormFactory.RELATED_GAP_ROWSPEC,
			FormFactory.DEFAULT_ROWSPEC,
			FormFactory.RELATED_GAP_ROWSPEC,
			FormFactory.DEFAULT_ROWSPEC,
			FormFactory.RELATED_GAP_ROWSPEC,
			FormFactory.DEFAULT_ROWSPEC,
			FormFactory.RELATED_GAP_ROWSPEC,
			FormFactory.DEFAULT_ROWSPEC,
			FormFactory.RELATED_GAP_ROWSPEC,
			FormFactory.DEFAULT_ROWSPEC,
			FormFactory.RELATED_GAP_ROWSPEC,
			FormFactory.DEFAULT_ROWSPEC,
			FormFactory.RELATED_GAP_ROWSPEC,
			FormFactory.DEFAULT_ROWSPEC,
			FormFactory.RELATED_GAP_ROWSPEC,
			FormFactory.DEFAULT_ROWSPEC,
			FormFactory.RELATED_GAP_ROWSPEC,
			FormFactory.DEFAULT_ROWSPEC,
			FormFactory.RELATED_GAP_ROWSPEC,
			RowSpec.decode("default:grow"),}));
}
}
