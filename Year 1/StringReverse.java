package codesnippets;
import java.util.Scanner;
import java.util.Stack;
/*
 * This code snippet shows a how to reverse a string using a Stack. 
 */
public class StringReverse {
	
	public static void main(String [] args){
		
		Scanner scanner = new Scanner(System.in);
		String str = "";
		Stack<String> stack = new Stack<String>();
		
		System.out.println("Enter a string to be reversed: ");
		
		str = scanner.nextLine();
		
		if (str == null || str.equals("")){
			
			System.out.println("It seems you aren't ready as yet to enter the string, ok buhbye !!");
			System.exit(0);
		}
		
		for (int i=0;i<str.length();i++){
			
			// Here we push all the characters in the string one by one into the Stack
			stack.push(str.substring(i,i+1));
		}
		
		String strrev = "";
		while(!stack.isEmpty()){
			
			// Here we pop all the elements from the Stack one by one which is essentially reversing.
			strrev += stack.pop(); 
		}
		
		System.out.println("Reverse of the string \"" + str + "\" is: \"" + strrev + "\"");
	}
}
