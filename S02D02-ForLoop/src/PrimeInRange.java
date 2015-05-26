public class PrimeInRange {

	public static void main(String[] args) {

		int endInterval = 10;
		boolean isPrime = true;
		for (int j = 1; j <= endInterval; j++) {
			isPrime = true;
			//checks if number is prime
			int num = j;
			
			for (int i = 2; i < num; i++) {
				//if there is an i which can divide num num is not prime
				if (num % i == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime == true) {
				System.out.println(num);
			}
			
		}

	}

}
