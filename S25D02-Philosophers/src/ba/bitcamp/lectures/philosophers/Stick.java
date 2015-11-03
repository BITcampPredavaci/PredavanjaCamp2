package ba.bitcamp.lectures.philosophers;

public class Stick {

	private int index;
	private boolean free;

	public Stick(int index) {
		this.index = index;
		this.free = true;
	}
	
	public int getIndex() {
		return index;
	}
	
	public synchronized boolean takeIfFree() {
		if (free) {
			free = false;
			return true;
		}
		return false;
	}
	
	public void setFree() {
		free = true;
	}

}
