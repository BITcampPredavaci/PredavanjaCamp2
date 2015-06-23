package ba.bitcamp.lectures.recap.thisParam;

public class TestStudent {
	public static void main(String[] args) {
		int[] ocjene = new int[] {1, 2, 3};
		// varargs kao niz
		Student st = new Student("Test", ocjene);
		
		// primjer varargs
		Student st2 =  new Student("Test2", 1, 2);
		
		// bez varargs je kao new int[0]
		Student st3 = new Student("Test3");
		
		System.out.println("Prosjecna static: " + Student.prosjecnaStaticOcjena(st));
		System.out.println(st.toString());
		System.out.println("Prosjecna instance: " + st.prosjecnaInstanceOcjena());
	}
}
