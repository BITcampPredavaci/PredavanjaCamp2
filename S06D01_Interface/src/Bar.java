public class Bar implements Compare {

	private String name;

	public Bar(String name) {
		this.name = name;
	}

	public String toString() {
		return "Bar: " + name;
	}

	@Override
	public int compare(Object o) {
		if (o instanceof Bar) {
			Bar other = (Bar) o;
			int thisLength = this.name.length();
			int otherLength = other.name.length();

			if (thisLength > otherLength)
				return 1;
			else if (thisLength < otherLength)
				return -1;
			else
				return 0;
		} else {
			throw new IllegalArgumentException();
		}
	
	}

}
