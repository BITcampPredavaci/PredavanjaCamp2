package ba.bitcamp.lectures.loops;

/**
 * Demonstracija pravila vidljivosti varijabli unutar i izvan blokova.
 * @author emir
 *
 */
public class BlockScope {
	public static void main(String[] args) {
		int mainScope = 100;
		if (mainScope > 0) {
			int ifScope = 10;
			// int mainScope = 10; ERROR cannot define if scope variable with same name as one in parent scope
			// but can assign to varible from parent scope
			mainScope = 99;
		}
		System.out.println("mainScope after if block: " + mainScope);
		// System.out.println(ifScope); ERROR cannot access to variable from child scope
		// but can define one with same name
		int ifScope = 1;
		System.out.println("ifScope from main: " + ifScope);
		
		// block can be defined independently
		{
			// same rules apply
			// int mainScope = 0; ERROR cannot declare variable with same name
			int blockScope = 100;
		}
		// System.out.println(blockScope); ERROR - cannot access block variable
	}
}
