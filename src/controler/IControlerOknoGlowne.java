package controler;

import java.awt.EventQueue;

import gui.OknoGlowne;

public class IControlerOknoGlowne {
	protected OknoGlowne m_oknoGlowne;
	protected IControlerNowyPacjent m_controlerNowyPacjent;
	ControlerOkien m_controler;
		
	
	public OknoGlowne getGUIOknoGlowne() {
		return m_oknoGlowne;
	}
	
	IControlerOknoGlowne(ControlerOkien controler){
		m_oknoGlowne = new OknoGlowne();
		m_controlerNowyPacjent = new ControlerNowyPacjent(m_oknoGlowne.getNowyPacjent());
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
