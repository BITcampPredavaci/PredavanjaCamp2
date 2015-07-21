package ba.bitcamp.lectures.generics;

import java.util.LinkedList;

import ba.bitcamp.lectures.generics.string.StringQueueComposition;

/**
 * Generic version of {@link StringQueueComposition}. 
 * Used only to demo how to generalize existing non-generic class
 * 
 * @author emir
 * @see QueueInheritance
 * @see StringQueueComposition
 *
 * @param <E> type of queue element
 */
public class QueueComposition<E> {
	private LinkedList<E> values;
	
	public QueueComposition() {
		values = new LinkedList<E>();
	}
	
	public int size() {
		return values.size();
	}
	
	public void enqueue(E val) {
		values.add(0, val);
	}
	
	public E dequeue() {
		return values.remove(values.size()-1);
	}
}
