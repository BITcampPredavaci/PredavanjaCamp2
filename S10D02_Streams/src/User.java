import java.io.Serializable;


public class User implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -999364679428672230L;
	private String name;
	private int age;
	
	public User(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	
	@Override
	public String toString(){
		return String.format("%s %d", name, age);
	}

}
