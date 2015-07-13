package ba.bitcamp.s09d01.tripplanner.simple;

import java.util.Scanner;

/**
 * Program za planiranje putovanja
 * <p>
 * Omogućava unos polazne tačke i odredišta, a zatim ispisuje podatke o putu.
 * 
 * @author Damir Zekić
 */
public class TripPlanner {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.print("Enter your location: ");
		Place from = new Place(s.nextLine());

		System.out.print("Enter your destination: ");
		Place to = new Place(s.nextLine());

		Trip t = new Trip(from, to);
		System.out.println("Here are your trip details:");
		System.out.println(t);
	}
}
