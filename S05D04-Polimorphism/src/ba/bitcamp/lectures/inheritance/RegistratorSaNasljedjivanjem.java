package ba.bitcamp.lectures.inheritance;


public class RegistratorSaNasljedjivanjem {
	public void registruj(Vozilo vozilo) {
		// vazi za svako vozilo
		System.out.println("Registrovano vozilo: " + vozilo.getRegistracija());
		
		// specifican za svaki tip vozila
		if (vozilo instanceof KopnenoVozilo) {
			// mora se uraditi cast da bi se moglo pristupiti poljima izvedene klase
			KopnenoVozilo kopneno = (KopnenoVozilo) vozilo;
			System.out.println("Obavijesti MUP, broj tockova: " + kopneno.getBrojTockova());
		} else if (vozilo instanceof VodenoVozilo) {
			System.out.println("Obavijesti Obalsku strazu");
		} else if (vozilo instanceof ZracnoVozilo) {
			System.out.println("Obavijesti Zracnu komandu");
		} else {
			throw new UnsupportedOperationException("Nepoznati tip vozila");
		}
	}
	
	public static void main(String[] args) {
		RegistratorSaNasljedjivanjem registrator = new RegistratorSaNasljedjivanjem();
		
		KopnenoVozilo kopneno = new KopnenoVozilo("KOPNO", 2000, 5, 4);
		kopneno.setRegistracija("KOPNO-1234");
		registrator.registruj(kopneno);
		
		VodenoVozilo vodeno = new VodenoVozilo("VODA-122", 1989, 15, true);
		registrator.registruj(vodeno);
		
		// poredjenje vozila;
		VodenoVozilo novaInstanca = new VodenoVozilo("VODA-122", 1989, 15, true);
		
		System.out.println("Jednaki: " + vodeno.equals(novaInstanca));
		novaInstanca = vodeno;
		System.out.println("Jednaki: " + vodeno.equals(novaInstanca));
		
		System.out.println("Jednak objektu: "  + vodeno.equals(new Object()));
	
		System.out.println("Vozilo toString: " + vodeno.toString());
	}
}
