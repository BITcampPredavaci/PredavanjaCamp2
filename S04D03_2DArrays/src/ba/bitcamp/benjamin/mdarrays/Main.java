package ba.bitcamp.benjamin.mdarrays;

import java.util.Scanner;

public class Main {
	
	public static void change(int[] array){
		for(int i = 0; i < array.length; i++){
			array[i] = 3;
		}
	}
	
	public static void print1DArray(int[] array){
		for(int el : array){
			System.out.print(el + " ");
		}
		System.out.println();
	}
	
	public static void print2DArray(int[][] array){
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++){
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		/*Scanner in = new Scanner(System.in);
		System.out.println("Enter number of rows: ");
		int rows = in.nextInt();
		System.out.println("Enter number of columns: ");
		int columns = in.nextInt();
		
		int[][] matrix = new int[rows][columns];
		MatrixHelper.fillMatrix(matrix);
		MatrixHelper.print2DArray(matrix);
		
		int[] colum = MatrixHelper.getColumn(matrix, 1);*/
		
		int[][] funnyMatrix = new int[3][];
		for(int i = 0; i < funnyMatrix.length; i++){
			funnyMatrix[i] = new int[i+1];
		}
		MatrixHelper.print2DArray(funnyMatrix);
		//in.close();
	}

}
