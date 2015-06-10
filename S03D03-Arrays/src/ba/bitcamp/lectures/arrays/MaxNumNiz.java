package ba.bitcamp.lectures.arrays;
import java.util.Scanner;

/**
 * Max num is not problem when using arrays.
 * 
 * @author emir
 *
 */
public class MaxNumNiz {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Unesi max broj elemenata: ");
		int maxBrojElemenata = in.nextInt();
		maxBrojElemenata = Math.max(maxBrojElemenata, 0);
		System.out.print("Unesite max " + maxBrojElemenata + " brojeva, 0 za prekid: ");
		
		int[] brojevi = new int[maxBrojElemenata];
		int uneseno = 0;
		for (int idx = 0; idx < brojevi.length; idx++) {
			int br = in.nextInt();
			if (br > 0) {
				brojevi[idx] = br;
				uneseno++;
			} else {
				break;
			}
		}
		in.close();
		int max = -1;
		System.out.println("Uneseni brojevi: ");
		for (int idx = 0; idx < uneseno; idx++) {
			int elementNiza = brojevi[idx];
			System.out.println(elementNiza);
			if (elementNiza > max) {
				max = elementNiza;
			}
		}
		System.out.println("Najveci je " + max);

	}
}
