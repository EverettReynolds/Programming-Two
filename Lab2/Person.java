import java.util.*;
public class Person
{
  private String name;
  private int    id;
  private static int personCount = 0;

  // constructor
  public Person(String pname)
  {
    name = pname;
    personCount++;
    id = 100 + personCount;
  }
  public Person()
  {
  this.name = "N/A" ; 
  this.id = -1 ;
  personCount++;
  
  }
 public void reset(String name, int id)
 {
   this.name = "";
   this.id = 0;
   this.name = name;
   this.id = id;
 }
 public String getName()
 {
 System.out.println("This Person's name is " + name );
  return name;
 }
 
 public int getId()
 {
 System.out.println("This Person's ID is " + id );
  return id;
 }
 
  public String  toString()
  {
    return "name: " + name + "  id: " + id 
      + "  (Person count: " + personCount + ")";
  }

  // static/class method
  public static int getCount()
  {
    return personCount;
  }
  
}
