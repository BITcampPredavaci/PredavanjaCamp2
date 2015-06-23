package ba.bitcamp.lectures.recap.goemetry;

import java.util.Arrays;

public class KompleksnoTijelo implements ITijelo {

	ITijelo[] dijelovi;
	
	public KompleksnoTijelo(ITijelo... pocetniDijelovi) {
		dijelovi = pocetniDijelovi;
		// TODO provjeri da li su dijelovi razliciti od null
		// TODO enkapsuliraj bolje - kopiraj niz
	}
	
	public void dodajDio(ITijelo dio) {
		if (dio != null  && dio != this) {
			// dijelovi ne moze biti null - moze biti samo prazan niz
			ITijelo[] novi = new ITijelo[dijelovi.length + 1];
			System.arraycopy(dijelovi, 0, novi, 0, dijelovi.length);
			novi[novi.length-1] = dio;
			dijelovi = novi;
		} else {
			throw new UnsupportedOperationException("Ne moze se dodati null dio ili sam sebe kao dio sebe");
		}
	}
	
	@Override
	public double povrsina() {
		// dijelovi ne moze biti null - moze biti samo prazan niz
		double ukupnaPovrsina = 0;
		for (ITijelo dio : dijelovi) {
			ukupnaPovrsina += dio.povrsina();
		}
		return ukupnaPovrsina;
	}

	@Override
	public double obim() {
		// dijelovi ne moze biti null - moze biti samo prazan niz
		double ukupanObim = 0;
		for (ITijelo dio : dijelovi) {
			ukupanObim += dio.obim();
		}
		return ukupanObim;
	}
	
	@Override
	public String toString() {
		return String.format("Kompleksno tijelo (%s)", Arrays.toString(dijelovi));
	}
}
