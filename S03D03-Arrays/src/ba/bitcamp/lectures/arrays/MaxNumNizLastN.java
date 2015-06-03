package ba.bitcamp.lectures.arrays;
import java.util.Scanner;

/**
 * Keeps last N numbers in array by revolving array - 
 * when last index is used, starts from index 0.
 * 
 * @author emir
 *
 */
public class MaxNumNizLastN {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Unesi max broj elemenata (min 5): ");
		int maxBrojElemenata = in.nextInt();
		maxBrojElemenata = Math.max(maxBrojElemenata, 5);
		
		int poz = 0;
		int[] brojevi = new int[maxBrojElemenata];
		while (true) {
			int br = in.nextInt();
			if (br >= 0) {
				brojevi[poz] = br;
				poz++;
				if (poz == brojevi.length) {
					poz = 0;
				}
			} else {
				break;
			}
		}
		in.close();
		int max = -1;
		for (int idx = 0; idx < brojevi.length; idx++) {
			int elementNiza = brojevi[idx];
			if (elementNiza > max) {
				max = elementNiza;
			}
		}
		System.out.println("Najveci je " + max);

	}
}
