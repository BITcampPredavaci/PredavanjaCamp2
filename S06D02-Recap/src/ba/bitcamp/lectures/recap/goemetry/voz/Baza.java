package ba.bitcamp.lectures.recap.goemetry.voz;

import ba.bitcamp.lectures.recap.goemetry.KompleksnoTijelo;
import ba.bitcamp.lectures.recap.goemetry.Krug;
import ba.bitcamp.lectures.recap.goemetry.Pravougaonik;

public class Baza extends KompleksnoTijelo {
	private double duzina;
	private double visina;
	private double velicinaTocka;

	public Baza(double duzina, double visina, double velicinaTocka) {
		super(new Krug(velicinaTocka), new Krug(velicinaTocka), new Pravougaonik(duzina, visina));
		this.duzina = duzina;
		this.visina = visina;
		this.velicinaTocka = velicinaTocka;
	}
	
	@Override
	public String toString() {
		return String.format("Baza duzina=%f, visina=%f, velicinaTocka=%f", duzina, visina, velicinaTocka);
	}
}
