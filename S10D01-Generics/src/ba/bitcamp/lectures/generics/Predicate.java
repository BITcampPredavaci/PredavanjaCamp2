package ba.bitcamp.lectures.generics;

/**
 * Generic interface used to evaluate object for whatever purpose.
 * 
 * Here it is used for conditional dequeue.
 * 
 * @author emir
 * @see QueueInheritance
 *
 * @param <T> object type to evaluate
 */
public interface Predicate<T> {
	boolean evaluete(T el);
}
