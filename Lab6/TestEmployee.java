
import java.util.*;

public class TestEmployee
{
  public static void main(String[] args)
	{
    Date hireDate = new Date();
    Date birthDate = new Date(1980, 3, 8);
    Employee hired = new Employee("Brown","Morris", birthDate, 40000,hireDate);
    System.out.println(hired);
  }
}  