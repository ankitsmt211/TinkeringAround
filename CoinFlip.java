import java.util.Random;
import java.util.Scanner;
class CoinFlip{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Random rand = new Random();

        //game variables
        int userBalance=10000;
        String coinFace="";



        while(userBalance>0){
            //Menu selection
            System.out.println("---------------Welcome to CoinFlip---------------");
            System.out.println("");
            System.out.println("");
            System.out.println("\tPlease choose one of the options: ");
            System.out.println("\t1.Flip the coin");
            System.out.println("\t2.check Balance");
            System.out.println("\t3.Exit");



            int userInput=sc.nextInt();

            if(userInput==3) {
                System.out.println("Thanks for Playing");
                break;
            }


            if(userInput==1){
             System.out.println("\tWhich one you wanna bet on?");
             System.out.println("\t1.Heads");
             System.out.println("\t2.Tails");
             
             int userInput2=sc.nextInt();


             System.out.println("Enter the amount you wanna bet: ");
             System.out.println("");
             int amountToBeBet=sc.nextInt();

             if(amountToBeBet<=userBalance){
                int flip=rand.nextInt(2);

                if(flip==1){
                    coinFace="Heads";
                }
                else{coinFace="Tails";
            }

            if(userInput2==flip){
                System.out.println("");
                System.out.println("");
                System.out.println("It's a "+coinFace+" You won!!");
                System.out.println("");
                System.out.println("");
                userBalance+=amountToBeBet;
             }

             else{
                System.out.println("Oof you lost, "+coinFace+" rolled");
                System.out.println("");
                System.out.println("");
                userBalance-=amountToBeBet;
             }

        }

        else{
            System.out.println("Your balance is : "+userBalance);
            System.out.println("Bet lower amount than :"+userBalance);
            continue;
        }

       


    }
    else if(userInput==2) {
        System.out.println("Your current Bal: "+userBalance);
    }

    else{
        System.out.println("Please Enter valid input!!");
        continue;
    }
}

if(userBalance<=0) System.out.println("Whoops!!! You ran outta Moneyyyyyyyyy, Thanks for playing");
    sc.close();
    }

}

