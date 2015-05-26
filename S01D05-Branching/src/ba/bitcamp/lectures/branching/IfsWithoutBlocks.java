package ba.bitcamp.lectures.branching;

public class IfsWithoutBlocks {
	public static void main(String[] args) {
		int a = 4;
		if (a < 10)
			if (a > 5)
				a--;
		else
			a++;
		System.out.println(a);
	}
}
