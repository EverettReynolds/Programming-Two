
public class Links
{
  static int number = 0;
	public static void main(String[] args)
	{
          	Node pos1 = null;
    		Node pos2 = null;
    		pos1 = new Node(new Integer(13));
   		pos1.setNext(new Node(new Integer(15), null));
    		pos2 = new Node(new Integer(11), null);
		pos2.setNext(pos1);
		printList(pos2);
    count(pos2);
    findMax(pos2);
	}

	private static void printList(Node head)
	{
		if (head != null)
		{
			System.out.println(head.getItem());
			printList(head.getNext());
		}
	}
 
 public static void count(Node head)
 {
   if ( head != null)
   {
     number++;
     head = head.getNext();
     count(head);  
   }
   else
   {
   System.out.println(number-1);
   }
 }
 private static int findMax(Node head)
 {
   int currentMax = -1;
   while(head != null)
   {
     int newVal = ((Integer) head.getItem()).intValue();
     if(newVal > currentMax)
     {
       currentMax = newVal;
     }
     head = head.getNext();
   }
   System.out.println(currentMax);
   return currentMax;  
 }
}
