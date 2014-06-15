package controler;

import java.awt.EventQueue;

import gui.OknoGlowne;

public class ControlerOknoGlowne {
	protected OknoGlowne m_oknoGlowne;
	protected IControlerNowyPacjent m_controlerNowyPacjent;
	protected IControlerPacjent m_controlerPacjent;
	protected IControlerHistoria m_controlerHistoria;
	protected IControlerRezerwacja m_controlerRezerwacja;
	ControlerOkien m_controler;
		
	
	public OknoGlowne getGUIOknoGlowne() {
		return m_oknoGlowne;
	}
	
	ControlerOknoGlowne(ControlerOkien controler){
		m_oknoGlowne = new OknoGlowne();
		m_controlerNowyPacjent = new ControlerNowyPacjent(m_oknoGlowne.getNowyPacjent());
		m_controlerPacjent = new ControlerPacjenta(m_oknoGlowne.getPacjent());
		m_controlerHistoria = new ControlerHistoria(m_oknoGlowne.getHistoria());
		m_controlerRezerwacja = new ControlerRezerwacja(m_oknoGlowne.getRezerwacja());
		m_controler = controler;
		m_controler.setOknoGlowne(this);
	}
	
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					m_oknoGlowne.getFrmPrzychodnia().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
