package ATM;

import java.security.MessageDigest;
import java.util.ArrayList;

public class User{
    private String name;
    private String city;
    private char gender;
    private String contact;
    private String uuid;
    private byte pinHash[];
    private ArrayList<Account> accounts;

   public User(String name, String city, char gender, String contact,String pin, Bank theBank)throws Exception{
    this.name=name;
    this.city=city;
    this.gender=gender;
    this.contact=contact;

    //secure pin using MD5 algorithm
    MessageDigest md = MessageDigest.getInstance("MD5");
    this.pinHash=md.digest(pin.getBytes());
 
    //to create unique user id
    this.uuid=theBank.getNewUserUUID();

    //create empty list of accounts for user

    this.accounts=new ArrayList<Account>();

    //log message for user
    System.out.println("User with name:"+this.name+" and user ID "+getUUID()+" Created");
   }

   public void addAccount(Account acc){
        this.accounts.add(acc);
   }

public String getUUID() {
    return uuid;
}

   
}
