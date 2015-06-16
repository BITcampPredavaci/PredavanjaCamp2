package ba.bitcamp.lectures.classes.structure;

/**
 * Utility classes for creating and working with Student structure.
 * @author emir
 *
 */
public class StudentToolbox {
	public static StudentStruktura noviStudent(String ime, String prezime) {
		StudentStruktura st = new StudentStruktura();
		st.ime = ime;
		st.prezime = prezime;
		st.ocjene = new Ocjena[3];
		
		Ocjena prvaOcjena = new Ocjena();
		prvaOcjena.predmet = "Prvi predmet";
		prvaOcjena.ocjena = 5;
		st.ocjene[0] = prvaOcjena;
		
		st.ocjene[1] = new Ocjena();
		st.ocjene[1].predmet = "Drugi predmet";
		st.ocjene[1].ocjena = 5;
		
		st.ocjene[2] = new Ocjena();
		st.ocjene[2].predmet = "Treci predmet";
		st.ocjene[2].ocjena = 5;
		
		return st;
	}
	
	public static double izracunajProsjek(StudentStruktura student) {
		if (student.ocjene != null) {
			int sumaOcjena = 0;
			int polozenoPredmeta = 0;
			for (Ocjena ocjena : student.ocjene) {
				if (ocjena.ocjena > 5) {
					sumaOcjena += ocjena.ocjena;
					polozenoPredmeta++;
				}
			}
			return (double) sumaOcjena / polozenoPredmeta;
		}
		return Double.NaN;
	}
	
	public static void postaviProsjek(StudentStruktura student) {
		student.prosjek = izracunajProsjek(student);
	}
}
