import java.util.ArrayList;
import java.util.Scanner;

public class SimpleBankingApplication {

    static double balance = 0;

    public static void deposit(Scanner obj){
        System.out.print("Enter amount to deposit: ");
        double amount = obj.nextDouble();
        if (amount > 0){
            balance = balance + amount;
            System.out.println("Amount successfully deposited");
        } else {
            System.out.println("Your Amount is Invalid");
        }
    }

    public static void withdraw(Scanner obj){
        System.out.print("Enter amount to Withdraw: ");
        double amount = obj.nextDouble();

        if (balance >= amount){
            balance = balance - amount;
            System.out.println("Withdraw successful");
        } else {
            System.out.println("Your balance is insufficient for the amount");
        }
    }

    public static void checkBalance(){
        System.out.println("Your balance is " + balance);
    }

    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean condition = true;
        while(condition){
            System.out.println("\n");
            System.out.println("\t\t\tSimple Banking Application\t\t\t");
            System.out.println("\n");
            System.out.println("Press \"1\" for Checking Balance");
            System.out.println("Press \"2\" for Deposit");
            System.out.println("Press \"3\" for Withdraw");
            System.out.println("Press \"4\" for Exiting Application");
            System.out.println();
            System.out.print("Enter your choice: ");
            int userChoice = sc.nextInt();
            switch(userChoice){
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(sc);
                    break;
                case 3:
                    withdraw(sc);
                    break;
                case 4:
                    condition = false;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
