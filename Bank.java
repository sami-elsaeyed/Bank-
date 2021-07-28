/*Sami Elsaeyed 05/11/2020 Bank Project 
 * This is the Bank class which implements the bank menu and all the other classes. 
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
    System.out.println("MENU :A.Become a Customer B.Add an Account C.Check Balance D.Withdraw E.Deposit F.Exit");
    Character choice = scan.next().charAt(0); 
    while(choice!='F'){
      if(choice=='A')
        createAccount();
      if(choice=='B')
        addAccount();
      if(choice=='C')
        checkBalance();
      if(choice=='D')
        withdrawal();
      if(choice=='E')
        depositing();
      System.out.println("MENU :A.Become A Customer B.Add an Account C.Check Balance D.Withdraw E.Deposit F.Exit");
      choice=scan.next().charAt(0);}
    int y=0;
    while(customers[y].getFirstName()!=""){
      System.out.println(customers[y].getFirstName()+" "+customers[y].getLastName());
      y++;
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
          System.out.println("Thank you for making Savings account.");}
        if(type.equals("CD")){
          double x =1; 
          CD checkers=new CD(green,x);
          customers[numbers].addAccount(checkers);
          System.out.println("Thank you for making a CD account.");}
        
        numbers++;
        return;
      }
    }
  }
  public void addAccount()throws Exception{
    String s =scan.nextLine();
    System.out.println("Please enter First Name:");
    String first=scan.nextLine();
    System.out.println("Please enter Last Name:");
    String last=scan.nextLine();
    for(int f=0;f<customers.length;f++) {
      if(first.equals(customers[f].getFirstName()) && last.equals(customers[f].getLastName())) {
        System.out.println("Please enter Account Type:");
        String type=scan.nextLine();
        System.out.println("Please enter amount you want to intially deposit into account");
        int init=scan.nextInt();
        Currency green=new Currency(init);
        if(type.equals("Checking")){
          Checking checkers=new Checking(green);
          customers[f].addAccount(checkers);
          System.out.println("Thank you for making an Checking account.");}
        if(type.equals("Savings")){
          double x=1;
          Savings checkers=new Savings(green,x);
          customers[f].addAccount(checkers);
          System.out.println("Thank you for making SAvings account.");}
        if(type.equals("CD")){
          double x =1; 
          CD checkers=new CD(green,x);
          customers[f].addAccount(checkers);
          System.out.println("Thank you for making an  cd account.");}
  }
    }
  }
  public void checkBalance()throws Exception{
    String s =scan.nextLine();
    System.out.println("Please enter First Name:");
    String first=scan.nextLine();
    System.out.println("Please enter Last Name:");
    String last=scan.nextLine();
    for(int f=0;f<customers.length;f++) {
      if (first.equals(customers[f].getFirstName()) && last.equals(customers[f].getLastName())) {
        System.out.println("Please enter Account Type:");
        String type=scan.nextLine();
        customers[f].balance(type);
        return;
      }
    }
    System.out.println("An account with this name doesnt exist");
    return;
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
    } 
    System.out.println("You are not a customer at our Bank yet!");
    return;   
    } 
  public static void main(String[]args)throws Exception{
    new Bank();
  }
}

