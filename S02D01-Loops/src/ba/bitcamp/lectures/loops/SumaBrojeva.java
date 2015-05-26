package ba.bitcamp.lectures.loops;

/**
 * Demo while petlje na primjeru sumiranja prvih N brojeva.
 * @author emir
 *
 */
public class SumaBrojeva {
	public static void main(String[] args) {
		int brojeva = 10;
		int suma = 0;
		int broj = 1;
		while(broj <= brojeva) {
			suma += broj;
			broj++;
		}
		System.out.println(String.format("Suma prvih %d brojeva je %d", brojeva, suma));
	}
}
