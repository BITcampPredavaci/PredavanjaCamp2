package ba.bitcamp.s09d01.tripplanner.simple;

/**
 * Predstavlja mjesto koje se može posjetiti tokom putovanja.
 *  
 * @author Damir Zekić
 */
public class Place {
	/**
	 * Naziv mjesta
	 */
	private String name;
	
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

	/**
	 * Vraća naziv mjesta
	 */
	public String toString() {
		return this.name;
	}
}
