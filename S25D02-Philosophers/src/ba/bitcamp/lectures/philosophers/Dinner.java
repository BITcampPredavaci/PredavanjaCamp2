package ba.bitcamp.lectures.philosophers;

public class Dinner {
	public static void main(String[] args) {
		int philosophers = 5;
		Stick[] table = setTable(philosophers);
		Philosopher[] guests = sitGuests(table);
		startParty(guests);
	}

	private static Stick[] setTable(int philosophers) {
		Stick[] table = new Stick[philosophers];
		for (int i=0; i<philosophers; i++) {
			table[i] = new Stick(i);
		}
		return table;
	}

	private static Philosopher[] sitGuests(Stick[] table) {
		Philosopher[] philosophers = new Philosopher[table.length];
		for (int i=0; i<table.length; i++) {
			philosophers[i] = new Philosopher(i, table[i], table[(i+1)%table.length]);
		}
		return philosophers;
	}
	
	private static void startParty(Philosopher[] guests) {
		System.out.println("Starting party!!!");
		for (Philosopher ph : guests) {
			ph.start();
		}
	}
	
}
