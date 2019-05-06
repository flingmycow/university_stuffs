				/* Project: 
 * 		Longest Increasing Sub-sequence (LIS)
 * 		Given an array, finds its longest increasing
 * 		subsequence using dynamic programming
 * 		Complexity: O(n^2)
 * 
 */ 
public class LCS {
	
	 
	 private static int SubsequenceLength(int[] array_sequence)
 {
 int int_sequence_length = array_sequence.length;//get number of integers in set
 int[] array_best = new int[int_sequence_length];//create a copy of the set array
 
 //initialize
 array_best[0] = 1;//base case
 int int_max = 0;
 int int_max_index = 0;
//build the array containing the length of the LIS.
 	//keep track of the longest LIS with int_max / int_max_index.
 for (int i = 0; i < int_sequence_length; i++){
	 
	 for (int j = 0; j < i; j++){
	 if( (array_sequence[i] > array_sequence[j] && (array_best[i] < array_best[j] + 1) ))
	 {	 	
		array_best[i] =array_best[j] + 1;
	
	 }//end j
	 if (array_best[i] > int_max)
	 {
	 	 int_max = array_best[i];
	 	 int_max_index = i;
 } //end i
 	
 
 int k = int_max+1;
 int[] lis = new int[k ];
 
 for(int i = int_max_index; i >0; i--)
 {
	 if (array_best[i] == k-1)
	 {
	 	 lis[k-1] = (array_sequence[i]);
	 	 k = array_best[i];
				 
	 }
 }
 
 //print the LIS 
 System.out.print("[");
 for (int i = 0; i < lis.length; i++) {
 System.out.print( lis[i] +" ");
 }
 System.out.println("]");
 return int_max + 1; //return length of LIS
 } //end method
public static void testProgram(){
		int[ ] Seq1 = {9,5,2,8,7,3,1,6,4};
		int[ ] Seq2= {11, 17, 5, 8, 6, 4, 7, 12, 3};
		
		System.out.println("length - " + SubsequenceLength(Seq1));
		System.out.println("length - " + SubsequenceLength(Seq2));
		
}
	 public static void main(String[] args)
	 {
	
		testProgram();
	 }//end main
	 
}//end class









public static int increasingSubsequence(int[]seq)
{
    int[]L = new int[seq.length];
    L[0] = 1;
    
    for (int i = 1; i < L.length; i++)
    {
      int maxn=0;
      
      for(int j = 0; j < i; j++)
      {
        if(seq[j] < seq[i] && L[j] > maxn)
        {
          maxn=L[j];
        }
      }
      
      L[i]=maxn+1;
    }
    int maxi=0;
    
    for(int i = 0;i < L.length; i++)
    {
      if(L[i] > maxi)
      {
        maxi = L[i];
      }
    }
    return(maxi);
  }
