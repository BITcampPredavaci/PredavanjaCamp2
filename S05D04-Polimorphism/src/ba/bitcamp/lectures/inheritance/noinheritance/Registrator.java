package ba.bitcamp.lectures.inheritance.noinheritance;

public class Registrator {
	public void registruj(KopnenoVozilo vozilo) {
		System.out.println("Registrovano vozilo: " + vozilo.getRegistracija());
		System.out.println("Obavijesti MUP, broj tockova: " + vozilo.getBrojTockova() );
	}
	
	public void registruj(VodenoVozilo vozilo) {
		System.out.println("Registrovano vozilo: " + vozilo.getRegistracija());
		System.out.println("Obavijesti Obalsku strazu, ima propeler: " + vozilo.isPropeler());
	}
	
	public void registruj(ZracnoVozilo vozilo) {
		System.out.println("Registrovano vozilo: " + vozilo.getRegistracija());
		System.out.println("Obavijesti Obalsku strazu, raspon krila: " + vozilo.getRasponKrila());
	}
}
