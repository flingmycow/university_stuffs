public class Test {
	/**
	 * Method will return the length of a longest sequence of
         * people such that the heights are strictly increasing, but
         * the IQs are strictly decreasing.   
	 * 
	 * @param d 
	 *        An array of an even number of integers.  They
         *        are given as pairs in the order 
         *        height_1, IQ_1, height_2, IQ_2, etc.      
         *            
	 * 
	 * @return The length of a longest sequence of people,
         *         such that the heights are strictly increasing,
         *         but the IQs are strictly decreasing.   
	 */
	@DataTest(test = 1, input = { "dataset" })
	public int  notSoSmart(int[] d) {

             // First initalize the two arrays that the input will go in
             int[] height = new int[d.length/2];
             int[] IQ = new int[d.length/2]; 

             // Now sort all the values into the two seperate arrays
             for (int i = 0; i < d.length; i = i + 2)
                 {    
                      height[i/2] = d[i];
                      IQ[i/2] = d[i+1]; 
                 }
                 
             // Testing to ensure that the values are correctly sorted in their respective arrays
            /* System.out.println("This is the original list");
             for (int j = 0; j < height.length; j++)
             {
                      System.out.println(j+ "). Height : " +height[j]);
                      System.out.println(j+"). IQ : " +IQ[j]+ "\n");
             }*/
             
           // To sort the height from shortest to tallest
           int tmp, tmp2;
           for (int i = 0; i < height.length; i++)
           {
           	   for(int j = 1; j <= (height.length - 1); j++)
             	   {
             	   	   if (height[j-1] > height[j])
             	     	   {
             	     	   	   tmp = height[j-1];
             	     	    	   height[j-1] = height[j];
             	     	    	   height[j] = tmp;
             	     	    	   
             	     	    	   // To also sort the IQ so the position corresponds with height
             	     	    	   tmp2 = IQ[j-1];
             	     	    	   IQ[j-1] = IQ[j];
             	     	    	   IQ[j] = tmp2;
             	     	   }
             	   }
           }
         
           // Testing to see if the list now has the HEIGHTS increasing order. IQ still mismatched.
           /*System.out.println("This is the modified list");
           for (int j = 0; j < height.length; j++)
           {
           	   System.out.println(j+ "). Height : " +height[j]);
           	   System.out.println(j+"). IQ : " +IQ[j]+ "\n");
           }*/
           
           int[] list = new int[IQ.length]; // Create a list array of the same size as IQ
           list[0] = 1; // Base Case
           int maxNum = 0; // Largest sequence size/length
           
           // Loop through from 1 to length of LIST
           for (int i = 1; i < list.length; i++)
           {
           	   maxNum = 0;
           	   
           	   for(int j = 0; j < i; j++)
           	   {
           	   	   if (IQ[j] < IQ[i] && list[j] > maxNum)
           	   	   {
           	   	   	   maxNum = list[j];
           	   	   }
           	   }
           	   
           	   list[i] = maxNum + 1;
           }
           	   
          for (int i = 0; i < list.length; i++)
          {
          	  if (list[i] > maxNum)
           	  {
           	  	  maxNum = list[i];
           	  }
          }
           
           return maxNum;
        }
}

/*

           // Create a copy of the array
           int[] copy = new int[height.length];
           copy[0] = 1; // Base Case
           int maximum = 0;
           int maximum_index = 0;
           
           // Build the array containing the length of the list corresponding to req's.
           // Keep track of the longest LIS with maxmimum and maximum_index.
           
           for (int i = 0; i < IQ.length; i++)
           {
           	   for (int n = 0; n < i; n++)
           	   {
           	   	   if (IQ[i] > IQ [n] && (copy[i] < copy[n] + 1) )
           	   	   {
           	   	   	   copy[i] = copy[n] + 1;
           	   	   }
           	   	   
           	   	   if (copy[i] > maximum)
           	   	   {
           	   	   	   maximum = copy[i];
           	   	   	   maximum_index = i;
           	   	   }
           
           	   	   int f = maximum + 1;
           	   	   int [] finished = new int[f];
           
           	   	   for (int k = maximum_index; k > 0; k--)
           	   	   {
           	   	   	   if (copy[k] == f-1)
           	   	   	   {
           	   	   	   	   finished[f-1] = (IQ[k]);
           	   	   	   	   f = copy[k];
           	   		   }
           	   	   }
           	   }
           }

*/
