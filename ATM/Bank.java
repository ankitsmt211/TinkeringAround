package ATM;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Random;

public class Bank {
   private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    public Bank(String bank){
        this.name=bank;
        this.users=new ArrayList<User>();
        this.accounts=new ArrayList<Account>();
    }

    public String getNewUserUUID(){
        String UUID;
        int len=10;
        boolean isUnique;

        Random rng = new Random();
        do {
            UUID="";
            //generate unique UUID
            for(int i=0;i<len;i++){
                UUID+= ((Integer)rng.nextInt(10)).toString();
            }

            //check if UUID generated is unique
            isUnique=false;
            for(User u: this.users){
                if(UUID.compareTo(u.getUUID())==0){
                    isUnique=true;
                    break;
                }
            }
            
        } while (isUnique);

        return UUID;
    }

    public String getNewAccountNumber(){
        String UUID;
        int len=10;
        boolean isUnique;

        Random rng = new Random();
        do {
            UUID="";
            //generate unique UUID
            for(int i=0;i<len;i++){
                UUID+= ((Integer)rng.nextInt(10)).toString();
            }

            //check if UUID generated is unique
            isUnique=false;
            for(Account a: this.accounts){
                if(UUID.compareTo(a.getAccountNo())==0){
                    isUnique=true;
                    break;
                }
            }
            
        } while (isUnique);

        return UUID;
    }

    public void addAccount(Account acc){
        this.accounts.add(acc);
    }

    public User addUser(String name, char gender, String contact, String city, String pin)throws Exception{
        //create user

        User newUser = new User(name, city, gender, contact, pin, this);

        this.users.add(newUser);

        //create account for user

        Account newAccount = new Account("savings", newUser, this);
            //adding account to bank account list and user account list

            newUser.addAccount(newAccount);
            this.addAccount(newAccount);


            return newUser;
    }

    public User userLogin(String userID, String pin){
        for(User us: this.users){
            //checking if user exits in our database
            if(us.getUUID().compareTo(userID)==0 && us.validatePin(pin)){
                return us;
            }
        }
        //didnt' find it
        return null;
    }

    public boolean validatePin(String pin){
        MessageDigest md = new MessageDigest.getInstance("MD5");

        return MessageDigest.isEqual(md.digest(pin.getBytes()), this.pinHash);
    }
}
