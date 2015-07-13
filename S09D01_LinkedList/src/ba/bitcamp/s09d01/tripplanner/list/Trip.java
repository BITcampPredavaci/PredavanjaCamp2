package ba.bitcamp.s09d01.tripplanner.list;

/**
 * Predstavlja putovanje kroz mjesta koja se sadrže u linkanoj listi
 * <p>
 * Atribut `start` pokazuje na prvi element liste.
 * 
 * @author Damir Zekić
 */
public class Trip {
	/**
	 * Prvi element liste mjesta koja treba posjetiti
	 */
	private Place start;

	public Place getStart() {
		return start;
	}

	public void setStart(Place start) {
		this.start = start;
	}

	/**
	 * Dodaje novo mjesto u listu mjesta koja treba posjetiti tokom putovanja
	 * 
	 * @param newPlace
	 *            mjesto koje ubacujemo na kraj liste.
	 */
	public void add(Place newPlace) {
		if (start == null) {
			// ako je lista prazna novi element jednostavno postaje početak
			start = newPlace;
		} else {
			// ako lista nije prazna, nalazimo kraj liste te postavljamo `next`
			// atribut posljednjeg elementa da pokazuje na naš posljednji
			// element
			Place last = start;

			while (last.getNext() != null) {
				last = last.getNext();
			}

			last.setNext(newPlace);
		}
	}

	/**
	 * Vraća podatke o putu kao string
	 * <p>
	 * Svako mjesto koje posjećujemo će se nalaziti u novom redu.
	 */
	public String toString() {
		String result = "";
		Place currentPlace = start;

		while (currentPlace != null) {
			result += String.format("%s\n", currentPlace.getName());
			currentPlace = currentPlace.getNext();
		}

		return result;
	}
}
