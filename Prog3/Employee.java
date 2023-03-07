//Everett Reynolds
import java.util.*;
import java.io.*;

 abstract class Employee implements Serializable
{

      private String employeeName;
      private double employeeWage; // default in hourly pay
    
      protected Employee(String employeeName, double employeeWage)
      {
        this.employeeName = employeeName;
        this.employeeWage = employeeWage;
      }
      
      public abstract double computePay(int hours);
      
      public String getEmployeeName()
      {
        return employeeName;  
      }
      public void setEmployeeName(String employeeName)
      {
        this.employeeName = employeeName;
      }
      public double getEmployeeWage()
      {
        return employeeWage;
      }
      public void setEmployeeWage(double employeeWage)
      {
        this.employeeWage = employeeWage;
      }
      public double raiseWage(double percentIncrease)
      {
        percentIncrease = percentIncrease/100;
        employeeWage = getEmployeeWage() + (getEmployeeWage()* percentIncrease);
        return employeeWage;
      }

}