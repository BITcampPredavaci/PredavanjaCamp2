package ba.bitcamp.lectures.arrays;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Keeps last N numbers in array keeping order.
 * 
 * @author emir
 *
 */
public class MaxNumNizLastNInOrder {
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
				if (poz < brojevi.length) {
					brojevi[poz] = br;
					poz++;
				} else {
					for (int i=1; i<brojevi.length; i++) {
						brojevi[i-1] = brojevi[i];
					}
					brojevi[brojevi.length-1] = br;
					poz++;
				}
			} else {
				break;
			}
		}
		in.close();
		System.out.println("Unijeto ukupno: " + poz);
		System.out.println("Zadnjih " + brojevi.length + " brojeva:");
		for (int br : brojevi) {
			System.out.println(br);
		}
		System.out.println("Pomocu Arrays.toString: " + Arrays.toString(brojevi));
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
