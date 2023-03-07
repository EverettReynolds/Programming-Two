import java.util.*;
public class mySums
{
   public static double iUserNum = 0.0;
   public static double rUserNum = 0; 
  
  public static void main(String[] args)
  {
    iUserNum = iterativeSum(4);
    rUserNum = recurSum(4);
    System.out.println(iUserNum);
    System.out.println(rUserNum);
  }
  
  public static double iterativeSum(int k)
  {
    double sum = 0;
    double total = 0;
    
    while( k >= 1 )
    {
      sum = Math.pow(2,k) + 1;
      total = total + sum;
      k--;
    }
    
    return total;
  }
  
  public static double recurSum(int k)
  {
    if(k == 0)
    {
      return 0;
    }
    else
    {
      return( Math.pow(2,k) + 1 + recurSum(k-1) );
    }
    
  }
  
}