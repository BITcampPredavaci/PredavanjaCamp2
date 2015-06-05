package ba.bitcamp.lectures.methods;

import static ba.bitcamp.lectures.methods.ByteArrayHelper.zamijeniMjesta;

/**
 * Example of card shuffling and dealing with subroutines.
 * @author emir
 *
 */
public class CardsWithMethods {
	public static int zeljeniBrojMijesanja = 10;
	public static int brojZamijenaPoMijesanju = 15;
	
	public static void main(String[] args) {
		// novi spil
		byte[] karte = noviSpil();
		// ispisi novi spil
		ispisiSpil(karte);
		// 10 puta promijesaj
		for (int brojMijesanja = 0; brojMijesanja < zeljeniBrojMijesanja; brojMijesanja++) {
			// promijesaj
			promijesaj(karte);
			// pogledaj karte
			ispisiSpil(karte);
		}
		// podijeli prve cetiri karte
		karte = podijeliNKarata(karte, 4);
		// ispisi karte nakon djeljenja
		ispisiSpil(karte);
	}

	public static byte[] noviSpil() {
		byte[] karte = new byte[52];
		for (byte i = 0; i < karte.length; i++) {
			karte[i] = i;
		}
		return karte;
	}

	public static void ispisiSpil(byte[] spil) {
		ispisiPrvihNKarata(spil, spil.length);
	}
	
	public static void ispisiPrvihNKarata(byte[] spil, int kolikoIspisati) {
		int maxIspisati = Math.min(kolikoIspisati, spil.length);
		for (int i = 0; i < maxIspisati; i++) {
			String kartaKaoString = pretvoriKartuUString(spil[i]);
			System.out.print(kartaKaoString);
		}
		System.out.println();
	}

	public static void promijesaj(byte[] karte) {
		for (int brojZamijena = 0; brojZamijena < brojZamijenaPoMijesanju; brojZamijena++) {
			// zamijeni 2 random karte
			// uzmi random kartu
			int indexPrveKarte = (int) (Math.random() * 52);
			// uzmi jos jednu random kartu
			int indexDrugeKarte = (int) (Math.random() * 52);
			zamijeniMjesta(karte, indexPrveKarte, indexDrugeKarte);
		}
	}

	public static String pretvoriKartuUString(byte karta) {
		int broj = karta % 13 + 1;
		int znakIndex = karta / 13;
		String znak = null;
		switch (znakIndex) {
		case 0:
			znak = "S";
			break;
		case 1:
			znak = "B";
			break;
		case 2:
			znak = "T";
			break;
		case 3:
			znak = "L";
			break;
		}
		return "[" + broj + znak + "] ";
	}
	
	public static byte[] podijeliNKarata(byte[] spil, int kolikoPodijeliti) {
		// ispisi podijeljene karte
		ispisiPrvihNKarata(spil, kolikoPodijeliti);
		// izbaci podijeljene karte is spila
		byte[] reducirani = new byte[spil.length-kolikoPodijeliti];
		for (int i=0; i<reducirani.length; i++) {
			reducirani[i] = spil[i+kolikoPodijeliti];
		}
		return reducirani;
	}
}
