package ba.bitcamp.lectures.branching;

public class RelationalOperatorExamples {
	public static void main(String[] args) {
		// simple comparisons
		int a = 2;
		boolean positive = a > 0;
		System.out.println("Positive: " + positive);
		
		boolean negative = a < 0;
		System.out.println("Negative: " + negative);
		
		boolean positiveOrZero = a >= 0;
		System.out.println("Positive or zero: " + positiveOrZero);

		boolean negativeOrZero = a <= 0;
		System.out.println("Negative or zero: " + negativeOrZero);
		
		// different primitive types can be compared
		char zeroChar = 0;
		int zeroInt = 0;
		double zeroDouble = 0.0;
		System.out.println("\nZeros equal: " + (zeroInt == zeroDouble));
		System.out.println("Zero char equal: " + (zeroInt == zeroChar));

		// floating points are not safe to compare for equality
		double tenth = 0.1;
		double tenth3 = 0.3;
		double tenthSum = tenth + tenth + tenth;
		System.out.println("\nDouble calculations ok: " + (tenthSum == tenth3));
		System.out.println("Calculated value: " + tenthSum);
		double tolerance = 0.00001;
		System.out.println("Include tolerance when comparing: " + (Math.abs(tenthSum - tenth3) < tolerance));
		
		// Nan (Not a Number) cannot be related - every relation is false
		double nanVal = Math.sqrt(-1);
		System.out.println("\nNaN cannot be compared: ");
		System.out.println("NaN >= NaN: " + (nanVal >= Double.NaN));
		System.out.println("NaN <= NaN: " + (nanVal <= Double.NaN));
		System.out.println("Use Double.isNaN(nanVal): " + Double.isNaN(nanVal));
		
		// Strings (as any other Object) can be checked for equalty but that is not as expected
		String test1 = "test";
		String test2 = "test";
		String test3 = new String("test");
		System.out.println("\nStrings can but should not be compared with ==");
		System.out.println("1 == 2: " + (test1 == test2));
		System.out.println("1 == 3: " + (test1 == test3));
		System.out.println("Use test1.equals(test3)" + test1.equals(test3));
	}
}
