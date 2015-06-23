package ba.bitcamp.lectures.recap.goemetry;

public class Pravougaonik implements ITijelo {
	double a, b;
	
	public Pravougaonik(double a, double b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public double povrsina() {
		return a * b;
	}

	@Override
	public double obim() {
		return 2 * (a + b);
	}
	
	@Override
	public String toString() {
		return String.format("Pravougaonik(a=%f, b=%f)", a, b);
	}
}
