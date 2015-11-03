package ba.bitcamp.lectures.philosophers;
import java.util.Random;


public class Philosopher extends Thread {
	
	private static int MAX_THINK_TIME = 20;
	private static int MAX_EAT_TIME = 10;
	private static boolean smart = true;
	
	private Random rand = new Random();

	private int index;
	private Stick left;
	private Stick right;

	public Philosopher(int index, Stick left, Stick right) {
		this.index = index;
		this.left = left;
		this.right = right;
	}
	
	@Override
	public void run() {
		System.out.println("Philosopher " + index + ": Let's get wild...");
		while (true) {
			think();
			eat();
		}
	}
	
	private void doAction(String action, int maxTime) {
		System.out.println(String.format("Philosopher %d starting %s", index, action));
		int actionTime = rand.nextInt(maxTime);
		try {
			Thread.sleep(actionTime);
		} catch (InterruptedException e) {
			// not expected
			e.printStackTrace();
		}
		System.out.println(String.format("Philosopher %d finished %s", index, action));
	}

	private void think() {
		doAction("THINKING", MAX_THINK_TIME);
	}

	private void eat() {
		if (smart && right.getIndex() < left.getIndex()) {
			takeStick(right);
			takeStick(left);		
		} else {
			takeStick(left);
			takeStick(right);
		}
		doAction("EATING", MAX_EAT_TIME);
		leaveStick(right);
		leaveStick(left);
	}

	private void takeStick(Stick stick) {
		System.out.println(String.format("Philosopher %d waiting stick %d", index, stick.getIndex()));
		while (!stick.takeIfFree()) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// ignore
				e.printStackTrace();
			}
		}
		System.out.println(String.format("Philosopher %d took stick %d", index, stick.getIndex()));
	}
	
	private void leaveStick(Stick stick) {
		stick.setFree();
		System.out.println(String.format("Philosopher %d released stick %d", index, stick.getIndex()));
	}

}
