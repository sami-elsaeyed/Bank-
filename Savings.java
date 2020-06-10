public class Savings extends Account{
  public Currency balance;
  public double x;
  public Savings(Currency initialAmount, double rate){
    super(initialAmount);
    balance=initialAmount;
    x= rate;
  }
  public void deposit(Currency money){
    balance.add(money); 
  }
  public void withdraw(Currency money){
    try{
      balance.subtract(money);
    }catch(Exception e){
         System.err.println(e.getMessage());
      }
  }
  public Currency getBalance(){
    return getBalance(x);
  }
  public Currency getBalance(double rate){
    return balance= new Currency(balance.getValue()*(1+(int)rate));
  }
  public String toString(){
  return "Your savings account has a balance of "+balance;
  }
}