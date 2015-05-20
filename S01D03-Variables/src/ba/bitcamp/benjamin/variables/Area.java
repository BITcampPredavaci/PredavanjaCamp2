package ba.bitcamp.benjamin.variables;

public class Area {

	public static void main(String[] args) {
		
		int binary = 0b101;
		
		double bigNumber = 100_000_000_000_000.0;
		
		System.out.println("Binary " + binary);
		
		double longNumber = 10.0 / 3;
		System.out.println("Long number: " + longNumber);
		
		int num1 = 3, num2 = 4;
		
		String message = "Ja sam string";
		
		System.out.printf("Ovdje je broj1: %3d i ovdje je broj2: %d\n "
				+ "Double: %.1f"
				+ "\nString: %s", num1, num2, longNumber, message);
		//System.out.println("Ovdje je broj1: " + num1 + " i ovdje je broj2: " + num2);

	}

}
