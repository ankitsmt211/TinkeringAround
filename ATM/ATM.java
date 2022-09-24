package ATM;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        Bank theBank = new Bank("Bank of India");
        
        User user=theBank.addUser("Ankit Yadav", 'M', "7742790727", "Mainpuri", "Ankit135");

        Account newAccount = new Account("Current", user, theBank);

        user.addAccount(newAccount);
        theBank.addAccount(newAccount);
    }
}
