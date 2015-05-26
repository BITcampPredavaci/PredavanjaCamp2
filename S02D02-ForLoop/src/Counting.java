import java.util.Scanner;


public class Counting {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int countEven = 0, countOdd = 0;
		int input;
		
		do{
			input = in.nextInt();
			if(input == 0){
				break;
			}
			
			if(input % 2 == 0){
				countEven++;
			} else {
				countOdd++;
			}
			
		}while(input != 0);
		
		System.out.printf("Parnih ima %d, a neparnih ima %d", countEven, countOdd);
		
	}
}
