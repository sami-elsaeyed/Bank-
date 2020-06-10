/*Exception for when the customer attempts to make two of the same type of account
 */ 
public class OneTypePerCustomerException extends Exception{
  public OneTypePerCustomerException(){
    super();
  }
  public String getMessage(){
    return "Customer's can only have one type of each account";
  }
}