// Comp104 - Assignment 2
// Post Fix Evaluation Program
// By: Fumiko Saito

import java.util.Scanner;
import java.util.*;
import java.util.Stack;
import java.util.Arrays;


public class PostFixEval {

	
public static void main(String[] args) {

	String InputText;
	boolean loop1 = true;

	System.out.println("Enter some numeric values and arithmetic operators with a semi-colon at the end");
	Scanner scan = new Scanner(System.in);
	InputText = scan.nextLine();
	while(loop1 == true)
	{
		if (InputText.contains (";")) { // loops until the user puts in a semi-colon 
		
			System.out.println(InputText); 
			loop1 = false;
	
		}
	
	else {
		System.out.println("Please enter values and operators with a semi-colon at the end");
		InputText = scan.nextLine();
	
	}
}
	
	
	String delims = "[ .,?!;]+"; // Removes any whitespace or these characters from the input
	String[] tokens = InputText.split(delims); // splits up string into an array called tokens
	
	for (int i = 0; i < tokens.length; i++) 
		System.out.println(tokens[i]); // prints out all the tokens individually

	Stack stack = new Stack<integer> (); // creates a stack
	
	
	
	for(int i = 0; i < tokens.length; i++) {
		stack.add(tokens[i]);
		System.out.println("LOAD R" + i + ", " + stack.pop());
		System.out.println("PUSH R" + i);
		
		}
	
		
		
	}
}
