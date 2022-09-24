package ATM;

public class Transaction {
    private double amount;
    private Date timestamp;
    private String memo;
    private Account inAccount;

    public Transaction(double amount, Account inAccount){
        this.amount=amount;
        this.inAccount=inAccount;
        this.timestamp=new Date();
        this.memo="";
    }

    public Transaction(double amount, Account inAccount, String memo){
        //call two args contructor first

        this.memo=memo;
    }
}
