import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidInput {

	public static int getInput() {
		Scanner in = new Scanner(System.in);
		int number = 0;

		while (true) {
			try {
				System.out.println("Unesi broj");
				number = in.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Nije broj!");
				in.nextLine();
			}
		}

		return number;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int number = getInput();
		int number2 = getInput();
		
		System.out.println("Input is: " + number);
		System.out.println("Input2 is: " + number2);

	}

}
