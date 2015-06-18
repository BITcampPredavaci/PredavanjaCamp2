package ba.bitamp.benjamin.programmingwithobjects;

public class User {

	private static int userCount = 0;
	
	private String name;
	private String surname;
	private int id;
	private int age;
	
	public User(String name, String surname){
		this(name, surname, 0);
	}
	
	
	public User(String name, String surname, int age){
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.id = ++userCount;
	}
	
	public User(User other){
		this(other.name, other.surname, other.age);
		userCount--;
		this.id = other.id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public int getId(){
		return id;
	}
	
	
	public boolean equals(User other){
		if( this.name.equals(other.name) && this.surname.equals(other.surname)
				&& this.age == other.age && this.id == other.id){
			return true;
		} else {
			return false;
		}
	}
	
	public String toString(){
		
		String output = String.format("Name: %s, Surname: %s, Id: %d", name, surname, id);
		return output;
	}
	
	
	
}
