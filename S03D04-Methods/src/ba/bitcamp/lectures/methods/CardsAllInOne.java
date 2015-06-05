package ba.bitcamp.lectures.methods;

/**
 * Example of card shuffling and dealing where everything is implemented within main method
 * @author emir
 *
 */
public class CardsAllInOne {
	public static void main(String[] args) {
		// novi spil
		byte[] karte = new byte[52];
		for (byte i=0; i<52; i++) {
			karte[i] = i; 
		}
		// ispisi novi spil
		for (int i=0; i<karte.length; i++) {
			int broj = karte[i] % 13 + 1;
			int znakIndex = karte[i] / 13;
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
			System.out.print("[" + broj + znak + "] ");
		}
		System.out.println();
		// 10 puta promijesaj
		for (int brojMijesanja=0; brojMijesanja < 10; brojMijesanja++) {
			// 15 puta
			for (int brojZamijena=0; brojZamijena < 15; brojZamijena++) {
				// zamijeni 2 random karte
				// uzmi random kartu
				int indexPrveKarte = (int) (Math.random() * 52);
				// uzmi jos jednu random kartu
				int indexDrugeKarte = (int) (Math.random() * 52);
				// zamijeni im mjesta
				byte tmp = karte[indexPrveKarte];
				karte[indexPrveKarte] = karte[indexDrugeKarte];
				karte[indexDrugeKarte] = tmp;
			}
			// pogledaj karte
			for (int i=0; i<karte.length; i++) {
				int broj = karte[i] % 13 + 1;
				int znakIndex = karte[i] / 13;
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
				System.out.print(broj + znak + " ");
			}
			System.out.println();
		}
		
		// podijeli prve cetiri karte
		for (int i=0; i<4; i++) {
			int broj = karte[i] % 13 + 1;
			int znakIndex = karte[i] / 13;
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
			System.out.print(broj + znak + " ");
		}
		System.out.println();
		// izbaci podijeljene karte is spila
		byte[] reducirani = new byte[karte.length-4];
		for (int i=0; i<reducirani.length; i++) {
			reducirani[i] = karte[i+4];
		}
		karte = reducirani;
		// ispisi karte nakon djeljenja
		for (int i=0; i<karte.length; i++) {
			int broj = karte[i] % 13 + 1;
			int znakIndex = karte[i] / 13;
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
			System.out.print(broj + znak + " ");
		}
		System.out.println();
	}
}
