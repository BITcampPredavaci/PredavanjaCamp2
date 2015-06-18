package ba.bitcamp.lectures.inheritance.noinheritance;

public class KopnenoVozilo {
	private String registracija;
	private int godinaProizvodnje;
	private int maxPutnika;
	private int brojTockova;
	
	public KopnenoVozilo(String registracija, int godinaProizvodnje, int maxPutnika, int brojTockova) {
		this.registracija = registracija;
		this.godinaProizvodnje = godinaProizvodnje;
		this.maxPutnika = maxPutnika;
		this.brojTockova = brojTockova;
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
	public int getBrojTockova() {
		return brojTockova;
	}
	public void setBrojTockova(int brojTockova) {
		this.brojTockova = brojTockova;
	}
}
