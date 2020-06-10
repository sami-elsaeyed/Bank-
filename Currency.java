public class Currency{
  private int cents;
  public Currency(){
    cents=0;
  }
  public Currency(int x){
    cents=x;
  }
  public int getValue(){
    return cents;
  }
  public Currency add(Currency rhs){
    Currency balance=new Currency(cents+=rhs.getValue());
    return balance;
  }
  public Currency subtract(Currency rhs)throws Exception{
    if(cents<rhs.getValue())
      throw new YourBrokeException();
    Currency balance=new Currency(cents-=rhs.getValue());
    return balance ;
  }
  public String toString(){
    return"$"+cents/100+"."+cents%100;
  }
}