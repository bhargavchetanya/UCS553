package Question_7.Model;
import java.util.*;

import Question_7.ApplicationExceptions.ProductException.OutOfStockException;
import Question_7.ApplicationExceptions.ProductException.ProductNotFoundException;

public class Product {
    private String product_name;
    private int product_id;
    private int price;
    private int stock=0;
    public Product(int id,String name,int p,int stock){
        product_name=name;
        product_id=id;
        price=p;
        this.stock=stock;
    }
    public String get_product_name(){
        return product_name;
    }
    public int get_product_id(){
        return product_id;
    }
    public int get_product_price(){
        return price;
    }
    public int get_stock(){
        return stock;
    }
    public void set_product_name(String n){
        product_name=n;
    }
    public void set_product_id(int i){
        product_id=i;
    }
    public void set_product_price(int p){
        price=p;
    } 
    public void set_product_stock(int stock){
        this.stock=stock;
    }
    public static Product search(int id,ArrayList<Product> lis,int items)throws ProductNotFoundException, OutOfStockException{
        for(int i=0;i<lis.size();i++){
            Product temp=lis.get(i);
            if(temp.product_id==id){
                if(temp.stock<items){
                    throw new OutOfStockException("Out of stock...");
                }
                return temp;
            }
        }
        throw new ProductNotFoundException("Product Not Found...");
    }
    public static Product search(String Name,ArrayList<Product> lis,int items)throws ProductNotFoundException, OutOfStockException{
        for(int i=0;i<lis.size();i++){
            Product temp=lis.get(i);
            if(Name.equals(temp.product_name)){
                if(temp.stock<items){
                    throw new OutOfStockException("Out of stock...");
                }
                return temp;
            }
        }
        throw new ProductNotFoundException("Product Not Found...");
    }
}
