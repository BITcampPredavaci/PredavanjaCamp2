import java.util.Scanner;


public class EvenNumbers {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Unos");
		int num = in.nextInt();
		int square = num * num;
		for(int i = 1; i < square; i++){
			if(i % 2 == 0){
				System.out.println(i);
			}
		}
		
		
		in.close();

	}

}
