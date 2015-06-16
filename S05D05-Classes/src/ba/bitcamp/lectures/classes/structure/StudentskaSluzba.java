package ba.bitcamp.lectures.classes.structure;

/**
 * Example how structure and toolbox can be misused.
 * @author emir
 *
 */
public class StudentskaSluzba {
	public static void main(String[] args) {
		StudentStruktura st = StudentToolbox.noviStudent("Niko", "Nikic");
		
		StudentToolbox.postaviProsjek(st);
		System.out.println("Prosjek: " + st.prosjek);
		
		// polaze prvi predmet
		st.ocjene[0].ocjena = 8;
		StudentToolbox.postaviProsjek(st);
		System.out.println("Novi prosjek: " + st.prosjek);
		
		
		// nova radnica u studentskoj
		st.ocjene[1].ocjena = 6;
		st.prosjek = (st.prosjek + 6) / 2;
		System.out.println("Novi prosjek: " + st.prosjek);
		
		st.ocjene[2].ocjena = 6;
		st.prosjek = (st.prosjek + 6) / 2;
		System.out.println("Novi prosjek: " + st.prosjek);
		
		StudentToolbox.postaviProsjek(st);
		System.out.println("Novi prosjek: " + st.prosjek);
		
	}
}
