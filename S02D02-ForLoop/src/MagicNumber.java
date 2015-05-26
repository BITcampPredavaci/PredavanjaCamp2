import java.util.Scanner;


public class MagicNumber {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int input = 1;
		
//		do {
//			
//			System.out.println("Unesi broj: ");
//			input = in.nextInt();
//			System.out.println("Taj broj: " + input);
//		}while(input != 0);
//		
		while(input != 0){
			System.out.println("Unesi broj: ");
			input = in.nextInt();
			System.out.println("Taj broj: " + input);
		}
		
	}
	
}
