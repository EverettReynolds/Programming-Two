// Everett Reynolds
// 02-02-2020
import java.util.*;
public class TestClock
{
public static void main(String args[])
{
 int userSeconds;
 int userMinutes;
 int userHours;
Clock dvr = new Clock();
Scanner input = new Scanner ( System.in );
System.out.println("Please Enter Your Number of Hours.");
userHours = input.nextInt();
System.out.println("Please Enter Your Number of Minutes.");
userMinutes = input.nextInt();
System.out.println("Please Enter Your Number of Seconds.");
userSeconds = input.nextInt();
dvr.reset(userHours, userMinutes, userSeconds);
dvr.toString();
dvr.advance();  
dvr.toString();
}



}