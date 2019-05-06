/* public int printLIS(int[] nums) 
	{
		String[] paths = new String[nums.length];
		int[] sizes = new int[nums.length];
		
		for (int i = 0; i < nums.length; i++)
		{
			sizes[i] = 1;
			paths[i] = nums[i] + " "; // We add a space for seperation
		}
		
		int maxLength = 1;
		
		for (int i = 0; i < nums.length; i++)
		{
			for (int j = 0; j < i; j++)
			{
				if (nums[i] > nums[j] && sizes[i] < sizes[j] + 1)
				{
					sizes[i] = sizes[j]+1;
					paths[i] = paths[j] + nums[i] + " ";
					
					if (maxLength < sizes[i])
					{
						maxLength = sizes[i];
					}
				}
			}
		}
		
		for (int i = 0; i < nums.length; i++)
		{
			if (sizes[i] == maxLength)
			{
				System.out.println("LIS: " +paths[i]);
			}
		}
	}
        
public static void main(String[] args)
{
		
}
			
        		
        		
}*/





    /*int[]L = new int[d.length];
    L[0] = 1;
    for (int i = 1;i < L.length; i++)
    {
    	    int maxn = 0;
    	    for(int j = 0; j < i; j++)
    	    {
    	    	    if(seq[j] < seq[i] && L[j] > maxn)
    	    	    {
    	    	    	    maxn = L[j];
    	    	    }
    	    }
    
      L[i] = maxn + 1;
    }
    
    int maxi = 0;
    for (int i = 0; i < L.length; i++)
    {
    	    if(L[i] > maxi)
    	    {
    	    	    maxi = L[i];
    	    }
    }
    
    return(maxi); 
    
    
    
    
    
    
    
    
               // To sort the height from shortest to tallest
           int tmp, tmp2;
           for (int i = 0; i < height.length; i++)
           {
           	   for(int j = 0; j < (height.length - 1); j++)
             	   {
             	   	   if (height[j-1] > height[j])
             	     	   {
             	     	   	   tmp = height[j-1];
             	     	    	   height[j-1] = height[j];
             	     	    	   height[j] = tmp;
             	     	    	   
             	     	    	   tmp2 = IQ[j-1];
             	     	    	   IQ[j-1] = IQ[j];
             	     	    	   IQ[j] = tmp2;
             	     	   }
             	   }
             	   
           System.out.println("The height is : " +height[i]);
           System.out.println("The IQ is : " +IQ[i]);
           }
                
    */

