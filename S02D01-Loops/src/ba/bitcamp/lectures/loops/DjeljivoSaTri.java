package ba.bitcamp.lectures.loops;

/**
 * Demo kako se continue moze koristiti da se iteracija prekine prije vremena -
 * kao alternativa if-u.
 * @author emir
 *
 */
public class DjeljivoSaTri {
	public static void main(String[] args) {
		int broj = 0;
		while (broj++ < 100) {
			if (broj % 3 != 0) {
				continue;
			}
			System.out.println(broj);
		}
	}
}
