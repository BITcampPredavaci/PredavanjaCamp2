package ba.bitcamp.lectures.inheritance;

public class Vozilo extends Object {
	private String registracija;
	private int godinaProizvodnje;
	protected int maxPutnika;
	
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
		if (maxPutnika < 100) {
			this.maxPutnika = maxPutnika;
		} else {
			throw new UnsupportedOperationException("Previse");
		}
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Vozilo) {
			Vozilo vozilo = (Vozilo) obj;
			return registracija.equals(vozilo.getRegistracija());
		}
		return false;
	}
	
	public String toString() {
		return String.format("{registracija: %s, godinaProizvodnje: %d, maxPutnika:%d}", registracija, godinaProizvodnje, maxPutnika);
	}
}
