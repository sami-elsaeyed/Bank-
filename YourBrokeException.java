/*Exception for when the account doesnt have enough money 
 */ 
public class YourBrokeException extends Exception{
  public YourBrokeException(){
    super();
  }
  public String getMessage(){
    return "Not enough money in this account.";
  }
}