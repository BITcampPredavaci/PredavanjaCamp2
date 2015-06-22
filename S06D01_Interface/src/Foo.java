public class Foo implements Compare, Comparable, SomeInterface {

	private int foones;

	public Foo(int foones) {
		this.foones = foones;
	}

	public String toString() {
		return "Foo: " + foones;
	}

	@Override
	public int compare(Object o) {
		if (o instanceof Foo) {
			Foo other = (Foo) o;
			if (this.foones > other.foones)
				return 1;
			else if (this.foones < other.foones)
				return -1;
			else
				return 0;
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public int compareTo(Object o) {
		return compare(o);
	}

	@Override
	public void printArray(Object[] array) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reverseArray(Object[] array) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sort(Comparable[] array) {
		// TODO Auto-generated method stub
		
	}

}
