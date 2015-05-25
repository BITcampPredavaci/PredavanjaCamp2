package ba.bitcamp.lectures.loops;

/**
 * Demo do while petlje na primjeru trcanja maratona - mora se barem potrcati da bi se stiglo na cilj.
 * Trcanje je simulirano random brojem metara pretrcanih u svakoj iteraciji.
 * @author emir
 *
 */
public class Maraton {
	public static void main(String[] args) {
		int duzinaMaratonaMetri = 42195;
		double pretrcanihMetara = 0;
		int pretrcanihKilometara = 0;
		
		do {
			pretrcanihMetara += Math.random();
			// ako je pretrcan cijeli kilometar ispisi tacku
			if ((int) pretrcanihMetara / 1000 > pretrcanihKilometara) {
				System.out.print(".");
				pretrcanihKilometara = (int) pretrcanihMetara / 1000;
			}
		} while (pretrcanihMetara < duzinaMaratonaMetri);
		System.out.println("\nCILJ!!!");
	}
}
