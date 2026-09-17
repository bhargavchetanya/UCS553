package Question_7.ApplicationExceptions.ProductException;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String Message){
        super(Message);
    }
}