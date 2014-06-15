package controler;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import gui.OknoLogowania;

public abstract class IControlerOknoLogowania {
	protected OknoLogowania m_oknoLogowania;
	ControlerOkien m_controler;
	
	public OknoLogowania getGUIwindow() {
		return m_oknoLogowania;
	}

	public void setGUIwindow(OknoLogowania m_window) {
		this.m_oknoLogowania = m_window;
	}


	public IControlerOknoLogowania(ControlerOkien controler) {
		m_controler = controler;
		m_controler.setOknoLogowania(this);
		m_oknoLogowania = new OknoLogowania();
		addActionZaloguj();
	}

	private String getDay(Map<String, Hours> days, String day) {
		return days.get(day).getFrom() + " - " + days.get(day).getTo();
	}

	public abstract Map<String, Hours> readDays();

	public abstract String readNazwa();

	public abstract String readNrTelefonu();

	public abstract String readAdres();

	public abstract boolean validatePassword(String login, String password);

	public void displayDanePrzychodni() {

		m_oknoLogowania.getTxtNazwa().setText(readNazwa());
		m_oknoLogowania.getTelefon().setText(readNrTelefonu());
		m_oknoLogowania.getAdres().setText(readAdres());

		Map<String, Hours> days = readDays();
//		m_oknoLogowania.getPoniedzialek().setText(getDay(days, "poniedzialek"));
//		m_oknoLogowania.getWtorek().setText(getDay(days, "wtorek"));
//		m_oknoLogowania.getSroda().setText(getDay(days, "sroda"));
//		m_oknoLogowania.getCzwartek().setText(getDay(days, "czwartek"));
//		m_oknoLogowania.getPiatek().setText(getDay(days, "piatek"));
//		m_oknoLogowania.getSobota().setText(getDay(days, "sobota"));
	}

	public void addActionZaloguj() {
		m_oknoLogowania.getZaloguj().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (validatePassword(m_oknoLogowania.getLogin().getText(), String
						.valueOf(m_oknoLogowania.getPasswordField().getPassword())))
					zaloguj();
				else
					System.out.println("Nieprawidlowe haslo lub login");
			}
		});
	}
	
	public void zaloguj(){
		m_controler.zaloguj();
	}
	
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					m_oknoLogowania.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}