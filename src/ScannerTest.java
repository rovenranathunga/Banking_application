//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import java.util.Scanner;

public class ScannerTest{
    public static void main(String[] args) {

        BankAccount ob1 = new BankAccount("Pete", "1011");

        ob1.showmenu();
        }
}

class BankAccount{
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;
    int interest;
    int rate;

    BankAccount(String cname, String cid){
       customerName = cname;
       customerID = cid;

    }

    void deposit(int amount){
        if(amount!=0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount){
        if(amount != 0){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void InterestRate(){
        if(balance > 500){
              rate = ((balance*20)/100);
        }else{
              rate = 0;
        }

       System.out.println("Interest: " + rate);
    }


    void getPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("Deposited" + previousTransaction);
        } else if (previousTransaction < 0) {

            System.out.println("Withdrawn" + Math.abs(previousTransaction));

        }else{
            System.out.println("No transaction has occured");
        }
    }

    void showmenu(){

        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome" + customerName);
        System.out.println("Your ID is" + customerID);
        System.out.println("/n");
        System.out.println("A - Check Balance");
        System.out.println("B - Deposit");
        System.out.println("C - Withdraw");
        System.out.println("D - Previous Transaction");
        System.out.println("E - Current Interest");

        do{
            System.out.println("Enter option number");
            option  = scanner.next().charAt(0);
            System.out.println("\n");

            switch(option){
                case 'A':
                    System.out.println("Balance = " + balance);
                    System.out.println("Balance = " + balance);
                    break;
                case 'B':
                    System.out.println("Enter an amount to deposit");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    break;
                case 'D':
                    getPreviousTransaction();
                    break;
                case 'C':
                    System.out.println("Enter an amount to withdraw");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    break;
                case 'E':
                    System.out.println("Your accumulated interest  \n");
                    InterestRate();
                    break;


                default:
                    System.out.println("Invalid Option. Please enter again");
                    break;


            }

        }while(option != 'F');
        System.out.println("Thank You for using our services");
    }
}
