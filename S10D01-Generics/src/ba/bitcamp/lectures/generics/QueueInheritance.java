package ba.bitcamp.lectures.generics;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import ba.bitcamp.lectures.generics.string.StringQueueInheritance;


/**
 * Generic version of {@link StringQueueInheritance}.
 * It also has additional methods for demo other aspects of generic programming.
 * 
 * @author emir
 * 
 * @see StringQueueInheritance
 *
 * @param <E> type of queue element
 */
public class QueueInheritance<E> extends LinkedList<E> {

	private static final long serialVersionUID = 1L;

	public void enqueue(E val) {
		add(0, val);
	}
	
	public E dequeue() {
		return remove(size()-1);
	}
	
	/**
	 * Accepts collection of elements of type E, 
	 * but cannot be called for collection of elements that extend E.
	 * 
	 * @param elements to enqueue
	 */
	public void enqueueAll(Collection<E> elements) {
		Iterator<E> iter = elements.iterator();
		while(iter.hasNext()) {
			enqueue(iter.next());
		}
	}
	
	/**
	 * This method can accepts collection of elements of type E, 
	 * but also of elements of type that extends E.
	 * 
	 * @param elements to enqueue
	 */
	public void enqueueAllAnySubtype(Collection<? extends E> elements) {
		Iterator<? extends E> iter = elements.iterator();
		while(iter.hasNext()) {
			enqueue(iter.next());
		}
	}
	
	/**
	 * Method to flush queue elements to provided collection. 
	 * Collection must be of same type as this queue, 
	 * i.e. cannot pass {@code LinkedList<Object>} if E is not Object.
	 * @param target queue to dequeue to
	 */
	public void dequeueTo(QueueInheritance<E> target) {
		while (size() > 0) {
			target.enqueue(dequeue());
		}
	}
	
	/**
	 * Same as previous just accepts any collection. Same rule applies - must match type. 
	 * @param target collection to dequeue to
	 */
	public void dequeueToCollection(Collection<E> target) {
		while (size() > 0) {
			target.add(dequeue());
		}
	}

	/**
	 * Using ? super E, enables target to be collection of any type that is supertype of E.
	 * This means {@code Collection<Object>} is always acceptable.
	 * @param target
	 */
	public void dequeueToCollectionAnySuperType(Collection<? super E> target) {
		while (size() > 0) {
			target.add(dequeue());
		}
	}
	
	/**
	 * Conditional dequeue - dequeue if predicate evaluates to true.
	 * Demo how new generic interface can be defined and used in another generic class.
	 * 
	 * @param predicate to test if should dequeue
	 * @return element or null if predicate evaluate to false
	 */
	public E dequeIf(Predicate<E> predicate) {
		E last = get(size() - 1);
		if (predicate.evaluete(last)) {
			remove(size() - 1);
			return last;
		}
		return null;
	}
}
