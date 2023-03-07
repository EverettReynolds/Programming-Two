import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class TimeShare // no Global Variables
{
  public static void main(String[]args) throws FileNotFoundException, CloneNotSupportedException
  {
    String fileName = args[0];
    Queue inQueue = new Queue();
    Queue jobQueue = new Queue();
    Queue printQueue = new Queue();
    inputFiles(fileName,inQueue);
    jobProcess(inQueue,jobQueue,printQueue);
  }
  
  public static void inputFiles(String fileName, Queue inQueue) throws FileNotFoundException //takes in job data from texts files and stores them in the input queue
  {
    try
    {
      File inFile = new File (fileName); // The importing of our text files
      Scanner input = new Scanner (inFile);
      while(input.hasNext())
      {
        String jobName = input.next();
        int arrivalTime = input.nextInt();
        int runTime = input.nextInt();
        
        inQueue.enqueue(new Job(jobName,arrivalTime,runTime));
      }
    
    }
    catch (IOException e)// This catch is required when using files
    {
      System.out.println(e.getMessage());
    }
  }
  
  public static void jobProcess(Queue inQueue, Queue jobQueue, Queue printQueue)throws FileNotFoundException, CloneNotSupportedException // carries out the job processing within the program
  {
    Job nextJob = new Job(); // may need to add another job for accurate variable recovery
    int clockTime = 1;
    double idleTime = 0;
    double useTime = 0;
    int jobCount = 0;
    double waitAvg = 0;
    DecimalFormat numFormat = new DecimalFormat("#.00");
    while(!jobQueue.isEmpty() || !inQueue.isEmpty()) // May need to switch to just not empty job Queue or and both
    {
      if(!inQueue.isEmpty())
      {
        nextJob = (Job)inQueue.front();
        if(nextJob.arrivalTime == clockTime)
        {
          inQueue.dequeue();
          jobQueue.enqueue(nextJob); // may need to change if not actually stored.
          jobCount++;
        }
      }
      
      if(!jobQueue.isEmpty())
      {
        nextJob = (Job)jobQueue.front();
        if(nextJob.startTime != -1 && nextJob.runTime == (clockTime - nextJob.startTime))   // Would need to check for removing first as two jobs cannot be done at the same time
        {
          nextJob.turnTime = (nextJob.runTime + nextJob.waitTime);
          jobQueue.dequeue();
          printQueue.enqueue(nextJob);
        }
      }
  
      if(!jobQueue.isEmpty())
      {
        nextJob = (Job)jobQueue.front();
        if(nextJob.arrivalTime <= clockTime && nextJob.startTime == -1 ) // These conditions work, they just work flawlessly
        {
          nextJob.startTime = clockTime;
          nextJob.waitTime = (nextJob.startTime - nextJob.arrivalTime);
          waitAvg = waitAvg + nextJob.waitTime;
        }
      }
      
      if(jobQueue.isEmpty() && !inQueue.isEmpty()) // checks whether there is dead time, or the CPU is being used
      {
        idleTime++;
      }
      else if(!jobQueue.isEmpty())
      {
        useTime++;
      }
      
      clockTime++;
    }
    printOutput(printQueue);  // This method calls to out printOutput method to both clone and print the data portion of our third and final Queue
    System.out.println();
    System.out.println();
    System.out.println("Average Wait Time => " + numFormat.format((waitAvg/jobCount))); // These lines are here so it is easier to print , rather than throwing many numbers into an array and going into out output method
    System.out.println("        CPU Usage => " + useTime);
    System.out.println("        CPU Idle  => " + idleTime);
    System.out.println("    CPU Usage (%) => " + numFormat.format( ( useTime /(useTime + idleTime))*100) + " %");
    System.out.println("-----------------------------------------------------");
    
  }
  
  
  
  
  
  
  public static void printOutput(Queue printQueue) throws FileNotFoundException, CloneNotSupportedException // prints the output report for the user to show the jobs stats from our completed process
  {
    System.out.println("Job Control Analysis: Summary Report");
    System.out.println("------------------------------------");
    System.out.println();
    System.out.println("job id arrival start   run     wait   turnaround");
    System.out.println("       time    time    time    time   time");
    System.out.println("------ ------- -----   ----    ----   ----------");
    if (printQueue.isEmpty())
   	{
 	    System.out.println("Your Queue is Currently Empty!");
 	    return;
   	}

      Queue   tempQ  = (Queue) printQueue.clone(); // the clone method is used to protect the integrity of our data 

      while (! tempQ.isEmpty())
     	{
    		System.out.println(tempQ.front());
    		tempQ.dequeue();
     	}
	} 

  


}

