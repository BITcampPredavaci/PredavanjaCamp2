package ba.bitcamp.benjamin.variables;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int num = 9;
		// int num2 = 2;
		// int mulitplication = num * num2;
		// double division = num / num2;
		// String message = "Broj " + " je: ";
		// int copyOfNum = num;
		// char character = 65 + 1;
		//
		// System.out.println(message+division);
		// System.out.println(character);

		int num = 9;
		int num2 = 2;

		// int sum = 2 + num++;

		boolean bool = 2 == 3;

		double division = (double) num / num2;

		int integerDivision = (int) (num / 2.0);
		
		int crazyNumber = 3;
		
		crazyNumber += crazyNumber++ + ++crazyNumber;
		
		System.out.println("Crazy number: " + crazyNumber);

		System.out.println("Num++: " + num++);
		System.out.println("Num: " + num);

		System.out.println("++Num2: " + ++num2);
		System.out.println("Num2: " + num2);

		System.out.println("Boolean: " + bool);

		System.out.println("9/2: " + division);

	}

}
