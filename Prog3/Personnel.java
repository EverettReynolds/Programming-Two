//Everett Reynolds
import java.util.*;
import java.io.*;
@SuppressWarnings("unchecked")
public class Personnel implements Serializable // This is the actual client file within that uses Employee and it's offspring classes
{
  public static void main (String[] args ) // The Main Facilitator of Methods
  {
    ArrayList<Employee> database = new ArrayList<Employee>();
    personMenu(database);
  }
  
  public static void personMenu(ArrayList<Employee> database) // Characters n,c,r,p,d,u,q in play, q = quit and leave. Switch statement that looks for characters encapsulated by a while loop that looks for a count to incremented in q
  {
    Scanner input = new Scanner(System.in);
    Scanner user = new Scanner(System.in);
    
   String choice; // switched from char to reduce hassle of incorrect choices
    do // runs the above output once before checking to see if user wants out of this program
    {
      optionMenu();
      System.out.println("Enter a Command: ");
      choice = input.next().toLowerCase();
      switch(choice)
      {
        case "n":
            newEmployee(database);
            break;
        
        case "c":
            for(int i = 0; i < database.size(); i++)
            {
              System.out.println("Enter numbers of hours worked by " + database.get(i).getEmployeeName());
              int hours = user.nextInt();
              System.out.println("Pay:" + Utilities.toDollars(database.get(i).computePay(hours)));
            }
            break;
        
        case "r":
            System.out.println("Enter the Percent of Wage Increase");
            double percent = user.nextDouble();
            System.out.println("New Wages");
            System.out.println("---------");
            for(int i = 0; i < database.size(); i++)
            {
              if(database.get(i) instanceof HourlyEmployee)
              {
                System.out.println(database.get(i).getEmployeeName()+Utilities.pad("",40)+"$"+Utilities.toDollars(database.get(i).raiseWage(percent))+ "/hour");
              }
              else
              {
                System.out.println(database.get(i).getEmployeeName()+Utilities.pad("",40)+"$"+Utilities.toDollars(database.get(i).raiseWage(percent)*(40*52))+ "/year");
              }
            }
            break;
        
        case "p":
            printRecords(database);
            break;
        
        case "d":
            downloadRecords(database);
            break;
        
        case "u":
            uploadRecords(database);
            break;
        case "q":
            break;
        
        default:
        System.out.println("Command Was Not Recognized; Please Try Again.");
        break;
      }
    }while(!choice.equals("q"));
    System.out.println("Leaving The Program Now!");
  }
  
  public static void optionMenu() // This is the display menu used so you do not have to memorize your options
  {
    System.out.println("----------------------------------");
    System.out.println("|Commands: n - New employee       |");
    System.out.println("|          c - Compute paychecks  |");
    System.out.println("|          r - Raise wages        |");
    System.out.println("|          p - Print records      |");
    System.out.println("|          d - Download data      |");
    System.out.println("|          u - Upload data        |");
    System.out.println("|          q - Quit               |");
    System.out.println("----------------------------------");
  }
  
  public static void newEmployee(ArrayList<Employee> database) //add a new Employee and Wage h or s
  {
    Scanner inputS = new Scanner (System.in);
    Scanner inputD = new Scanner (System.in);
    System.out.println("Enter name of the new employee:");
    String name = inputS.nextLine();
    System.out.println(" Is the employee Hourly (h) or Salaried (s)");
    char iden = inputS.next().toLowerCase().charAt(0);
    while( iden != 'h' && iden != 's' )
    {
      System.out.println(" Input was not 'h' or 's'; Please Try Again. ");
      iden = inputS.next().toLowerCase().charAt(0); 
    }  
    if ( iden == 'h' )
    {
      System.out.println("Enter Hourly Pay: ");
      double pay = inputD.nextDouble();
      database.add(new HourlyEmployee(name,pay));
      
    }
    else
    {
      System.out.println("Enter Yearly Salary: ");
      double salary = inputD.nextDouble();
      database.add(new SalariedEmployee(name,salary));
    }
  }
  
  public static void printRecords(ArrayList<Employee> database) // print the array/ArrayList
  {
    for(int i = 0; i<database.size();i++)
    {
      System.out.println(database.get(i).toString());
    }
  }
  
  
  public static void downloadRecords(ArrayList<Employee> database) // take all Array values and store them in employees.dat
  {
    String filename = "Employees.dat";
    try
    {
      FileOutputStream fileOut = new FileOutputStream(filename);
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(database);
      out.close();
      System.out.println("Your Employee Data has been downloaded!");
    }  
    catch(IOException e)
    {
      System.out.println(e.getMessage());
    }
  }
  
  
  public static void uploadRecords(ArrayList<Employee> database)  // put all records in employees.dat into Array
  {
    String filename = "Employees.dat";
    try
    {
      FileInputStream fileIn = new FileInputStream(filename);
      ObjectInputStream in = new ObjectInputStream(fileIn);
      database = (ArrayList<Employee>)in.readObject();  
      in.close();
    }
    catch(IOException e)
    {
      System.out.println(e.getMessage());
    }
    catch(ClassNotFoundException e)
    {
      System.out.println(e.getMessage());
    }
    for (int i = 0;  i < database.size();  i++)
    {
      System.out.println(database.get(i));
    }

    
  }
  
  
  
  
  
  
















}