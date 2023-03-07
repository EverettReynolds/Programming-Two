 import java.util.*;

import java.io.*;

public class Practice   

{

  public static void main(String[] args) throws IOException, CloneNotSupportedException

  {

        Queue myQ = new Queue();   // Create a Queue object

        Job myJob = new Job("job1", 1, 3);  // Create a Job object

        myQ.enqueue (myJob);  // Add a Job object to the front of the queue

        Queue copyQ = (Queue) myQ.clone();   // Clone the queue for printing

 

        while (! copyQ.isEmpty()) // Print the queue

        {

                Job outputJob = (Job) copyQ.front();   // Pull off front job

                System.out.println("\t" + outputJob);  // Print the job using the toString in the Job class

                copyQ.dequeue();  // Remove the front job

        }

   }

}