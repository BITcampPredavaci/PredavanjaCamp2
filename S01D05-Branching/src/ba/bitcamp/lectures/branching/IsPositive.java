package ba.bitcamp.lectures.branching;


public class IsPositive {
	public static void main(String[] args) {
		String prviArgument = args[0];
		int broj = Integer.parseInt(prviArgument);
		boolean pozitivan = broj >= 0;
		System.out.println("Positive: " + pozitivan);
	}
}
