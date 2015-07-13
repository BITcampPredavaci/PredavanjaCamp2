package ba.bitcamp.s09d01.numbers;

/**
 * "Čvor" linkane liste koja sadrži brojeve.
 * 
 * @author Damir Zekić
 */
public class Node {
	/**
	 * Vrijednost u čvoru liste
	 */
	private int value;
	/**
	 * Pokazivač/referenca na sljedeći element liste
	 */
	private Node next;
	
	public Node(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
}
