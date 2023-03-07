Everett Reynolds- Project 3 Algorithm / Problem Breakdown

The problem at hand is there is a need for a database program which maintains all the wage information of employees in a company. 
The company has two sets of employees, those who earn an hourly wage, and those who earn an annual salary.
To solve the problem, we will need to create an Employee class which contains to child classes that are named HourlyEmployee and SalariedEmployee.
Employee will contain information all Employees need to have.
It will have a name and wage variable along with a protected constructor for the creation of employees.
Employee will have getter and setter methods for the variables, and will have a raiseWage method which makes the wage higher by a percentage.
Employee will contain an abstract method named CcomputePay which will need to be implemented by the other classes as well.
Wage will also be by default be in an hourly form and this will come into play later.
HourlyEmployee will be a child class that is an Employee.
It will contain a fully realized version of computePay and will contain a toString method for the printing out of HourlyEmployee objects.
Salaried Employee will also be a child class that is an Employee.
Salaried Employee will have a varible special to it, an Annual Salary.
There will be a getter and setter for this method and it will also have a computePay method that involves the conversion of an annual salary into an hourly pay to be compared to the HourlyEmployee class
There will also be a toString specific to Salaried Employee deployed here.
Throughout these classes, there is a file named Utilities which has the functions toDollars and pad which will be utilized to create nicer looking print statements.
The main driver class of the program is called Personnel.
Personnel will contain our main method and will extend Employee to get access to it's methods.
There are certain commands that the user needs to be able to do with this program such as adding an employee, computing paychecks, raising wages, printing records, downloading data, and uploading data.
Our Personnel class will have a menu which displays these options to the user using a do while loop that keeps the user in the while until they want to quit.
We use the characters n,c,r,p,d,u,and q to represent the functions the user would like to use, and they will be presented as avenues of option through a switch statement.
Adding an Employee simply adds a new employee to an ArrayList of Employee objects instantiated within the main method.
This will determine whether this employee is an HourlyEmployee or a SalariedEmployee as well.
Compute Paychecks will ask whether the Employee in the ArrayList is an HourlyEmployee or a SalariedEmployee and call back to the computePaycheck methods made within the child classes.
Raises wages will call back to the raiseWage method created in the Employee class.
Print Records will take the Employee ArrayList and will print out the entire contents of the ArrayList for the user.
Download Data will use InputFileStreams to store the data of an ArrayList in a seperate binary text file.
Upload Data will use OutputFileStreams to print out the data that is stored in a given binary text file.
Quit will make sure the user exits the program.
