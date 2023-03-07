import java.util.*;
public class Stats
{
	private static final int MAX_SIZE = 100;
	public static void main(String[] args)
	{
        	int[] List = new int[MAX_SIZE];		
		int numItems;
    int highlow;
 		int avg;
        	numItems = fillUp (List);

        	System.out.println("\n\10\7" + " The range of your " +
                                   numItems + " items is :  " + 
				   range (List, numItems));

        	System.out.println("\n\10\7" + " The mean of your " + 
                                   numItems + " items is  :  " +
				   mean (List, numItems));
	}
 public static int fillUp ( int[] List )
 {
 int pos = 0;
 Scanner input = new Scanner ( System.in );
 System.out.print("Input Your Desired Values ( Enter '0' to stop method ) " );
     while ( true )
     {
       List[pos] = input.nextInt();
       if ( List[pos] == 0 )
       {
         break;
       }
       pos++;
     }
   return pos;
 }
	public static int range ( int[] List, int numItems )
	 {
		int lowest = List[0];
		int highest = List[0];
	   for ( int i = 1; i < numItems; i++ )
       {
       if ( List[i] < lowest )
       lowest = List[i];
       if ( List [i] > highest )
       highest = List[i];
       }
		return (highest - lowest);
	 }
	public static double mean ( int[] List, int numItems )
	 {
   int sum = 0;
   for ( int i = 0; i < numItems ; i++ )
   
     sum = sum + List[i];
   
   return ( (double) (sum) / (double) (numItems) );
	 
	 }


}
