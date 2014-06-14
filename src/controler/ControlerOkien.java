package controler;

public class ControlerOkien {

	private IControlerOknoLogowania oknoLogowania;
	private IControlerOknoGlowne oknoGlowne;

	public IControlerOknoGlowne getOknoGlowne() {
		return oknoGlowne;
	}

	public void setOknoGlowne(IControlerOknoGlowne oknoGlowne) {
		this.oknoGlowne = oknoGlowne;
	}

	ControlerOkien(){
		oknoLogowania = new ControlerOknoLogowania(this);
		oknoGlowne = new IControlerOknoGlowne(this);
		System.out.println("Controler");
	}
	
	public IControlerOknoLogowania getOknoLogowania() {
		return oknoLogowania;
	}

	public void setOknoLogowania(IControlerOknoLogowania oknoLogowania) {
		this.oknoLogowania = oknoLogowania;
	}
	
	public void zaloguj(){
		oknoLogowania.getGUIwindow().dispose();
		oknoGlowne.run();
	}
	
	public static void main(String[] args) {
		ControlerOkien controler = new ControlerOkien();
		controler.getOknoLogowania().run();		
	}

}
