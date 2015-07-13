package ba.bitcamp.s09d01.numbers;

import java.util.Scanner;

/**
 * Demonstrira ad-hoc implementaciju linkane liste koristeći klasu Node
 * <p>
 * Propisno (ne ad-hoc) rješenje bi bilo izolovati kôd za dodavanje elemenata u
 * listu, traženje dužine i sumu u posebnu klasu.
 * 
 * @author Damir Zekić
 *
 */
public class ListOfNumbers {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		// pokazivači na prvi i posljednji element liste
		Node head = null;
		Node last = null;

		System.out.println("Unesite proizvoljan broj pozitivnih brojeva:");

		while (true) {
			int n = s.nextInt();

			if (n > 0) {
				Node newNode = new Node(n);

				if (head == null && last == null) {
					// kada dodajemo prvi element, on postaje ujedno i
					// posljednji
					head = newNode;
					last = newNode;
				} else {
					// za svaki sljedeći element, jednostavno dodajemo novi
					// element nakon posljednje i kažemo da je novi element
					// posljednji
					last.setNext(newNode);
					last = newNode;
				}
			} else {
				break;
			}
		}

		int length = 0;
		int sum = 0;

		// 1: inicijalizacija petlje
		Node currentNode = head;

		// 2: uslov petlje
		while (currentNode != null) {
			length += 1;
			sum += currentNode.getValue();

			// 3: promjena "brojača" petlje. hmm... ovo bi se moglo prepisati s
			// `for` petljom, ne?
			currentNode = currentNode.getNext();
		}

		System.out.printf("Unijeli ste %d pozitivnih brojeva\n", length);
		System.out.printf("Suma pozitivnih brojeva je: %d\n", sum);
	}

}
