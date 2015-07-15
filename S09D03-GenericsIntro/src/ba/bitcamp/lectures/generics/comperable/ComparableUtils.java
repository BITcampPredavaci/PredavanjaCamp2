package ba.bitcamp.lectures.generics.comperable;

import ba.bitcamp.lectures.generics.numbers.NumberUtils;

/**
 * Util class that demonstrates how code from {@link NumberUtils} can be
 * additionally generalized with use of compareTo instead of ">" operator
 * @author emir
 *
 */
public class ComparableUtils {
	/**
	 * Class that finds "max student".
	 * @param arr
	 * @return
	 */
	public static Student max(Student[] arr) {
		if (arr != null && arr.length > 0) {
			Student max = arr[0];
			for (int i = 1; i < arr.length; i++) {
				if (max.compareTo(arr[i]) < 0) {
					max = arr[i];
				}
			}
			return max;
		}
		throw new UnsupportedOperationException("Array must be nonempty");
	}
	
	/**
	 * Generic version of previous method that works with whatever implements {@link Comparable}, including {@link Student}
	 * @param arr
	 * @return
	 */
	public static <T extends Comparable<T>> T maxComperable(T[] arr) {
		if (arr != null && arr.length > 0) {
			T max = arr[0];
			for (int i = 1; i < arr.length; i++) {
				if (max.compareTo(arr[i]) < 0) {
					max = arr[i];
				}
			}
			return max;
		}
		throw new UnsupportedOperationException("Array must be nonempty");
	}
	
	public static void main(String[] args) {
		Student[] students = {new Student("ABC"), new Student("XYZ"), new Student("Test")};
		System.out.println(ComparableUtils.max(students));
		// in case of generic method nothing is lost - return value is still Student when you call it with Student[]
		Student st = ComparableUtils.maxComperable(students);
		System.out.println(st);
		
		// generic method can be used for String[] as well
		String[] predmeti = {"IT", "MAT", "EL"};
		// java "figures" return value is now String since input is String[]
		String pr = ComparableUtils.maxComperable(predmeti);
		System.out.println(pr);
	}
}
