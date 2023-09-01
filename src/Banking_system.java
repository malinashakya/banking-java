
import java.util.Scanner;

public class Banking_system {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount obj = new BankAccount("Ram Prasad", "BL001");
        obj.showMenu();
    }
}

class BankAccount {

    int balance;
    int previousTransaction;
    String customer_name;
    String customer_id;

    BankAccount(String cusname, String cusid) {
        customer_name = cusname;
        customer_id = cusid;
    }

    void Deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited:" + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn:" + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occured");
        }
    }

    void showMenu() {
        char option = '\0';
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome" + customer_name);
        System.out.println("Welcome" + customer_id);
        System.out.println("/n");

        System.out.println("A: Check Account Balance");
        System.out.println("B: Deposit Money");
        System.out.println("C: Withdraw Money");
        System.out.println("D: Previous Transaction Details");
        System.out.println("E: Calculate Fixed Deposit Interest");
        System.out.println("F: Calculate Saving Account Interest");
        System.out.println("Q:Exit");

        do {
            System.out.println("*************************");
            System.out.println("Enter your option");
            System.out.println("*************************");

            option = sc.next().charAt(0);
            switch (option) {
                case 'A':
                    System.out.println("*************************");
                    System.out.println("Account Balance=" + balance);
                    System.out.println("*************************");
                    System.out.println("\n");
                    break;
                case 'B':
                    System.out.println("*************************");
                    System.out.println("Enter an amount to deposit");
                    System.out.println("*************************");
                    int amount = sc.nextInt();
                    Deposit(amount);
                    System.out.println("Amount deposited in the account" + amount);
                    System.out.println("\n");
                    break;
                case 'C':
                    System.out.println("*************************");
                    System.out.println("Enter an amount to withdraw");
                    System.out.println("*************************");
                    int amount2 = sc.nextInt();
                    withdraw(amount2);
                    System.out.println("Amount withdrawn from the account=" + amount2);
                    System.out.println("\n");
                    break;
                case 'D':
                    System.out.println("*************************");
                    System.out.println("Your previous transaction status is:\n");
                    getPreviousTransaction();
                    System.out.println("*************************");
                    System.out.println("\n");
                    break;
                case 'E':
                    double rate=8.0;
                    System.out.println("Enter the principal amount");
                    double principal=sc.nextDouble();
                    
                    System.out.println("Enter the time period(in years):");
                    double time=sc.nextDouble();
                    
                    //fixed deposit
                    double fdInterest=(principal*rate*time)/100;
                    System.out.println("Interest for fixed deposit:"+fdInterest);
                    break;
                case 'F'  :
                    double interest=6;
                    System.out.println("Enter the principal amount:");
                    double principalAmount=sc.nextDouble();
                    
                    System.out.println("Enter the time period(in years):");
                    double timePeriod=sc.nextDouble();
                    
                    double saInterest=principalAmount*Math.pow((1+interest/100),timePeriod)-principalAmount;
                    System.out.println("Interest for Saving Accounts:"+saInterest);
                    break;
                case 'Q':
                    System.out.println("Preparing to exit...");
                    break;
                default:
                    System.out.println("Invalid option!! please enter one of the valid options:");
                    break;
                   
            }
        } while (option!='Q');
        System.out.println("Thank you for using our services.......");
    }
}
