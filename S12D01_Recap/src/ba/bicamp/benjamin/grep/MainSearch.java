package ba.bicamp.benjamin.grep;

import java.io.File;
import java.util.Scanner;

public class MainSearch {
	
	
	public static void main(String[] args) {
		
		System.out.println("Enter search: ");
		Scanner in = new Scanner(System.in);
		String searchString = in.nextLine();
		
		Search s = new Search(searchString);
		s.startSearch();
		
		
		in.close();
	}

}
