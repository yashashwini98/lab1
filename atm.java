import java.util.Date;
import java.util.Scanner;
public class atm {

    public static void main(String[] args) {

            mainMenuOptions();      
    }
            //main menu option method
    public static void mainMenuOptions(){
        Scanner input = new Scanner(System.in);
        //enter id
        System.out.println("Enter an id: "); 
        int id = input.nextInt();
        //create accounts
          Account [] accounts = new Account[10];
        //initialize 100 dollars
        for (int i = 0; i < accounts.length; i++) { 
            accounts[i] = new Account(i, 100); 
        }
        int index = -1; 
        for(int i = 0; i < accounts.length; i++) {
            if(accounts[i].getid() == id) {
            index = i; 
            i = accounts.length;
            }               
        }
        if(id <= 9){
            mainMenu();
            int enterchoice = input.nextInt();                          
            if(enterchoice == 1){
                System.out.println("The balance is " + accounts[index].getbalance());
                mainMenuOptions();
            }
            else if(enterchoice == 2){
                System.out.println("Enter an amount to withdraw ");
                double amount = input.nextDouble();
                accounts[index].withdraw(amount);
                mainMenuOptions();
            }
            else if(enterchoice == 3){
                System.out.println("Enter an amount to deposit ");
                double amount = input.nextDouble();
                accounts[index].deposit(amount);
                mainMenuOptions();
            }
            else if(enterchoice == 4){
                mainMenuOptions();
            }   
        }
        else{
            System.out.println("Please enter a correct id");
            mainMenuOptions();
        }

    }
    //main menu method
    public static void mainMenu(){
        System.out.println("Main menu"+"\n1:check balance"+"\n2:withdraw"
                +"\n3:deposit"+"\n4:exit"+"\nEnter a choice");

    }
    }
        class Account{
            private int id = 0;
            private double balance = 0;
            private double withdraw = 0;
            private double deposit = 0;
            private double amount = 0;

            Account(){
            }

            Account(int id, double balance){
                this.id = id;
                this.balance = balance;
            }

            public int getid(){
                return this.id;

            }
            public void setid(int newid){
                id = newid;
            }
            public double getbalance(){
                return this.balance;
            }
            public void withdraw(double amount){
                balance = balance - amount;
            }

            public void deposit(double amount){
                balance = balance + amount;
            }
        }