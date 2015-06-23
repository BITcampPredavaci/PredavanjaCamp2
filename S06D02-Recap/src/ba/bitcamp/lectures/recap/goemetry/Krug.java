package ba.bitcamp.lectures.recap.goemetry;

public class Krug implements ITijelo {
	private double r;

	public Krug(double r) {
		this.r = r;
	}

	@Override
	public double povrsina() {
		return r * r * Math.PI;
	}

	@Override
	public double obim() {
		return 2 * r * Math.PI;
	}
	
	@Override
	public String toString() {
		return String.format("Krug(r=%f)", r);
	}
}
