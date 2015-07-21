package ba.bitcamp.lectures.generics;

/**
 * Extension of {@link QueueInheritance} that has {@link Number} specific methods.
 * Demo how type narrowing is used.
 * 
 * @author emir
 *
 * @param <E>
 */
public class NumberQueue<E extends Number> extends QueueInheritance<E> {
	private static final long serialVersionUID = 1L;

	/**
	 * This method does not make sense for non numeric types.
	 * @return deque all elements from queue as single sum.
	 */
	public double dequeueAsSum() {
		double sum = 0;
		while (size() > 0) {
			sum += dequeue().doubleValue();
		}
		return sum;
	}
	
	/**
	 * Conditional dequeue  where condition is "hardocoded".
	 * @return
	 */
	public E dequeIfPositive() {
		E last = get(size() - 1);
		if (last.doubleValue() > 0) {
			remove(size() - 1);
			return last;
		}
		return null;
	}
	
	/**
	 * Same as previous just uses method with {@link Predicate} 
	 * from base class and implements predicate as anonymous class.
	 * @return
	 */
	public E dequeIfPositivePredicate() {
		return dequeIf(new Predicate<E>() {

			@Override
			public boolean evaluete(E el) {
				return el.doubleValue() > 0;
			}
		});
	}
}
