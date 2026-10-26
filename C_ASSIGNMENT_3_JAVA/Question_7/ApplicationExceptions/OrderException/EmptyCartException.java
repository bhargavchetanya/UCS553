package Question_7.ApplicationExceptions.OrderException;

public class EmptyCartException extends Exception{
    public EmptyCartException(String Message){
        super(Message);
    }
}
