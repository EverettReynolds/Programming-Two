//Everett Reynolds
import java.util.*;
import java.io.*;

  public class HourlyEmployee extends Employee // Part Time Workers/ less skilled labor
  {
    public HourlyEmployee(String employeeName, double employeeWage)
    {
      super(employeeName,employeeWage);
    }
    
    public double computePay(int hours) // Computes the pay accounting for whether the employee has worked 40 or more hours
    {
      if(hours <= 40 )
      {
        return getEmployeeWage() * hours;
      }
      else
      {
        return (getEmployeeWage() * 40) + ( (hours-40) * (getEmployeeWage()*1.5) );
      }
      
    }
    
    public String toString() 
    {
      return " Employee Name: " + getEmployeeName() + "\n Hourly Pay: " + Utilities.toDollars(getEmployeeWage()); 
    }
    
  }