import java.util.InputMismatchException;
import java.util.Scanner;


public class TryAndCatch {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		try {
		int input = in.nextInt();
		System.out.println(input);
		} catch(InputMismatchException e){
			System.out.println("Pogresan unos");
			e.printStackTrace();
		}
		
		System.out.println("Ovo je kraj programa");
		
	}

}
