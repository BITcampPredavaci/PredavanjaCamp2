import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Program {

	private static Compare getMax(Compare[] array){
		Compare max = array[0];
		for(int i = 1; i < array.length; i++){
			if(max.compare(array[i]) == -1){
				max = array[i];
			}
		}
		return max;
	}
	
	
	private static void PrintArray(Object[] objects){
		for(int i = 0; i < objects.length; i++){
			System.out.print(objects[i] + " ");
		}
		System.out.println();
	}
	
	
	
	public static void main(String[] args) {
		
		Foo[] array = new Foo[5];
		for(int i = 0; i < array.length; i++){
			array[i] = new Foo(i+1);
		}
		
		Bar[] barArray = new Bar[3];
		barArray[0] = new Bar("A");
		barArray[1] = new Bar("AB");
		barArray[2] = new Bar("ABC");
		
		
		Integer[] arrayInt = new Integer[5];
		for(int i = 0; i  < arrayInt.length; i++){
			arrayInt[i] = (int)(1 + Math.random() * 20);
		}
		
		PrintArray(array);
		PrintArray(barArray);
		PrintArray(arrayInt);
		
		OuterClass oc = new OuterClass();
		
		oc.ic.PrintVariables(0);
		
		
		
	}

}
