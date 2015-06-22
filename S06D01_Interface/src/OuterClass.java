
public class OuterClass {
	
	private int number;
	private String name;
	public InnerClass ic;
	
	public OuterClass(){
		this.number = 10;
		ic = new InnerClass(20);
	}
	
	public int getNumber(){
		return number;
	}
	
	public void myMethod(){
		final int someInt = 40;
		InnerClass c = new InnerClass(5){
			@Override
			public void PrintVariables(int number){
				System.out.println("Inner class anoynmous");
				System.out.println("Some int: " +someInt);
				super.PrintVariables(number);
				
			}
		};
		
		c.PrintVariables(20);
	}
	
		 class InnerClass {
		
		private int innerNumber;
		private int number;
		
		public InnerClass(int number){
			this.number = number;
		}
		
		public void PrintVariables(int number){
			System.out.println("Param number: " + number);
			System.out.println("Inner number: " + this.number);
			System.out.println("Outer number: " + getNumber());
			System.out.println(name);
		}
		
	}
	
}
