package ba.bitcamp.lectures.inheritance.vic.noinheritance.parametrizirano;

public class Policajac {
	int pitanje = 0;
	
	public String potvrdi() {
		if (pitanje++ == 0) {
			return "Jeste!";
		}
		return "Aha!";
	}
	
	public String objasni() {
		return "Onaj ko potvrdi sa 'Aha' ima osnovnu, ko potvrdi sa 'Da' ima srednju, a ko potvrdi sa 'Jeste' fakultet";
	}
	
	@Override
	public String toString() {
		return "Policajac";
	}
}
