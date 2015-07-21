package ba.bitcamp.lectures.generics.methods;

import java.util.LinkedList;
import java.util.List;

/**
 * Demo writing generic utility methods.
 * @author emir
 *
 */
public class QueueUtils {
	/**
	 * Nongeneric method that enqueue string to provided list.
	 * @param queue
	 * @param el
	 */
	public static void enqueueString(List<String> queue, String el) {
		queue.add(0, el);
	}
	
	/**
	 * Nongeneric method that dequeue string from provided list.
	 * @param queue
	 * @return
	 */
	public static String dequeueString(List<String> queue) {
		return queue.remove(queue.size()-1);
	}
	
	/**
	 * Generic version of enqueue method.
	 * @param queue
	 * @param el
	 */
	public static <E> void enqueue(LinkedList<E> queue, E el) {
		queue.add(0, el);
	}
	
	/**
	 * Generic version of dequeue method.
	 * @param queue
	 * @return
	 */
	public static <E> E dequeue(LinkedList<E> queue) {
		return queue.remove(queue.size()-1);
	}
	
	/**
	 * Narrowing can be applied on utility methods as well.
	 * @param numQueue
	 * @return
	 */
	public static <E extends Number> double dequeueAsSum(LinkedList<E> numQueue) {
		double sum = 0;
		while (numQueue.size() > 0) {
			sum += dequeue(numQueue).doubleValue();
		}
		return sum;
	}
	
	/**
	 * Same as previous, just use wildacards instead of generic type.
	 * In some cases there is no need to have generic type, but in others is (i.e. have additional parameter that must match).
	 * @param numQueue
	 * @return
	 */
	public static double dequeueAsSumWildcard(LinkedList<? extends Number> numQueue) {
		double sum = 0;
		while (numQueue.size() > 0) {
			sum += dequeue(numQueue).doubleValue();
		}
		return sum;
	}
}
