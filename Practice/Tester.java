/*public class Tester
{
  public static void main(String[] args)
  {
    T2 myT2 = new T2();
    //System.out.println(myT2);
  }
  
}

class T1 
{
  private int a = 2;
  protected int b = 3;
  int c = 4;
  
  T1()
  {
    System.out.println("T1");
  }
}

class T2 extends T1
{
  T2()
  {
    //super();
    System.out.println("T2");
    T2.T3 inner = new T2.T3();
  }
  static class T3
  {
    T3()
    {
      System.out.println("T3");
    }
  }
}
 */
 
 
  class Fruit
  {
    public void print()
    {
      System.out.println("I'm a Fruit");
    }
  }
  
  class Berry extends Fruit
  {
    public void print()
    {
      System.out.println("I'm a Berry");
    }
    public void printTwo()
    {
      super.print();
    }
  }
  
  class Strawberry extends Berry
  {
    public void print()
    {
      System.out.println("I'm a Strawberry");
    }
  }
  
  public class Tester
  {
    public static void main( String[] args )
    {
      Fruit a = new Fruit();
      a.print();
      Fruit b = new Fruit();
      b.print();
      Strawberry c = new Strawberry();
      b = c;
      b.print();
      if ( b instanceof Berry )
      {
        Berry d = (Berry) b;
        d.printTwo();
      }
    }
  }
  

 