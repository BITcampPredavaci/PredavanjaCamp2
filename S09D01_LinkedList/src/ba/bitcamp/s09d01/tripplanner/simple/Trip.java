package ba.bitcamp.s09d01.tripplanner.simple;

/**
 * Predstavlja putovanje između mjesta opisanog atributom `from` do mjesta
 * opisanog atributom `to`
 * 
 * @author Damir Zekić
 */
public class Trip {
	/**
	 * Mjesto iz kojeg se kreće
	 */
	private Place from;
	/**
	 * Odredište puta
	 */
	private Place to;

	/**
	 * Inicijalizira atribute `from` i `to` iz argumenata
	 * 
	 * @param from
	 *            polazna tačka
	 * @param to
	 *            odredište
	 */
	public Trip(Place from, Place to) {
		this.from = from;
		this.to = to;
	}

	public Place getFrom() {
		return from;
	}

	public void setFrom(Place from) {
		this.from = from;
	}

	public Place getTo() {
		return to;
	}

	public void setTo(Place to) {
		this.to = to;
	}

	/**
	 * Vraća opis puta kao string
	 */
	public String toString() {
		return String.format("Trip from %s to %s", from, to);
	}
}
