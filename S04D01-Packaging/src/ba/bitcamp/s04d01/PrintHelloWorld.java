package ba.bitcamp.s04d01;

/**
 * Program that greets the world.
 * <p>
 * The purpose of this program is to show how to write javadocs.
 * 
 * @author Damir Zekić
 */
public class PrintHelloWorld {
	
	public static void main(String[] args) {
		sayHello();
		sayHello("Kristina");
	}

	/**
	 * Prints hello world to the screen.
	 * <p>
	 * Sends string "Hello, world!" to the standard output.
	 */
	public static void sayHello() {
		System.out.println("Hello, world!");
	}

	/**
	 * Greets a user by name.
	 * 
	 * @param name Name of a user to greet.
	 */
	public static void sayHello(String name) {
		System.out.printf("Hello, %s!\n", name);
	}

}
