public class Customer{
  public String first;
  public String last;
  private static int number=0;
  public Account[] accounts= new Account[3];
  public Customer(String a,String t){
    first=a;
    last=t;
  }
  public void addAccount(Account type) throws OneTypePerCustomerException{
    if(number>3){
      System.out.println("Customer's can only have one type of each account");
    }
    for(int i=0;i<accounts.length;i++){
      if(accounts[i] instanceof Checking){
        if(type instanceof Checking)
          throw new OneTypePerCustomerException();
      }
      if(accounts[i] instanceof Savings){
        if(type instanceof Savings)
          throw new OneTypePerCustomerException();
        }
   
      if(accounts[i] instanceof CD){
        if(type instanceof CD)
          throw new OneTypePerCustomerException();
        }
    }
    accounts[number]=type;
    number++;
  }
  public String getFirstName(){
    return first;
  }
  public String getLastName(){
    return last;
  }
  public void deposit(Currency money, String type)throws AccountTypeException,AccountNotFoundException{
    for(int i=0;i<accounts.length;i++){
      if(accounts[i] instanceof Checking){
        if(type.equals("Checking")){
          accounts[i].deposit(money);
          return; 
        }
      }
      if(accounts[i] instanceof Savings){
        if(type.equals("Savings")){
          accounts[i].deposit(money);
          return;
        }
      }
      if(accounts[i] instanceof CD){
        if(type.equals("CD")){
          throw new AccountTypeException();
        }
      }
    }
    throw new AccountNotFoundException();
  }
  public void withdraw(Currency money, String type)throws AccountTypeException,AccountNotFoundException{
    for(int i=0;i<accounts.length;i++){
      if(accounts[i] instanceof Checking){
        if(type.equals("Checking")){
          accounts[i].withdraw(money);
          return; 
        }
      }
      if(accounts[i] instanceof Savings){
        if(type.equals("Savings")){
          accounts[i].withdraw(money);
          return;
        }
      }
      if(accounts[i] instanceof CD){
        if(type.equals("CD")){
          throw new AccountTypeException();
        }
      }
    }
    throw new AccountNotFoundException();
  }
  public void balance(String type) throws Exception{
    double r = 1;
    for(int i=0;i<accounts.length;i++){
      if(accounts[i] instanceof Checking){
        if(type.equals("Checking")){
          System.out.println("You have "+accounts[i].getBalance()+" currently in your "+type+" account");
          return;
        }
      }
      if(accounts[i] instanceof Savings){
        if(type.equals("Savings")){
          System.out.println("You have "+accounts[i].getBalance(r)+" currently in your "+type+" account");
          return;
        }
      }
      if(accounts[i] instanceof CD){
        if(type.equals("CD")){
          System.out.println("You have "+accounts[i].getBalance(r)+" currently in your "+type+" account");
          return;
        }
      }
    }
    throw new AccountNotFoundException();
  }
  public String toString(){
    return first+" "+last+"'s account.";
  }
  
}