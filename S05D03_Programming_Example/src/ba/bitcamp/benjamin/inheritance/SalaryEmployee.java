package ba.bitcamp.benjamin.inheritance;

public class SalaryEmployee extends Employee {
	
	private int salary;
	
	public SalaryEmployee(String name, String gender, int salary){
		super(name, gender);
		this.salary = salary;
	}
	
	public String toString(){
		return "Salary Employee: " + name +  " " + salary;
	}
	

}
