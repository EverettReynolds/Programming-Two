public class Puzzle
{
  public static void main(String[]args)
  {
    int[] a = {-3,-4,-2,-5,-4,-2,-3,-3,-2,-2};
    System.out.println(puzzle(23));
    System.out.println(mySum(2));
    System.out.println(mystery(-3,1,a));
  }
  private static int puzzle(int n)
  {
    if( (n%3) == 1)
    {
      return 1;
    }
    else if ( (n%3) == 2 )
    {
      return( puzzle(n+1) + 2);
    }
    else
    {
      return( puzzle(n/3) + 1);
    }
  }
  public static int mySum(int n)
  {
    if(n == 0)
    {
      return 0;
    }
    else
    {
      return((n*n*n)+1+mySum(n-1));
    }
  }
  private static int mystery(int n, int start, int[]a)
  {
    if(start>= a.length)
    {
      return -1;
    }
    else if( a[start] == n)
    {
      return start;
    }
    else
    {
      return mystery(n,start+1,a);
    }
  }
  
}