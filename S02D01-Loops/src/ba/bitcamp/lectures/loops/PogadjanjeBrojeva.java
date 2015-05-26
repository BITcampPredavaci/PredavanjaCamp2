package ba.bitcamp.lectures.loops;

import java.util.Scanner;

/**
 * Demo do while petlje na primjeru pogadjanja brojeva - more barem jedan pokusaj da bi se pogodilo.
 * Ovo je i prvi put koristenje standardnog ulaza kroz {@link Scanner}.
 * @author emir
 *
 */
public class PogadjanjeBrojeva {
	public static void main(String[] args) {
		int maksimalniBroj = 100;
		int zamisljeniBroj = (int) (Math.random() * maksimalniBroj);
		Scanner ulaz = new Scanner(System.in);
		System.out.println("Zamislio sam broj izmedju 1 i " + maksimalniBroj);
		int broj;
		int pokusaja = 0;
		do {
			System.out.print("Pogodi:");
			broj = ulaz.nextBigInteger().intValue();
			pokusaja++;
			if (broj > zamisljeniBroj) {
				System.out.println("Zamislio sam manji broj");
			} else if (broj < zamisljeniBroj) {
				System.out.println("Zamislio sam veci broj");
			}
		} while (broj != zamisljeniBroj);
		System.out.println(String.format("Pogodio si broj %d sa %d pokusaja", zamisljeniBroj, pokusaja));
		ulaz.close();
	}
}
