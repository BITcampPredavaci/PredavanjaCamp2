package ba.bitamp.benjamin.programmingwithobjects;

public class Main {
	
	static int a = 3;
	
	public static void PrintA0(){
		System.out.println(a);
	}
	
	public static void PrintA1(int a){
		System.out.println("Param: " + a + " Class: " + Main.a);
	}
	
	public static void PrintA2(){
		int a = 5;
		System.out.println(a);
	}
	
	public static void changeUser(User user){
		user.setName("From method");
	}
	
	
	public static void main(String[] args) {
		PrintA0();
		PrintA1(4);
		PrintA2();
		
		User u = new User("John", "Doe");
		
		User u2 = new User("Joe", "Bloggs", 12);
		
		u = u2;
		
		String s = "nesto";
		
		s.equals("neki drugi string");
		
		u2.setName("What name");
		
		System.out.println(u);
		System.out.println(u2);
		
		changeUser(u);
		System.out.println(u);
		
	}

}
