
public class Program {
	
	private static boolean areUnique(String str){
		int[] counts = new int[255];
		char[] stringChars = str.toCharArray();
		
		for(char c : stringChars){
			counts[c]++;
			if(counts[c]!= 1)
				return false;
		}
		return true;
	}
	
	private static boolean isSubstring(String str1, String str2){
		str1 += str1;
		return str1.indexOf(str2) > -1;
	}
	
	private static int sumParams(double... params){
		int sum = 0;
		for(int i = 0; i < params.length; i++){
			sum += params[i];
		}
		return sum;
	}
	
	private static String stringify(Object... params){
		StringBuilder sb = new StringBuilder();
		for(Object s : params){
			sb.append(s);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(sumParams(1,2,3,4,5,6));
		System.out.println(sumParams(1,2));
		System.out.println(sumParams(1));
		System.out.println(sumParams(2.3, 4.3));
		System.out.println(sumParams(new double[]{4,5,6}));
		
		System.out.println(stringify("Neki", "String"));
		System.out.println(stringify(1,2,3,4,5,6));
		System.out.println("--------------------");
		System.out.println(areUnique("abc"));
		System.out.println(areUnique("abac"));
		
		System.out.println("Subs: " + 
		isSubstring("erbottlewat", "water"));
	}
}
