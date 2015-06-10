package ba.bitcamp.s04d01;

/**
 * Program that greets any number of persons using names given as command-line
 * arguments.
 * 
 * @author Damir Zekić
 */
public class GreetUsersArgs {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Usage: hello.jar Name1 Name2 ...");
		} else {
			for (String name : args) {
				sayHello(name);
			}
		}
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
	 * @param name
	 *            Name of a user to greet.
	 */
	public static void sayHello(String name) {
		System.out.printf("Hello, %s!\n", name);
	}

}
