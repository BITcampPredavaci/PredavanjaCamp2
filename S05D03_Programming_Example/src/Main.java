import ba.bitcamp.benjamin.cardgame.*;
import ba.bitcamp.benjamin.inheritance.Employee;
import ba.bitcamp.benjamin.inheritance.HourlyEmployee;
import ba.bitcamp.benjamin.inheritance.SalaryEmployee;

public class Main {

	public static void main(String[] args) {
		
		Employee e = new Employee("John", "Male");
		System.out.println(e);

		SalaryEmployee se = new SalaryEmployee("Sue", "Female", 2000);
		System.out.println(se);
		
		HourlyEmployee he = new HourlyEmployee("Joe", "Male", 15);
		System.out.println(he);
		
	}
}
