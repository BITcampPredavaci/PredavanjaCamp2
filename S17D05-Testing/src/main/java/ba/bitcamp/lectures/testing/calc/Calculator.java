package ba.bitcamp.lectures.testing.calc;

public class Calculator {
	public Number add(Number n1, Number n2) {
		if (n1 != null && n2 != null) { 
			double r = n1.doubleValue() + n2.doubleValue();
			if (n1 instanceof Integer && n2 instanceof Integer && (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE)) {
				return Double.NaN;
			}
			return r;
		}
		return Double.NaN;
	}

	public Number sub(Number n1, Number n2) {
		return 0;
	}

	public Number mult(Number n1, Number n2) {
		return 0;
	}
	
	public Number div(Number n1, Number n2) {
		return 0;
	}
}
