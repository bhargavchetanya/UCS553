package Question_7.Main;
import java.util.*;

import Question_7.ApplicationExceptions.OrderException.EmptyCartException;
import Question_7.ApplicationExceptions.ProductException.OutOfStockException;
import Question_7.ApplicationExceptions.ProductException.ProductNotFoundException;
import Question_7.Model.*;

public class Main {
    public static void main(String[] args)throws ProductNotFoundException,OutOfStockException,EmptyCartException{
        ArrayList<Product> Products=new ArrayList<>();
        ArrayList<Orders> orders=new ArrayList<>();
        Products.add(new Product(1, "Phone Cover", 100, 15));
        Products.add(new Product(2, "Camera", 1000, 25));
        Products.add(new Product(3, "Bottle", 15, 10));
        Products.add(new Product(4, "Headphones", 1000, 15));
        Products.add(new Product(5, "Charger", 1150, 9));

        int payment=0;
        for(int i=0;i<3;i++){
            Cart cart1=new Cart();
            cart1.add_items(1, Products,10);
            cart1.add_items(2, Products,10);
            cart1.remove_items(1, 10, Products);
            if(payment%2==0){
                Orders o=new Orders(i,"Chetanya",cart1);
                orders.add(o);
                o.get_order_details(i,orders);
            }
            else{
                System.out.println("Payment Fail");
            }
            payment++;
        }


    }
}
