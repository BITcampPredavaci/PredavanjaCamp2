package ba.bitcamp.lectures.loops;
/**
 * Demo prekida petlja kada dodatni uslov dozvoli.
 * Npr. prekidamo sumiranje zato sto suma nece moci stati u byte.
 * @author emir
 *
 */
public class LimitiranaSuma {
	public static void main(String[] args) {
		int brojeva = 100;
		int suma = 0;
		int broj = 1;
		boolean mozeStatiUByte = true;
		while(broj <= brojeva) {
			suma += broj;
			if (suma > Byte.MAX_VALUE) {
				mozeStatiUByte = false;
				break;
			}
			broj++;
		}
		if (mozeStatiUByte) {
			System.out.println(String.format("Suma prvih %d brojeva je %d", brojeva, suma));
		} else {
			System.out.println(String.format("Suma prvih %d brojeva ne moze stati u byte", brojeva, suma));
		}
	}
}
