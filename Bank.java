/*Sami Elsaeyed 05/11/2020 CISC 3115 Homework 3 
 * Thid is the Bank class which implements the banlmenun and all the other classes. 
 * the main method simply creates one Bank.
  */
import java.util.*;
public class Bank{
  public int numbers=0;
  public Customer[] customers= new Customer[15];
  public Scanner scan=new Scanner(System.in);
  public Bank()throws Exception{
    for(int x=0;x<customers.length;x++){
      customers[x]=new Customer("","");
    }
    System.out.println("MENU :A.Become a Customer B.Check Balance C.Withdraw D.Deposit E.Exit");
    Character choice = scan.next().charAt(0); 
    while(choice!='E'){
      if(choice=='A')
        createAccount();
      if(choice=='B')
        checkBalance();
      if(choice=='C')
        withdrawal();
      if(choice=='D')
        depositing();
      System.out.println("MENU :A.Become A Customer B.Check Balance C.Withdraw D.Deposit E.Exit");
      choice=scan.next().charAt(0);}
    for(int y=0;y<customers.length;y++){
      System.out.println(customers[y].getFirstName()+customers[y].getLastName());
    }
    
  }
  public void createAccount()throws Exception{
    String s =scan.nextLine();
    System.out.println("Please enter First Name:");
    String first=scan.nextLine();
    System.out.println("Please enter Last Name:");
    String last=scan.nextLine();
    for(int i=0;i<customers.length;i++){
      if(first.equals(customers[i].getFirstName()) && last.equals(customers[i].getLastName())){
        System.out.println("An account with this name already exists.");
        return;
        }
      else{
        customers[numbers]=new Customer(first,last);
        System.out.println("Please enter Type of Account");
        String type=scan.nextLine();
        System.out.println("Please enter amount you want to intially deposit into account");
        int init=scan.nextInt();
        Currency green=new Currency(init);
        if(type.equals("Checking")){
          Checking checkers=new Checking(green);
          customers[numbers].addAccount(checkers);
          System.out.println("Thank you for making an Checking account.");}
        if(type.equals("Savings")){
          double x=1;
          Savings checkers=new Savings(green,x);
          customers[numbers].addAccount(checkers);
          System.out.println("Thank you for making SAvings account.");}
        if(type.equals("CD")){
          double x =1; 
          CD checkers=new CD(green,x);
          customers[numbers].addAccount(checkers);
          System.out.println("Thank you for making an  cd account.");}
        
        numbers++;
        return;
      }
    }
  }
  public void checkBalance()throws Exception{
    String s =scan.nextLine();
    System.out.println("Please enter First Name:");
    String first=scan.nextLine();
    System.out.println("Please enter Last Name:");
    String last=scan.nextLine();
    System.out.println("Enter Account type:");
    String type=scan.nextLine();
    for(int i=0;i<customers.length;i++){
      if(first.equals(customers[i].getFirstName()) && last.equals(customers[i].getLastName())){
        if(type=="Checking")
          customers[i].balance(type);
        else{
          customers[i].balance(type);
        }
        System.out.println("The above number is the amount in this Account.");
        return;
      }
    }
    System.out.println("An account with this name doesnt exist");
  }
  public void withdrawal()throws Exception{
    String s =scan.nextLine();
    System.out.println("Please enter First Name:");
    String first=scan.nextLine();
    System.out.println("Please enter Last Name:");
    String last=scan.nextLine();
    System.out.println("Enter Account type:");
    String type=scan.nextLine();
    System.out.println("Enter the amount you would like to withdraw:");
    Currency amount=new Currency(scan.nextInt());
    for(int i=0;i<customers.length;i++){
      if(first.equals(customers[i].getFirstName())&&last.equals(customers[i].getLastName())){
        customers[i].withdraw(amount,type);
        customers[i].balance(type);
        System.out.println("The above number is whats left in this account");
        return;
      }
   }
    System.out.println("An account with this name doesnt exist.");   
  }
   public void depositing() throws Exception{
     String s =scan.nextLine();
    System.out.println("Please enter First Name:");
    String first=scan.nextLine();
    System.out.println("Please enter Last Name:");
    String last=scan.nextLine();
    System.out.println("Enter Account type:");
    String type=scan.nextLine();
    System.out.println("Enter the amount you would like to deposit:");
    Currency amount=new Currency(scan.nextInt());
    for(int i=0;i<customers.length;i++){
      if(first.equals(customers[i].getFirstName())&&last.equals(customers[i].getLastName())){
        customers[i].deposit(amount,type);
        customers[i].balance(type);
        System.out.println("The above number is the amount in this account");
        return;
      }
      else{
        System.out.println("You are not a customer at our Bank yet!");
        return;
      }
    } 
   }
  public static void main(String[]args)throws Exception{
    new Bank();
  }
}

