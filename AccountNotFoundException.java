public class AccountNotFoundException extends Exception{
  public AccountNotFoundException(){
    super();
  }
  public String getMessage(){
    return "You dont have an account of this type. Create one before retrying";
  }
}