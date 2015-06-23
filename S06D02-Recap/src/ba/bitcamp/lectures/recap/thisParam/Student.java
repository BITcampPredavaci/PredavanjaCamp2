package ba.bitcamp.lectures.recap.thisParam;

/**
 * Klasa koja pokazuje kako se neka utility/toolbox/static metoda
 * moze primati objekat klase u kojoj je definisana, te kako se onda
 * ta metoda iskoristi iz instance metoda sa parametrom "this"
 * @author emir
 *
 */
public class Student {
	private String ime;
	private int[] ocjene;
	
	public Student(String ime, int...ocjene) {
		this.ime = ime;
		this.ocjene = ocjene;
	}
	
	@Override
	public String toString() {
		return ime + ": " + prosjecnaStaticOcjena(this);
	}
	
	public double prosjecnaInstanceOcjena() {
		return prosjecnaStaticOcjena(this);
	}
	
	public static double prosjecnaStaticOcjena(Student st) {
		int suma = 0;
		for (int o : st.ocjene) {
			suma += o;
		}
		return (double) suma / st.ocjene.length;
	}
}
