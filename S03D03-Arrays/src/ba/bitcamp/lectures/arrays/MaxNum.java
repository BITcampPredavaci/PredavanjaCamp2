package ba.bitcamp.lectures.arrays;
import java.util.Scanner;

/**
 * Takes 5 num and prints out largest.
 * A lot of code in case no arrays.
 * 
 * @author emir
 *
 */
public class MaxNum {
	public static void main(String[] args) {
		System.out.print("Unesite pet brojeva:");
		Scanner in = new Scanner(System.in);
		int broj1 = -1, broj2 = -1, broj3 = -1, broj4 = -1, broj5 = -1;
		broj1 = in.nextInt();
		if (broj1 > 0) {
			System.out.print("Slijedeci broj:");
			broj2 = in.nextInt();
			if (broj2 > 0) {
				System.out.print("Slijedeci broj:");
				broj3 = in.nextInt();
				if (broj3 > 0) {
					System.out.print("Slijedeci broj:");
					broj4 = in.nextInt();
					if (broj4 > 0) {
						System.out.print("Slijedeci broj:");
						broj5 = in.nextInt();
					}
				}
			}
		}
		in.close();
		System.out.println("Uneseni brojevi: ");
		System.out.println(broj1);
		System.out.println(broj2);
		System.out.println(broj3);
		System.out.println(broj4);
		System.out.println(broj5);
		int max = broj1;
		if (broj2 > max) {
			max = broj2;
		}
		if (broj3 > max) {
			max = broj3;
		}
		if (broj4 > max) {
			max = broj4;
		}
		if (broj5 > max) {
			max = broj5;
		}
		System.out.println("Najveci je " + max);
	}
}
