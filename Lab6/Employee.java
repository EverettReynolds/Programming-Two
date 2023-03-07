import java.util.*;

public class Employee extends Person
{
private double salary;
private Date employmentDate;


public Employee(String lastName, String firstName, Date birthDate, double salary, Date employmentDate)
{
super(lastName, firstName, birthDate); 
this.salary = salary;
this.employmentDate = employmentDate;
}

public double getSalary()
{
  return salary;
}

public void setSalary(double salary)
{
  this.salary = salary;
}

public Date getEmployment()
{
  return employmentDate;
}

public void setEmployment(Date employmentDate)
{
  this.employmentDate = employmentDate;
}

public String toString()
{
  return "name = " + getLastName() + ", " + getFirstName() + "\nsalary = " + salary + "\nbirth = " + getBirthDate() + "\nhired = " + employmentDate + "\n" ;
}















}