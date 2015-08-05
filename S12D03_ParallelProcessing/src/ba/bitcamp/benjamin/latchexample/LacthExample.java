package ba.bitcamp.benjamin.latchexample;

import java.util.concurrent.CountDownLatch;

public class LacthExample {
	
	private static CountDownLatch latch = new CountDownLatch(3);
	
	public static void startExample(){
	
		new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					latch.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("The wainting thread can work");
			}
			
		}).start();
		
		latch.countDown();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();
		latch.countDown();
		
	}
	

}
