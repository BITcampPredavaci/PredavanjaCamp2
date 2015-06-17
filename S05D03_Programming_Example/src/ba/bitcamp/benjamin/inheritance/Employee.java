package ba.bitcamp.benjamin.inheritance;

public class Employee {
	
	protected String name;
	private String gender;
	
	
	public Employee(String name, String gender){
		this.name = name;
		this.gender = gender;
	}
	
	
	public String toString(){
		return "Emplyee class: " + name + " " + gender;
	}

}
