package ATM;

import java.util.ArrayList;

public class Account {
  private String type;
  private String accountNo;
  private User holder;

  private ArrayList<Transaction> transactions;

  public Account(String type, User holder, Bank theBank){
    this.type=type;

    this.holder=holder;

    //getNewUUID for account

    this.accountNo=getNewAccountNumber();

    this.transactions= new ArrayList<Transaction>();


  }

  public String getNewAccountNumber() {
    return accountNo;
  }
  
}
