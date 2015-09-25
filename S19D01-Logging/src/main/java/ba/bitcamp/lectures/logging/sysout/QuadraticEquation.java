package ba.bitcamp.lectures.logging.sysout;

import java.util.Arrays;

public class QuadraticEquation {
	// moguce je ubaciti jednu ili vise static varijabli koje odredjuju sta ide na sysout
	public static boolean SYSOUT_BITNO = false;
	public static boolean SYSOUT_NEBITNO = false;
	public static boolean SYSOUT_ERROR = true;
	
	public static double[] quadratic(double a, double b, double c) {
		// jedini nacin da se iskljuci je komentar
		//System.out.println(String.format("Kvadratna jednacina: %sx^2 + %sx + %s = 0", a, b, c));
		double d = b*b - 4 * a * c;
		sysoutBitno("Diskriminanta: " + d);
		if (d > 0) {
			sysoutNebitno("Diskriminanta pozitivna - ima rjesenja");
			double[] res = new double[2];
			double r = Math.sqrt(d);
			res[0] = (-b + r) / (2 * a);
			res[1] = (-b - r) / (2 * a);
			sysoutBitno("Rjesenja: " + Arrays.toString(res));
			return res;
		}
		sysError("Diskriminanta negativna, nema rjesenja!!!");
		return null;
	}
	
	private static void sysoutBitno(String msg) {
		if (SYSOUT_BITNO) {
			System.out.println(msg);
		}
	}
	
	private static void sysoutNebitno(String msg) {
		if (SYSOUT_NEBITNO) {
			System.out.println(msg);
		}
	}

	private static void sysError(String msg) {
		if (SYSOUT_ERROR) {
			System.err.println(msg);
		}
	}
	
	public static void main(String[] args) {
		double a = 1, b = 3, c = 2;
		System.out.println(String.format("Racunam kvadratnu za a=%s, b=%s, c=%s", a, b, c));
		double[] res = quadratic(a, b, c);
		System.out.println("Rezultat je: " + Arrays.toString(res));
		QuadraticEquation.SYSOUT_BITNO = true;
		quadratic(a, b, c);
	}
}
