package ba.bitcamp.lectures.recap.goemetry.voz;

import ba.bitcamp.lectures.recap.goemetry.ITijelo;
import ba.bitcamp.lectures.recap.goemetry.KompleksnoTijelo;
import ba.bitcamp.lectures.recap.goemetry.Kvadrat;
import ba.bitcamp.lectures.recap.goemetry.Pravougaonik;

public class Lokomotiva extends Baza {

	private int brojDimnjaka;

	public Lokomotiva(double duzina, final double visina, double velicinaTocka, double velicinaKabine, final double procenatProzoraNaKabini, int brojDimnjaka) {
		super(duzina, visina, velicinaTocka);
		this.brojDimnjaka = brojDimnjaka;
		// dodaj kabinu - kabina je kvadrat, kome je dio povrsine pod prozorima i to se ne racuna
		// kabina je anonimna klasa bazirana na kvadratu
		dodajDio(new Kvadrat(velicinaKabine) {
			@Override
			public double povrsina() {
				return super.povrsina() * (1-procenatProzoraNaKabini);
			}
		});
		// dodaj dimnjake
		// dimnjak je inner klasa
		for (int i=0; i<brojDimnjaka; i++) {
			dodajDio(new Dimnjak(velicinaKabine));
		}
		
		// dodaj prednje svjetlo
		// svjetlo anonimna klasa koja direktno implementira interface ITijelo
		ITijelo svjetlo = new ITijelo() {
			
			@Override
			public double povrsina() {
				return (visina / 2) * (visina / 2) * Math.PI / 2;
			}
			
			@Override
			public double obim() {
				return visina + visina * Math.PI;
			}
			
			@Override
			public String toString() {
				return "Svjetlo kao polukrug na vrhu baze";
			}
		};
		dodajDio(svjetlo);
	}
	
	@Override
	public String toString() {
		return String.format("Lokomotiva dimnjaka=%d", brojDimnjaka);
	}

	/**
	 * Privatna inner klasa koja opisuje dimnjak
	 * @author emir
	 *
	 */
	private class Dimnjak extends KompleksnoTijelo {
		public Dimnjak(double visina) {
			super(new Pravougaonik(visina/3, visina), new Pravougaonik(visina/3 + 10, 10));
		}
	}
}
