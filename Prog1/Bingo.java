//Everett Reynolds
//02-02-20
import java.util.*;
import java.io.*;

public class Bingo {
final static int ROWS = 5; // A bingo card is 5x5 therefore the row and column numbers will be 5 by 5
final static int COLS = 5;
public static final int HORIZONTAL = 1; // Constants set up to ensure proper Bingo Win Function
public static final int VERTICAL = 2;
public static final int DIAGONAL = 3;
public static ArrayList <Integer> bingoBank = new ArrayList <Integer>(25);
public static BitSet bingoNums = new BitSet(76);
	public static void main(String[] args) throws IOException // filled with method calls for the facilitating the entire program
  {
   int[][] bingoCard = new int[ROWS][COLS];
  
   fillCard(bingoCard);
   playGame(bingoCard);
  }

public static void fillCard(int[][] bingoCard ) throws IOException // fills up our bingo card with number from an outside file "bingo.in"
{
  File inFile = new File ("bingo.in");
  Scanner input = new Scanner(inFile);
  int tempInt = 0 ;
  int rowTemp = 0 ;
  for(int i = 0; i< bingoCard.length;i++)
  {  
    for(int j = 0; j < bingoCard[0].length; j++)
    {
      tempInt = input.nextInt();
        bingoCard[i][j] = tempInt;
    }
  
  }
  
}

public static void printCard ( int[][]bingoCard ) // Prints out our Bingo Card 
{
  for( int i = 0; i < bingoCard.length; i++ )
  {
    for ( int j = 0; j < bingoCard[0].length; j++)
    {
      System.out.print("|" +  bingoCard[i][j] + "|" + "\t" );
    }
    System.out.println();
  }
}

public static int randomNumGen() // Generates a random number simulating a bingo ball machine, not reusing the same number
{
  int bingoBall = 0;
  do // the do method ensures a number is generated before a condition is checked
  {
    bingoBall = (int) Math.round((Math.random() * 74 + 1));
  } while ( bingoNums.get(bingoBall) == true );
  bingoBank.add(bingoBall);
  bingoNums.set(bingoBall);
  return bingoBall;
  
}

public static void playGame ( int[][]bingoCard ) // The actual game method which facilitates proper gameplay
{
  int counter = 0;
  printCard(bingoCard);
  int winNumber = 0;
  while( checkForWin(bingoCard) == 0 ) // looks for checkForWin to return one of our constant global variables mentioned above
  {
    counter++;
    crossOff(bingoCard);
    winNumber = checkForWin(bingoCard);
  }
  if ( winNumber == 1)
  {
    System.out.println("You Win With A Horizontal Bingo After " + counter + " Picks!");
  }
  if ( winNumber == 2)
  {
    System.out.println("You Win With A Vertical Bingo After " + counter + " Picks!");
  }
  if ( winNumber == 3)
  {
    System.out.println("You Win With A Diagonal Bingo After " + counter + " Picks!");
  }
  reprintCard(bingoCard);
  
}

public static void crossOff ( int[][]bingoCard) // helps to figure out the zero sum for check for win
{
  int ball = randomNumGen();
  for(int i = 0; i < bingoCard.length; i++)
  {
    for( int j = 0 ; j < bingoCard[0].length; j++ )
    {
      if ( bingoCard[i][j] == ball )
      {
      bingoCard[i][j] = 0;
      }
    }
  }
}

public static int checkForWin ( int[][]bingoCard ) // uses sum addition methods to check for a horizontal, vertical, or diagonal win IE add all rows, add all columns, add both diagonals
{
      int rowCrossed = 0;
      int sum = 0;
      for (int i = 0; i < ROWS; i++ ) // Row Sum Finder
      {
        sum = 0;
        for(int j = 0; j < COLS; j++)
        
        sum+=bingoCard[i][j];
        
        if(sum == 0)
           return HORIZONTAL;
      }

        
                
       for ( int j = 0; j < COLS; j++ ) // Column Sum Finder
      {
       sum = 0;
       for ( int i = 0; i < ROWS; i++ )
         sum+=bingoCard[i][j];
         if(sum == 0)
           return VERTICAL;
      }  
       
      

     sum = 0; 
     for ( int i = 0; i < ROWS; i++ ) // Left Diagonal Sum Finder
     {
       sum+=bingoCard[i][i];
         
     }
     if(sum == 0)
           return DIAGONAL;
           
     sum = 0;
     for ( int i = 0; i < ROWS; i++ ) // Right Diagonal Sum Finder
     {
       sum+=bingoCard[i][ROWS-i-1];
     } 
     if(sum == 0)
         return DIAGONAL;
   return rowCrossed;   
}

public static void reprintCard (int[][]bingoCard ) // a method to reprint our bingo card after the zero sums are found
{
  for(int i = 0; i < bingoBank.size(); i++)
  {
    System.out.println(bingoBank.get(i));
    if(i%9 == 0 )
    {
      System.out.println(" ");
    }
  }
  for( int i = 0; i < bingoCard.length; i++ )
  {
    for ( int j = 0; j < bingoCard[0].length; j++)
    {
      if(bingoCard[i][j] == 0 )
      {
        System.out.print("|" +  "X" + "|" + "\t" );
      }
      else
      {
        System.out.print("|" +  bingoCard[i][j] + "|" + "\t" );
      }
    }
    System.out.println();
  }
    
}

}

