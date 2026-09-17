package Question_5;
//when balance is insufficient
public class InvalidAmountException extends Exception{
    public InvalidAmountException(String Message){
        super(Message);
    }
}
