package ba.bitcamp.lectures.classes;

import ba.bitcamp.lectures.classes.structure.Ocjena;

/**
 * Encapsulated student class.
 * 
 * @author emir
 *
 */
public class Student {
	public static int brojacIspisa = 0;

	private String ime, prezime;
	private Ocjena[] ocjene;
	private double prosjek;
	
	public Student() {
		ime = "N/A";
		prezime = "N/A";
		ocjene = new Ocjena[0];
	}
	
	public Student(String novoIme, String novoPrezime, Ocjena[] noveOcjene) {
		if (novoIme != null && novoPrezime != null && noveOcjene != null) {
			ime = novoIme;
			prezime = novoPrezime;
			inicijalizirajOcjene(noveOcjene);
		} else {
			throw new RuntimeException("Paremetri ne mogu biti null");
		}
	}
	
	public void postaviIme(String novoIme) {
		ime = novoIme;
	}
	
	public String dajIme() {
		return ime;
	}
	
	public void postaviPrezime(String novoPrezime) {
		prezime = novoPrezime;
	}
	
	public String dajPrezime() {
		return prezime;
	}
	
	public void inicijalizirajOcjene(Ocjena[] noveOcjene) {
		ocjene = new Ocjena[noveOcjene.length];
		for (int i=0; i < ocjene.length; i++) {
			ocjene[i] = new Ocjena();
			ocjene[i].predmet = noveOcjene[i].predmet;
			ocjene[i].ocjena = noveOcjene[i].ocjena;
		}
		postaviProsjek();
	}

	public void postaviOcjenu(int indexOcjene, int vrijednost) {
		if (ocjene != null && ocjene.length > indexOcjene) {
			if (vrijednost > 5 && vrijednost < 11) {
				ocjene[indexOcjene].ocjena = vrijednost;
			} else {
				throw new RuntimeException("Ocjena mora biti od 6 do 10");
			}
		} else {
			throw new RuntimeException("Ocjene nisu inicijalizirane ili nema toliko ocjena");
		}
		postaviProsjek();
	}
	
	public Ocjena dajOcjenu(int indexOcjene) {
		if (ocjene != null && ocjene.length > indexOcjene) {
			return ocjene[indexOcjene];
		} else {
			throw new RuntimeException("Ocjene nisu inicijalizirane ili nema toliko ocjena");
		}
	}
	
	public void postaviProsjek() {
		if (ocjene != null) {
			int sumaOcjena = 0;
			int polozenoPredmeta = 0;
			for (Ocjena ocjena : ocjene) {
				if (ocjena.ocjena > 5) {
					sumaOcjena += ocjena.ocjena;
					polozenoPredmeta++;
				}
			}
			if (polozenoPredmeta > 0) {
				prosjek = sumaOcjena / polozenoPredmeta;
			} else {
				prosjek = Double.NaN;
			}
		} else {
			prosjek = Double.NaN;
		}
	}

	public double dajProsjek() {
		return prosjek;
	}

	public void ispis() {
		brojacIspisa++;
		System.out.println("Trenutni ispis: " + brojacIspisa);
		System.out.println("Ime: " + ime);
		System.out.println("Prezime: " + prezime);
		System.out.println("Prosjek: " + prosjek);
	}

	public static void ispisiStudenta(Student student) {
		System.out.println("Ime (iz static): " + student.ime);
		System.out.println("Prezime (iz static): " + student.prezime);
	}

	public static void kolikoIspisa() {
		System.out.println("Ukupno ispisa: " + brojacIspisa);
	}
}
