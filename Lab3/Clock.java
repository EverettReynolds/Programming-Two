// Everett Reynolds
// 1-27-2020
import java.util.*;
public class Clock
{
final static int HOURS_IN_DAY = 25; // This Time includes 0, using the way Java counts numbers.
final static int MINUTES_IN_HOUR = 61;
final static int SECONDS_IN_MINUTE = 61;
private int hrs = 0;
private int mins =0 ;
private int secs= 0;
public Clock(int userHours, int userMinutes, int userSeconds)
{
this.hrs = userHours;
this.mins = userMinutes;
this.secs = userSeconds;
}
public Clock() 
{
this.hrs = 0;
this.mins = 0;
this.secs = 0;

}

public void reset()
{
hrs = 0;
mins = 0;
secs = 0;
}
public void reset(int userHours, int userMinutes, int userSeconds)
{
hrs = userHours;
mins = userMinutes;
secs = userSeconds;
}

public void advance() // If it doesn't work, try changing the variables 
{
while(hrs == 24 || mins == 60 || secs == 60)
{
if(hrs == 24)
hrs = 0;
if(mins == 60)
mins = 0;
if(secs == 60)
secs = 0;
}
secs++;
}

public String toString()
{
return "The time is now "  + hrs + ":" + mins + ":" + secs;
/*String form = "";
form = "The time is now " + hrs + ":" + mins + ":" + secs;
return form;
//return String.format("The time is now " + hrs + ":" + mins + ":" + secs);
*/
}


}
