package ba.bitcamp.lectures.inheritance.noinheritance;

public class VodenoVozilo {
	private String registracija;
	private int godinaProizvodnje;
	private int maxPutnika;
	
	private boolean propeler;
	
	public VodenoVozilo(String registracija, int godinaProizvodnje, int maxPutnika, boolean propeler) {
		this.registracija = registracija;
		this.godinaProizvodnje = godinaProizvodnje;
		this.maxPutnika = maxPutnika;
		this.propeler = propeler;
	}
	
	public String getRegistracija() {
		return registracija;
	}
	public void setRegistracija(String registracija) {
		this.registracija = registracija;
	}
	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}
	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}
	public int getMaxPutnika() {
		return maxPutnika;
	}
	public void setMaxPutnika(int maxPutnika) {
		this.maxPutnika = maxPutnika;
	}
	
	public void setPropeler(boolean propeler) {
		this.propeler = propeler;
	}

	public boolean isPropeler() {
		return propeler;
	}
}
