//Everett Reynolds
import java.util.*;
import java.io.*;

public class LibraryCatalog
{

  public static void main(String[] args)throws FileNotFoundException // The Main is the facilitator of the methods within the java program
  {
  ArrayList <LibraryBook> bookList = new ArrayList <LibraryBook>(50);
  clearScreen();
  startMenu(bookList);
  clearScreen();
  catalogMenu(bookList);
  
  }
  
  public static int inputBookRecords(String inputFileName, ArrayList <LibraryBook> bookList) throws FileNotFoundException // This method goes to the file, accesses it's information, inputs all of the book records into our program
  {
    int bookNum = 0;
    
    try
    {
      File inFile = new File (inputFileName);
      Scanner input = new Scanner (inFile);
      while(input.hasNext())
      {
        Scanner delim = new Scanner(input.nextLine()).useDelimiter(";");
        
        String title = delim.next();
        String name = delim.next();
        int copyright = delim.nextInt();
        double price = delim.nextDouble();
        String genre = delim.next();
        
        bookList.add( new LibraryBook(title,name,copyright,price,genre));
        bookNum++;
        
      }
    }
    catch (IOException e)// This catch is required when using files
    {
      System.out.println(e.getMessage());
    }
    return bookNum;
  
  }
  
  public static void printRecord(ArrayList<LibraryBook> bookList, int location ) // This method prints out the LibraryBook's as records with related information
  {
    System.out.println("Record #" + (location + 1) + " : \n");
    System.out.println("Title:          " + bookList.get(location).getTitle());
    System.out.println("Author's Name:  " + bookList.get(location).getAuthor());
    System.out.println("Copyright:      " + bookList.get(location).getCopyright());
    System.out.println("Price:          " + bookList.get(location).getPrice());
    System.out.println("Genre:          " + bookList.get(location).getGenre() + "\n");
    
  }
  
  private static void clearScreen()// This method acts like the linux command clear()
  {
    System.out.println("\u001b[H\u001b[2J");
  }
  
  public static void linuxLs()// This method acts like the linux command ls
  {
    File curDir = new File(".");
    String[] fileNames = curDir.list();
    ArrayList<String> data = new ArrayList<String>();
    for(String s:fileNames)
    {
      if(s.endsWith(".dat"))
      {
        data.add(s);
      }
    }
    System.out.println(data);
        
  }
  public static void bookSort(ArrayList <LibraryBook> bookList)// This method sorts books from our ArrayList into alphabetical order for further processes such as searching
  {
    int minIndex;
    int index;
    int x;
    LibraryBook temp;
    int pass = 0;
    
    for( index = 0; index < bookList.size()-1; index++)
    {
      minIndex = index;
      for( x = minIndex+1; x < bookList.size(); x++)
      {
        if(bookList.get(x).compareTo(bookList.get(minIndex)) < 0)
        {
          minIndex = x;
        }
      }
      if ( minIndex != index )
      {
        temp = bookList.get(index);
        bookList.set(index,bookList.get(minIndex)) ;
        bookList.set(minIndex, temp);
      }
    }
  }
  
  public static void startMenu(ArrayList <LibraryBook> bookList)throws FileNotFoundException //This Method is the first portion of the program which locates the file that we procure data from.
  {
    Scanner userIn = new Scanner( System.in );
    String inputFileName = "" ;
    System.out.println("What File Would You Like to Sort?");
    linuxLs();
    inputFileName = userIn.nextLine();
    while(!inputFileName.equals("library.dat"))
    {
      System.out.println("File was not found in the directory. Please input a correct file.");
      System.out.println("What File Would You Like to Sort?");
      inputFileName = userIn.nextLine();
      linuxLs();
    }
    int bookNum = inputBookRecords(inputFileName,bookList);
    bookSort(bookList);
    
    System.out.println("A total of " + bookNum + " books have been input & sorted by title.");
    System.out.println("\n Please Hit Return to Continue.");
    System.out.println(" ");
    Scanner tempScan = new Scanner (System.in);
    tempScan.nextLine();    
  }
  
