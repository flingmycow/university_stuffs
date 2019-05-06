public class Testing 
{
	public static void main(String[] args)
	{
		int[] pipes = {10, 4, 5, 7, 8};
		cutting(pipes);
	}
	
	public static int cutting(int[] c) 
	{
			
	int totalLength = c[0];	// length of the pipe to be cut
	
	int[] newPipe = new int[c.length + 1];
	
	newPipe[c.length] = c[0];

	c[0] = 0; // make the number at the first element = 0
	
	// Copies the values from the old array into a new one with 0 at index 0 and at the last index the length of the pipe
	for (int i = 0; i < c.length; i++)
	{
		newPipe[i] = c[i];
		System.out.println("Value of newPipe["+i+"] is " +newPipe[i]);
	}
	
	System.out.println("Value of newPipe["+(c.length)+ "] is " +newPipe[c.length] + "\n");
	
	// Create a new array which will hold the difference of cut length between two cut sizes
	int[] cutDiff = new int[newPipe.length + 1]; // make a new int array with the same size as c
	System.out.println("Length of the array inputted is : " +c.length);
		
	cutDiff[0] = 0;
	System.out.println("The value of the array difference at position [0] is " +cutDiff[0]);
	// calculate the difference between each cut
	for (int i = 1; i < newPipe.length; i++)
	{
		cutDiff[i] = newPipe[i] - newPipe[i-1]; // assign into difference array
		System.out.println("The value of the array difference at position ["+i+"] is " +cutDiff[i]);
	}
	
	// assign the last array element as 0
	cutDiff[c.length+1] = 0;
	System.out.println("The value of the array difference at position ["+(c.length+1)+"] is " +cutDiff[c.length+1]);
	
	int temporary;
	int[] smallDiff = new int[newPipe.length]; // array of size 6 ATM
	
	// store values into array called smallDiff which will store SUMS of the differences in cut.
	// Used to find which length difference when added is the smallest. helps decide what cuts to do.
	for (int j = 0; j < newPipe.length; j++)
	{
		smallDiff[j] = cutDiff[j] + cutDiff[j+1];
		System.out.println("Values of smallDiff["+j+"] is " +smallDiff[j]);
	}
	
	int min = Integer.MAX_VALUE;
	int p = 0;

	
	// Checks whethere there are any duplicates in the array smallDiff
	/*for (int i = 0; i < smallDiff.length - 1; i++) 
	{
		if(smallDiff[i] == smallDiff[i + 1]) 
		{
			System.out.println("Duplicate: " + smallDiff[i]);
		}
	}

	for (int i = 1; i < smallDiff.length; i++) 
	{
		if(smallDiff[i] == smallDiff[i-1])
		{
			System.out.println("Duplicate: " + smallDiff[i]);
		}
	}*/
	
	int smallest = smallDiff[1];
	
	for (int j = 2; j < smallDiff.length - 1; j++)
	{
		if (smallDiff[j] < smallest)
		{
			smallest = smallDiff[j];
		}
	}
	
	System.out.println("Value of the smallest number is : " +smallest);
	
	/*int duplicates = 0;
	
	for (int i = 1; i < smallDiff.length - 1; i++)
	{
		if (smallest == smallDiff[i])
		{	
			duplicates++;
		}
	}
	
	System.out.println("There are " +duplicates+ " in the array of value " +smallest);
	
	int[] duplicates = new int[smallDiff.length];
	
	// If there are more than one of a number...
	if (duplicates > 1)
	{
		    for(int i = 0; i < smallDiff.length; i++)
		    {
		    	    if(duplicates[i] == value)
		    	    {
		    	    	    index = i;
		    	    	    break;	// breaks when the index of the first occurance of the value is found
		    	    }
		    }
	}
	
	
	else
	{
		
	}*/
	
	int smallIndex = Arrays.asList(smallDiff).indexOf(smallest);
	System.out.println("The index of smallest is : " +smallIndex);
	
	
	
	
	
	
	
	
	return -1;
	
	}
}
