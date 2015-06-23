package ba.bitcamp.lectures.recap.goemetry;

import ba.bitcamp.lectures.recap.goemetry.voz.Voz;

public class TestTijela {
	public static void main(String[] args) {
		KompleksnoTijelo kompleksno = new KompleksnoTijelo(new Krug(10), new Krug(10),  new Pravougaonik(60,  5) );
		kompleksno.dodajDio(new Kvadrat(10));
		// ne moze biti dio sam sebe
		// kompleksno.dodajDio(kompleksno);
		ITijelo[] testTijela = new ITijelo[] {
				new Krug(1), 
				new Pravougaonik(5, 10), 
				new Kvadrat(5),
				kompleksno,
				new Voz(100, 20, 3)};
		for (ITijelo tijelo : testTijela) {
			System.out.println(tijelo.toString());
			System.out.println("Povrsina: " + tijelo.povrsina());
			System.out.println("Obim: " + tijelo.obim());
			System.out.println();
		}
	}
}
