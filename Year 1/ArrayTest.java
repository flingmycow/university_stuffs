import java.util.Scanner;

public class ArrayTest {
	
	public static void main( String argv[] ) {

		Scanner keyboard = new Scanner(System.in);

		System.out.print( "How large do you want the array? " );
		int[] theArray = new int[keyboard.nextInt()];


		for( int i=0 ; i<theArray.length ; i++ ) 

		{

			System.out.print( "Enter value " + (i+1) + ": " );

			theArray[i] = keyboard.nextInt();

		}


		// prints out values
		for( int i : theArray ) 
		System.out.print( i + "\t" );
		System.out.println();

		// prints out user input values * 2
		for( int i=0 ; i<theArray.length ; i++ ) 
		theArray[i]*=2;

		for( int i : theArray ) 
		System.out.print( i + "\t" );

	}
}
	
