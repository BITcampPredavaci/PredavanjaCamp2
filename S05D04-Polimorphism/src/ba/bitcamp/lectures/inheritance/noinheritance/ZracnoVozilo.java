package ba.bitcamp.lectures.inheritance.noinheritance;

public class ZracnoVozilo {
	private String registracija;
	private int godinaProizvodnje;
	private int maxPutnika;
	private int rasponKrila;
	
	public ZracnoVozilo(String registracija, int godinaProizvodnje, int maxPutnika, int rasponKrila) {
		this.registracija = registracija;
		this.godinaProizvodnje = godinaProizvodnje;
		this.maxPutnika = maxPutnika;
		this.rasponKrila = rasponKrila;
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
	public int getRasponKrila() {
		return rasponKrila;
	}
	public void setRasponKrila(int rasponKrila) {
		this.rasponKrila = rasponKrila;
	}
}
