package Question_7.ApplicationExceptions.ProductException;

public class OutOfStockException extends Exception{
    public OutOfStockException(String Message){
        super(Message);
    }
}
