import java.util.Scanner;


public class ExpressionEvaluation {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a expresion of type int+-int");
		String expression = in.nextLine();
		
		int indexOfOperator = expression.indexOf('+');
		if(indexOfOperator == -1){
			indexOfOperator = expression.indexOf('-');
		}
		
		String firstNumberString = expression.substring(0, indexOfOperator);
		char operator = expression.charAt(indexOfOperator);
		String secondNumberString = expression.substring(indexOfOperator+1, expression.length());
		
		int firstNumber = Integer.parseInt(firstNumberString);
		int secondNumber = Integer.parseInt(secondNumberString);
		int result = 0;
		
		switch (operator){
		case '+':
			result = firstNumber + secondNumber;
			break;
		case '-':
			result = firstNumber - secondNumber;
			break;
		}
		
		System.out.printf("%d %c %d = %d", firstNumber, operator, secondNumber, result);
		
	}

}
