
public class Palindrome {

	public static void main(String[] args) {
		
		int n = 121;
		int copy = n;
		
		int reverse = 0;
		
		while(n > 0 ){
			int digit = n % 10;
			reverse = reverse *10;
			reverse = reverse + digit;
			n = n / 10;
		}
		
		System.out.println("N: " + n);
		
		if(reverse == copy){
			System.out.println("Is palindrome");
		} else {
			System.out.println("Not palindrome");
		}
		
		
		
	}

}
