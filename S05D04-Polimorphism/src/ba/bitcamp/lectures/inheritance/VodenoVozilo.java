package ba.bitcamp.lectures.inheritance;

public class VodenoVozilo extends Vozilo {
	private boolean propeler;
	
	public VodenoVozilo(String registracija, int godinaProizvodnje, int maxPutnika, boolean imaPropeler ) {
		setRegistracija(registracija);
		setGodinaProizvodnje(godinaProizvodnje);
		setMaxPutnika(maxPutnika);
		propeler = imaPropeler;
	}
	
	public void setPropeler(boolean propeler) {
		this.propeler = propeler;
	}
	
	public boolean isPropeler() {
		return propeler;
	}
}
