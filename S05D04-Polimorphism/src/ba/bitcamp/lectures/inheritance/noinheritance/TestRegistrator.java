package ba.bitcamp.lectures.inheritance.noinheritance;

public class TestRegistrator {
	public static void main(String[] args) {
		Registrator registrator = new Registrator();
		
		KopnenoVozilo kopneno = new KopnenoVozilo("ABC-123", 2000, 5, 4);
		registrator.registruj(kopneno);
		
		VodenoVozilo vodeno = new VodenoVozilo("VODA-122", 1989, 15, true);
		registrator.registruj(vodeno);
		
		ZracnoVozilo zracno = new ZracnoVozilo("AIR-123", 1979, 99, 33);
		registrator.registruj(zracno);
	}
}
