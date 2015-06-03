package ba.bitcamp.lectures.arrays;
import java.util.Scanner;

/**
 * Takes numbers from input until -1 is entered, max 5 numbers
 * and returns random one.
 * Hard to write for 100!
 * 
 * @author emir
 *
 */
public class RandNum {
	public static void main(String[] args) {
		System.out.print("Unesite max 5 brojeva, -1 za kraj:");
		Scanner in = new Scanner(System.in);
		int uneseno = 0;
		int broj1 = -1, broj2 = -1, broj3 = -1, broj4 = -1, broj5 = -1;
		broj1 = in.nextInt();
		if (broj1 > 0) {
			uneseno++;
			System.out.print("Slijedeci broj:");
			broj2 = in.nextInt();
			if (broj2 > 0) {
				uneseno++;
				System.out.print("Slijedeci broj:");
				broj3 = in.nextInt();
				if (broj3 > 0) {
					uneseno++;
					System.out.print("Slijedeci broj:");
					broj4 = in.nextInt();
					if (broj4 > 0) {
						uneseno++;
						System.out.print("Slijedeci broj:");
						broj5 = in.nextInt();
						if (broj5 > 0) {
							uneseno++;
						}
					}
				}
			}
		}
		in.close();
		int randIndex = (int) (Math.random() * uneseno) + 1;
		int rand = -1;
		switch (randIndex) {
		case 1:
			rand = broj1;
			break;
		case 2:
			rand = broj2;
			break;
		case 3:
			rand = broj3;
			break;
		case 4:
			rand = broj4;
			break;
		case 5:
			rand = broj5;
			break;
		}
		
		System.out.println("Random broj je " + rand);

	}
}
