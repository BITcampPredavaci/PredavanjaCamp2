import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int num = in.nextInt();
		String message = "Broj je prost";

		boolean isPrime = true;

		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				message = "Broj nije prost";
				break;
			}
		}
		
		System.out.println(message);

	}

}
