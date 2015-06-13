package ba.bitcamp.benjamin.mdarrays;

import java.util.Scanner;

public class MatrixHelper {

	/**
	 * Prompts the user to enter the values for each element of the
	 * 2D array
	 * @param matrix the matrix we will fill
	 */
	public static void fillMatrix(int[][] matrix){
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++){
				System.out.printf("Enter the element at (%d, %d)"
						,i+1, j+1);
				matrix[i][j] = in.nextInt();
			}
		}
	}
	
	/**
	 * Prints a 2d array to the console row by row
	 * @param matrix the array we will print
	 */
	public static void print2DArray(int[][] matrix){
		
		for(int[] row : matrix){
			for(int element : row){
				System.out.print(element + " ");
			}
			System.out.println();
		}
		
	}
	
	public static int[] getColumn(int[][] matrix, int columnIndex){
		
		int[] column = new int[matrix.length];
		
		for(int i = 0; i < matrix.length; i++){
			column[i] = matrix[i][columnIndex];
		}
		
		return column;
	}
	
}
