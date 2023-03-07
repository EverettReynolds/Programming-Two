
import java.io.*;
@SuppressWarnings("unchecked")

public class MaxTest 
{
   public static void main(String[] args) throws IOException, CloneNotSupportedException
   {
        	Stack stack1 = new Stack();
		stack1.push("Andy");
		stack1.push("Allison");
		stack1.push("Aaron");
		stack1.push("Austin");
		stack1.push("Abbey");
		stack1.push("Alex");
        	System.out.println("findMax(stack1)="+findMax(stack1)); 
        	System.out.println("stack1.findMax()="+stack1.findMax()); 
  }
   private static String findMax(Stack stack1) throws CloneNotSupportedException
  {
    Stack tempStack = (Stack)stack1.clone();
    String concurMax = "AAAAA";
    
    while(!tempStack.isEmpty())
    {
    if(( (String) tempStack.top()).compareTo(concurMax) > 0 )
    {
      concurMax = (String)tempStack.top();
      
    }
    tempStack.pop();
    }
    return concurMax;
  } 


}