import java.util.*;
import java.io.*;

public class PostfixCalc{
	
public static void main (String [] args) throws Exception {
	
	File file = new File("in.txt");
	Scanner sc = new Scanner(file);
	String input = sc.nextLine();
	Stack<Integer> calc = new Stack<Integer>();
	
	while(sc.hasNext()){

		for(int i = 0; i < input.length(); i++){
			char c = input.charAt(i);
			int x = 0;
			int y = 0;
			int r = 0;
    
			if(Character.isDigit(c)){
				int t = Character.getNumericValue(c);
					calc.push(t);
    }
    
    else if(c == '+'){
        x = calc.pop();
        y = calc.pop();
        r = x+y;
        calc.push(r);
    }
    
     else if(c == '-'){
        x = calc.pop();
        y = calc.pop();
        r = x-y;
        calc.push(r);
    }
    
     else if(c == '*'){
        x = calc.pop();
        y = calc.pop();
        r = x*y;
        calc.push(r);
    }
    
     else if(c == '/'){
        x = calc.pop();
        y = calc.pop();
        r = x/y;
        calc.push(r);
     	
     		}
     	}
}

 	int a = calc.pop();
 	System.out.println(a);
 	
	}
} 
