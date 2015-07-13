package ba.bitcamp.s09d01.tripplanner.list;

/**
 * Predstavlja mjesto koje se može posjetiti tokom putovanja, a implementirana
 * je kao čvor uvezane (linkane) liste.
 * 
 * @author Damir Zekić
 */
public class Place {
	/**
	 * Naziv mjesta
	 */
	private String name;
	/**
	 * Referenca na sljedeći element linkane liste
	 */
	Place next;

	/**
	 * Inicijalizira naziv mjesta argumentom
	 * 
	 * @param name naziv mjesta
	 */

	public Place(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Place getNext() {
		return next;
	}

	public void setNext(Place next) {
		this.next = next;
	}
	
	/**
	 * Vraća naziv mjesta
	 */
	public String toString() {
		return this.name;
	}
}
