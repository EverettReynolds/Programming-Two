

import java.util.*;

public class CheckingAccount extends Account
{
  private int checkNumber;
  
public CheckingAccount(double initialBalance)
{
  super(initialBalance);
  this.checkNumber = 0;  
}

public int getChecksWritten()
{
  return checkNumber;
}

public void writeCheck(double amount)
{
withdraw(amount);
checkNumber++;


}




}