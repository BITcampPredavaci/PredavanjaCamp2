package ba.bitcamp.lectures.generics.numbers;

/**
 * Example util class for demontrating code duplication if you use primitives.
 * Also shows how using wrapper classes resolves some of issues.
 * @author emir
 *
 */
public class NumberUtils {
	/**
	 * This can only take array of integers
	 * @param nums
	 * @return
	 */
	public static int max(int[] nums) {
		if (nums != null && nums.length > 0) {
			int max = nums[0];
			for (int i = 1; i < nums.length; i++) {
				if (max < nums[i]) {
					max = nums[i];
				}
			}
			return max;
		}
		throw new UnsupportedOperationException("Array must be nonempty");
	}

	/**
	 * Similar to one with int, only diff is that it uses short wherever int was used.
	 * @param nums
	 * @return
	 */
	public static short max(short[] nums) {
		if (nums != null && nums.length > 0) {
			short max = nums[0];
			for (int i = 1; i < nums.length; i++) {
				if (max < nums[i]) {
					max = nums[i];
				}
			}
			return max;
		}
		throw new UnsupportedOperationException("Array must be nonempty");
	}

	/**
	 * If we use Number - base class for primitive wrappers, you can call same method
	 * with Integer[] or Double[] or Short[]...
	 * @param nums
	 * @return
	 */
	public static Number max(Number[] nums) {
		if (nums != null && nums.length > 0) {
			Number max = nums[0];
			for (int i = 1; i < nums.length; i++) {
				if (max.doubleValue() < nums[i].doubleValue()) {
					max = nums[i];
				}
			}
			return max;
		}
		throw new UnsupportedOperationException("Array must be nonempty");
	}

	public static void main(String[] args) {
		// in case you use primitives, there is no alternative but duplicating code
		short[] nums = { 1, 2, 5, 100, 23 };
		System.out.println(NumberUtils.max(nums));
		// method overloading helps client code to ignore that it is actually duplicate code
		Integer[] objInts = { 1, 2, 5, 100, 23 };
		System.out.println(NumberUtils.max(objInts));
		
		// in case you use wrapper classes you can have one implementation
		Double[] objDoubles = { 1.0, 2.1, 5.1, 100.2, 23.4 };
		System.out.println(NumberUtils.max(objDoubles));

		// works also even if you mix types - in some cases it is good in others bad (you would like compiler to warn you)
		Number[] objNums = { 1, 2L, 5.1, 100.2, 23.4 };
		System.out.println(NumberUtils.max(objNums));
	}
}
