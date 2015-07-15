package ba.bitcamp.lectures.generics.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Class compares coding style with and without generics.
 * 
 * @author emir
 *
 */
public class CollectionUtils {
	/**
	 * Method that print collection of strings - demo of simple iterator usage.
	 * @param strings
	 */
	public static void printStrings(Collection<String> strings) {
		Iterator<String> iter = strings.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

	/**
	 * Row version of collection - wildcard ? is same as Object.
	 * @param coll
	 */
	public static void printStringsRaw(Collection<?> coll) {
		Iterator<?> iter = coll.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	/**
	 * Max String that works only for strings.
	 * @param strings
	 * @return
	 */
	public static String maxString(Collection<String> strings) {
		Iterator<String> iter  = strings.iterator();
		String max = null;
		while (iter.hasNext()) {
			String current = iter.next();
			if (max == null || max.compareTo(current) < 0) {
				max = current;
			} 
		}
		return max;
	}
	
	/**
	 * Max element that works for any collection of {@link Comparable}.
	 * Since it is not implemented in "generic" style, instanceof and casting has to be used.
	 * @param strings
	 * @return
	 */
	public static Object maxElementRaw(Collection<?> strings) {
		Iterator<?> iter  = strings.iterator();
		Object max = null;
		while (iter.hasNext()) {
			Object current = iter.next();
			if (max == null || (max instanceof Comparable && ((Comparable)max).compareTo(current) < 0)) {
				max = current;
			} 
		}
		return max;
	}
	
	/**
	 * Previous method implemented as generic.
	 * @param elements
	 * @return
	 */
	public static <T extends Comparable<T>> T maxElement(Collection<T> elements) {
		Iterator<T> iter  = elements.iterator();
		T max = null;
		while (iter.hasNext()) {
			T current = iter.next();
			if (max == null || max.compareTo(current) < 0) {
				max = current;
			} 
		}
		return max;
	}
	
	public static void main(String[] args) {
		ArrayList<String> testStrings = new ArrayList<String>();
		testStrings.add("XYZ");
		testStrings.add("ABC");
		testStrings.add("Test");
		
		CollectionUtils.printStrings(testStrings);
		System.out.println("\nRaw:");
		CollectionUtils.printStringsRaw(testStrings);
		
		String max = CollectionUtils.maxString(testStrings);
		System.out.println("\nMax: " + max);

		String maxRaw = (String)CollectionUtils.maxElementRaw(testStrings);
		System.out.println("\nMax el raw: " + maxRaw);

		String maxEl = CollectionUtils.maxElement(testStrings);
		System.out.println("\nMax el: " + maxEl);
	}
}
