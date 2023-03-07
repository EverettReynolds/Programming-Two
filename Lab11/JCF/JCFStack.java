import java.util.*;
@SuppressWarnings("unchecked")
public class JCFStack
{
   public static void main(String[] args) throws CloneNotSupportedException
   {
        	Stack stack1 = new Stack();
          Scanner input = new Scanner(System.in);
		stack1.push(new Integer(27));
		stack1.push(new Integer(0));
		stack1.push(new Integer(-3));
		stack1.push(new Integer(-18));
		stack1.push(new Integer(99));
        	printStack (stack1); 
    System.out.println("What Value Would You Like to Search For?");
    int value = input.nextInt();
    int result = stack1.search(value);
    System.out.println("The Value is Located at Position "+ result);

  }

  private static void printStack (Stack s) throws CloneNotSupportedException
  {
        Stack tempStack = (Stack) (s.clone());
        if (! tempStack.isEmpty())
                System.out.println("*** Printing Out Stack:  ");

        while (! tempStack.isEmpty())
        {
               System.out.println(tempStack.peek());
               tempStack.pop();
        }
  }
}