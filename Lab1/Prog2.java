// This program will read a string and give it's length
// Written By Everett Reynolds
import java.util.*;
class Prog2
{

	public static void main ( String[] args )
	{
		String data;
		
		System.out.print("Enter a String: ");
		Scanner stdin = new Scanner ( System.in );
		data = stdin.nextLine();

		System.out.println("The String has " + data.length() + " characters. " );
	}
}
