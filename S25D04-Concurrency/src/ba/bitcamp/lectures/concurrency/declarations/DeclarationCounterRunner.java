package ba.bitcamp.lectures.concurrency.declarations;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DeclarationCounterRunner {
	public static void main(String[] args) throws IOException, InterruptedException {
//		final DeclarationCounter counter = new DeclarationCounter("declarations.txt");
//		System.out.println(counter.count());

//		final Map<String, Integer> counts = new HashMap<String, Integer>();
		final Map<String, Integer> counts = new ConcurrentHashMap<String, Integer>();
		Thread t1 = getCounterThread("declarations.txt", counts);
		Thread t2 = getCounterThread("declarations.txt", counts);
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(counts);
	}
	
	private static Thread getCounterThread(final String path, final Map<String, Integer> counts) {
		return new Thread() {
			public void run() {
				try {
					new DeclarationCounter(path).count(counts);
				} catch (IOException e) {
					// ignore
					e.printStackTrace();
				}
			};
		};
	}
}
