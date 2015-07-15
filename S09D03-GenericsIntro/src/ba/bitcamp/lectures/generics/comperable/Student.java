package ba.bitcamp.lectures.generics.comperable;

public class Student implements Comparable<Student> {
	private String ime;

	public Student(String ime) {
		this.ime = ime;
	}
	
	@Override
	public String toString() {
		return ime;
	}

	@Override
	public int compareTo(Student o) {
		return ime.compareTo(o.ime);
	}
}
