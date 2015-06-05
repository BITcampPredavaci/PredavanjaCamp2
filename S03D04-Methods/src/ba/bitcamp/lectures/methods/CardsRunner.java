package ba.bitcamp.lectures.methods;

/**
 * Example of setting static fields and calling static method from other class.
 * @author emir
 *
 */
public class CardsRunner {
	public static void main(String[] args) {
		CardsWithMethods.zeljeniBrojMijesanja = 1;
		CardsWithMethods.brojZamijenaPoMijesanju = 1;
		CardsWithMethods.main(args);
	}
}