  public static void catalogMenu(ArrayList<LibraryBook>bookList)//This Method is the main faciliator of the entire library catalog program. Through it, you will have user choices which lead to other options and methods.
  {
    try
    {
      int userChoice = 0;
      Scanner userInput = new Scanner ( System.in );
      System.out.println("------------------------------------------------------------------------------------");
      System.out.println("                      The Library Catalog Program                                   ");
      System.out.println("------------------------------------------------------------------------------------");
      System.out.println("1. Display All Book Records.");
      System.out.println("2. Search for A Book By Title");
      System.out.println("3. Exit The Catalog Program");
      System.out.println("------------------------------------------------------------------------------------");
      System.out.println("");
      System.out.println("Please Enter Your Choice");
      userChoice = userInput.nextInt();
      while(userChoice<0 || userChoice >3 )
      {
      	System.out.println("You have Entered an invalid choice. Please enter a valid choice.");
	System.out.println("Please Enter Your Choice");
        userChoice = userInput.nextInt();
      }
        switch(userChoice)
        {
          case 1:
            displayBooks(bookList);
            break;
          case 2:
            searchBooks(bookList);
            break;
          case 3:
            System.out.println(" Have A Pleasant Day and Thank You for Using The Library Catalog :D " );
	    System.out.println("\n Please Hit Return to Exit");
            System.out.println(" ");
            Scanner tempScan = new Scanner (System.in);
            tempScan.nextLine();
            break;
        }
       System.exit(0);	
      }	
	 
    catch(InputMismatchException e)// This catch is vital as your program will crash if users put anything but numbers when going through a switch statement
    {
    	System.out.println("You have Entered an Invalid Choice and Caused an Error");
      System.out.println("\n Please Hit Return to See Next Record.");
      System.out.println(" ");
      Scanner tempScan = new Scanner (System.in);
      tempScan.nextLine();
      clearScreen();
      catalogMenu(bookList);
    }
  }
  public static void displayBooks(ArrayList<LibraryBook> bookList)//This method's purpose is to display the entirity of data within a file that we have identified within the start of our program
  {
    clearScreen();	
    for(int i = 0; i < bookList.size(); i++)
    {
      printRecord(bookList, i );
      System.out.println("\n Please Hit Return to Continue.");
      System.out.println(" ");
      Scanner tempScan = new Scanner (System.in);
      String out =  tempScan.nextLine();
      clearScreen();	
      if(out.toLowerCase().equals("m"))
      {
      	break;
      }	   		  			
    }
    catalogMenu(bookList);	
  }
  public static void searchBooks(ArrayList<LibraryBook>bookList)// This method's purpose is to search through our ArrayList of book titles in order to find if the book is within the list, and where in that list it is, if present.
  {
  	String key;
        int position;
        Scanner titleScan = new Scanner (System.in);
	System.out.println("What Title Would You Like to Search for?");
        key = titleScan.nextLine();
        position = binarySearch(bookList,key);
        if(position >= 0)
        {
        clearScreen();
	System.out.println("This book was found in the list");
	printRecord(bookList,position);
	System.out.println("\n Please Hit Return to Continue.");
        System.out.println(" ");
        Scanner tempScan = new Scanner (System.in);
        tempScan.nextLine();
	clearScreen();
	catalogMenu(bookList);
	}
	else
	System.out.println("Your book was not found in the list.");
	System.out.println("\n Please Hit Return to Continue.");
        System.out.println(" ");
        Scanner tempScan = new Scanner (System.in);
        tempScan.nextLine();
	clearScreen();
	catalogMenu(bookList);
	
  }
  public static int binarySearch(ArrayList<LibraryBook>bookList, String key)// This method's main purpose is pass back an int to our search method to find the actual result of whether a book is present in an ArrayList
  {
  boolean found = false;
  int first = 0; 
  int last = bookList.size()-1;
  int middle;
  int location;
  do
  {
    middle = (first + last) / 2;
    if( key.toLowerCase().compareTo(bookList.get(middle).getTitle().toLowerCase()) == 0)
    
      found = true;
    
    if(key.toLowerCase().compareTo(bookList.get(middle).getTitle().toLowerCase()) < 0)
    
      last = middle - 1;
    
    else
      first = middle + 1;
   } while ( (!found) && (first <= last));
   
   location = middle;
   
   return (found ? location: -1);
    
    
  }
  
  
  
}    

