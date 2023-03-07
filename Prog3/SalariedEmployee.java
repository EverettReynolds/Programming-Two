//Everett Reynolds
import java.util.*;
import java.io.*;

  public class SalariedEmployee extends Employee  // Full Time Workers/ educated, schooled work
  {
  public double annualSalary;
  public SalariedEmployee(String employeeName, double annualSalary)
    {
      super(employeeName,annualSalary/(40*52));
      this.annualSalary = annualSalary;
    }
    public double getAnnualSalary()
    {
      return getEmployeeWage() * (40*52);
    }
    public void setAnnualSalary(double annualSalary)
    {
      setEmployeeWage(annualSalary/(40*52));
      this.annualSalary = annualSalary;
      
    }
    public double computePay(int hours) 
    {
      return 40 * getEmployeeWage();
    }
    public String toString() // figure out how to pad this for a 40 space string
    {
    
    return " Employee Name: " + getEmployeeName() + "\n Yearly Pay: " + Utilities.toDollars(getAnnualSalary()); 
    
    }
  
  
  
  
  
  
  
  
  }