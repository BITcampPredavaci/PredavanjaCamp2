
public class Table {

	public static void main(String[] args) {
		
		int m = 9 ,n = 9;
		
		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				//System.out.print(i*j+" ");
				System.out.printf("%2d ", i*j);
			}
			System.out.println();
		}
		
	}

}
