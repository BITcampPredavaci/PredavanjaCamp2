package ba.bitcamp.lectures.generics.methods;

import java.util.LinkedList;

public class QueueUtilsTest {
	public static void main(String[] args) {
		LinkedList<String> strQueue = new LinkedList<String>();
		QueueUtils.enqueueString(strQueue, "A");
		QueueUtils.enqueueString(strQueue, "B");
		QueueUtils.enqueueString(strQueue, "C");
		
		while (strQueue.size() > 0) {
			System.out.println(QueueUtils.dequeueString(strQueue));
		}
		
		QueueUtils.enqueue(strQueue, "D");
		
		// try with ints
		LinkedList<Integer> intQueue = new LinkedList<Integer>();
		QueueUtils.enqueue(intQueue, 1);
		// based of type from LinkedList Java "knows" second parameter should be Integer
		//QueueUtils.enqueue(intQueue, 1.0);
	}
}
