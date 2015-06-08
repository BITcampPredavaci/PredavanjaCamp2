package ba.bitcamp.s04d01;

/**
 * Program that prints the sum of numbers given as command-line arguments.
 *  
 * @author Damir Zekić
 */
public class SumArguments {

	public static void main(String[] args) {
		int sum = 0;
		
		for (String arg : args) {
			int number = Integer.parseInt(arg);
			
			System.out.println(number);
			
			sum += number;
		}
		
		System.out.printf("Suma je: %d\n", sum);
	}

}
