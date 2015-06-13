package ba.bitcamp.s04d01;

import java.util.Scanner;

/**
 * Program that prints a sum of numbers read from standard input.
 * <p>
 * The purpose of this program was to show how to redirect a file to standard
 * input. Export this program from eclipse to <code>sum.jar</code>, create a
 * text file named <code>input.txt</code> with a number per line (the last line
 * should be empty) and then run the program in the following way:
 * 
 * <pre>
 * java -jar sum.jar < input.txt
 * </pre>
 * 
 * 
 * @author Damir Zekić
 */
public class SumInput {

	public static void main(String[] args) {
		int sum = 0;
		Scanner s = new Scanner(System.in);

		while (true) {
			System.out.print("Upiši broj: ");
			String arg = s.nextLine();

			// stop the loop if a line is empty
			if (arg.equals("")) {
				break;
			}

			int number = Integer.parseInt(arg);

			System.out.println(number);

			sum += number;
		}

		System.out.printf("Suma je: %d\n", sum);
	}

}
