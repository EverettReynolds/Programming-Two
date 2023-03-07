
import java.util.*;
import java.io.*;
public class Pez 
{
   public static void main(String[] args) throws IOException, CloneNotSupportedException
   {
     Stack dispenser = new Stack();
     addPez(dispenser);
     printStack(dispenser);
     removeGreen(dispenser);
     System.out.println("");
     printStack(dispenser);
   
   }
   
   public static void addPez(Stack dispenser)
   {
     dispenser.push("yellow");
     dispenser.push("red");
     dispenser.push("green");
     dispenser.push("green");
     dispenser.push("yellow");
     dispenser.push("yellow");
     dispenser.push("red");
     dispenser.push("green");
   
   }
   public static void removeGreen(Stack dispenser)
   {
     Stack tempStack = new Stack();
     
     while(!dispenser.isEmpty())
     {
       if(!((String)dispenser.top()).equals("green"))
       {
        tempStack.push(dispenser.top());
       }
       dispenser.pop();
     }
     while(!tempStack.isEmpty())
     {
       dispenser.push(tempStack.top());
       tempStack.pop();
     }
   }
   public static void printStack(Stack dispenser) throws CloneNotSupportedException
   {
     Stack tempStack = (Stack) (dispenser.clone());
     while (! tempStack.isEmpty())  
     {
      System.out.println(tempStack.top());
      tempStack.pop();
     }

   }
   
}