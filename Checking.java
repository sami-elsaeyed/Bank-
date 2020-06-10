public class Checking extends Account{
  public Currency balance;
  public Checking (Currency initialAmount){
    super(initialAmount);
    balance=initialAmount;
  }
  public void deposit(Currency amount){
    balance.add(amount);
  }
  public void withdraw(Currency amount){
    try{
      balance.subtract(amount);
    }catch(Exception e){
       System.err.println(e.getMessage()); 
    }
  }
  public Currency getBalance(){
    return balance;
  }
  public Currency getBalance(double rate){
    getBalance();
    return balance;}
  public String toString(){
    return "Your checking account has a balance of "+balance;
  }  
    
}