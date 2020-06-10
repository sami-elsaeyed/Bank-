public class CD extends Account{
  public Currency balance;
  public double x;
  public CD (Currency initialAmount, double rate){
    super(initialAmount);
  }
  public void deposit(Currency amount){
    try{throw new AccountTypeException();
    }catch(Exception e){
       System.out.println(e.getMessage()); 
    }
  }
  public void withdraw(Currency amount){
    try{
    throw new AccountTypeException();
    }catch(Exception e){
       System.out.println(e.getMessage());
    }
  }
   public Currency getBalance(){
    return getBalance(x);
  }
  public Currency getBalance(double rate){
    return balance= new Currency(balance.getValue()*(1+(int)rate));
  }
  public String toString(){
    return "Your CD account has a balance of "+balance;
  }  
    
}