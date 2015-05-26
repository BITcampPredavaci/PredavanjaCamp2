import java.util.Scanner;


public class LeastCommonDivisor {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int num1, num2;
		num1 = in.nextInt();
		num2 = in.nextInt();
		
		
		int lcd = -1;
		boolean found = false;
		
		for(int i = 2; i <= num1 || i <= num2; i++){
			if(num1 % i == 0 && num2 % i == 0){
				lcd = i;
				found = true;
				break;
			}
		}
		
		if(found == true){
			System.out.println(lcd);
		} else {
			System.out.println("Nema NZD");
		}

	}

}
