package ba.bitcamp.lectures.inheritance.vic.polimorfizam;

public class Srednja extends Osnovna {
	public String potvrdi() {
		return "Da!";
	}
	
	@Override
	public String ime() {
		return "Srednja";
	}
	
	@Override
	public boolean srednja() {
		return true;
	}
}
