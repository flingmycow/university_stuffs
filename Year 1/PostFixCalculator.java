import java.util.Stack;
import java.util.Scanner;

public class PostFixCalculator {
	/** 
	The program reads input of digits and symbols +,-,*,/ that
	form a valid postfix expressions of binary arithmetic operations.
	In postfix notation an operation follows its operands:
	7 8 + means 7 + 8 and evaluates to 15.
	2 3 + 7 * means (2 + 3) * 7 and evaluates to 35.
	Postfix notation doesn't use parentheses. 

	In this program for simplicity we only use single digit numbers
	as input and don't use spaces. 

	Example:
	653*+83-+ = (6 + (5 * 3)) + (8 - 3) = 26

        Minimum requirements:
	The program doesn't handle spaces in data (it may give incorrect results)
	If the input is not well-formed then an error may occur or an incorrect 
        result may be returned.
        These requirements may be refined later
	**/
	
	public static void main(String [] args) {
		// create a new scanner to read the data in	
		Scanner read = new Scanner(System.in);
		// prompt the use for data
		System.out.println("Please enter your input string");
		// read the entire expression
		String input = read.nextLine(); // reads until a whitespace or new line
		// print it back to make sure that it is read cotrrectly
		System.out.println(input);

		// create a new stack. It stores operands that still need 
		// to be evaluated
		Stack<Integer> operations = new Stack<Integer>();
		
		for (int i = 0; i < input.length(); ++i) {
			// getting the next character of the string
			char c = input.charAt(i);
			
			// variables to store the operands are declared outside  
			// of if/else for easier reuse
			int num1 = 0, num2 = 0;
			
                        // checking if the charcater is a digit
			if (Character.isDigit(c)) {
				    // fill in your code here
			} 
			else {
                                    // fill in your code here	
			}
			
		}
		
		// print the result here
			
	}

}
