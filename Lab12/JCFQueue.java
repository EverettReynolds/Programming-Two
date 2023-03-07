
import java.util.*;

@SuppressWarnings("unchecked")
public class JCFQueue
{
	public static void main(String[] args) throws CloneNotSupportedException
	{
		LinkedList queue1 = new LinkedList();
		LinkedList queue2 = new LinkedList();
		Object key = new Character('$');

        	queue1.addLast(new Character('b'));
        	queue1.addLast(new Character('$'));
        	queue1.addLast(new Character('E'));
        	queue1.addLast(new Character('$'));
        	queue2.addLast(new Character('b'));
        	queue2.addLast(new Character('$'));
        	queue2.addLast(new Character('E'));
        	queue2.addLast(new Character('b'));
		System.out.println("dup check = " +
                    identicalCheck(queue1, queue2));
		findAndReplace(queue1, key, new Character('*'));
		System.out.println("** After findAndReplace **");
		printQueue(queue1);
	}

	private static boolean identicalCheck(LinkedList queue1,
                                              LinkedList queue2)
                throws CloneNotSupportedException
	{

    LinkedList temp1 = (LinkedList)(queue1.clone());
    LinkedList temp2 = (LinkedList)(queue2.clone());
    if(temp1.size()!=temp2.size())
    {
      return false;
    }
    else
    {
      while(!temp1.isEmpty())
      {
        if(!temp1.element().equals(temp2.element()))
        {
          return false;
        }
        else
        {
          temp1.pop();
          temp2.pop();
        }
      }
      return true;
    }



	}


	private static void findAndReplace(LinkedList queue1, 
		Object key, Object newVal)
	{
    int size = queue1.size();
    for(int i = 0; i< size ; i++)
    {
      if(queue1.get(i).equals(key))
      {
        queue1.set(i,newVal);
      }
    }


	}



	private static void printQueue (LinkedList q)
		 throws CloneNotSupportedException
	{
    if(q.isEmpty())
    {
      System.out.println("Your Queue is currently empty!");
      return;
    }
    
    LinkedList tempList = (LinkedList)(q.clone());
    
    while(!tempList.isEmpty())
    {
      System.out.println(tempList.element());
      tempList.pop();
    }  


	}


}
