package ba.bitcamp.lectures.classes;

import ba.bitcamp.lectures.classes.structure.Ocjena;


public class Test {
	public static void main(String[] args) {
		Student s1 = new Student("Emir", "bla", new Ocjena[0]);
		s1.ispis();
		
		// ovo nije kopiranje s1
		Student s2 = s1;
		s2.postaviIme("novo");
		s2.ispis();
		// i s1 pokazuje na promijenjeni objekat
		s1.ispis();
		
		// reinicijalizacija varijable s2 - gleda na novi objekat
		s2 = new Student("Niko", "Nikic", new Ocjena[0]);
		s2.ispis();
		// s1 jos uvijek gleda na stari
		s1.ispis();
		
		// poziv static metode
		Student.ispisiStudenta(s2);
		// svaki ispis inkrementira brojac ispisa koji je static/klasna/globalna varijabla
		Student.kolikoIspisa();
		
		// Student sa ocjenama
		Ocjena[] ocjene = new Ocjena[1];
		ocjene[0] = new Ocjena();
		ocjene[0].predmet = "Predmet";
		ocjene[0].ocjena = 6;
		Student st = new Student("Pravi", "Pravic", ocjene);
		st.ispis();
		
		// ako je dobro skriveno - promjena nece utjecati
		ocjene[0].ocjena = 8;
		st.ispis();
		System.out.println(st.dajOcjenu(0).ocjena);
	}
}
