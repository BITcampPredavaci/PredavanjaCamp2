package ba.bitcamp.lectures.inheritance;

public class KopnenoVozilo extends Vozilo {
	private int brojTockova;
	
	public KopnenoVozilo(String registracija, int godinaProizvodnje, int maxPutnika, int tockova ) {
		setRegistracija(registracija);
		setGodinaProizvodnje(godinaProizvodnje);
		setMaxPutnika(maxPutnika);
		brojTockova = tockova;
	}
	
	public int getBrojTockova() {
		return brojTockova;
	}
	
	public void setBrojTockova(int brojTockova) {
		this.brojTockova = brojTockova;
	}
	
	public int malihPutnika() {
		return maxPutnika + 2;
	}
}
