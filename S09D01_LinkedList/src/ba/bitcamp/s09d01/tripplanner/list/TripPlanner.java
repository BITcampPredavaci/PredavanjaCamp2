package ba.bitcamp.s09d01.tripplanner.list;

import java.util.Scanner;

/**
 * Program za planiranje putovanja
 * <p>
 * Omogućava unos proizvoljno mnogo mjesta koja možemo posjetiti.
 * 
 * @author Damir Zekić
 */
public class TripPlanner {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Trip t = new Trip();

		System.out.println("Unesite mjesta koja želite posjetiti:");

		while (true) {
			String placeName = s.nextLine();

			if (!placeName.equals("")) {
				// koristimo metodu `add` klase `Trip` da bismo dodali novo
				// mjesto u listu
				t.add(new Place(placeName));
			} else {
				break;
			}
		}

		System.out.println("Na vašem putu ćete proći kroz sljedeća mjesta:");
		System.out.println(t);
	}
}
