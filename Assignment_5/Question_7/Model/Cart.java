package Question_7.Model;

import java.util.*;
import Question_7.ApplicationExceptions.ProductException.OutOfStockException;
import Question_7.ApplicationExceptions.ProductException.ProductNotFoundException;
import Question_7.Services.*;
import Question_7.ApplicationExceptions.OrderException.EmptyCartException;

public class Cart {
    ArrayList<Pair>list=new ArrayList<>();
    int price=0;
    public Cart(){}
    public void Find_by_id(int id,ArrayList<Product>lis,int items)throws ProductNotFoundException,OutOfStockException{
        Product p=Product.search(id,lis,items);
        System.out.println("Product Name = "+p.get_product_name());
        System.out.println("Product id = "+p.get_product_id());
        System.out.println("Product Price = "+p.get_product_price());
        System.out.println("Product Items left = "+p.get_stock());
    }
    public void Find_by_name(String Name,ArrayList<Product>lis,int items)throws ProductNotFoundException,OutOfStockException{
        Product p=Product.search(Name,lis,items);
        System.out.println();
        System.out.println("Product Name = "+Name);
        System.out.println("Product id = "+p.get_product_id());
        System.out.println("Product Price = "+p.get_product_price());
        System.out.println("Product Items left = "+p.get_stock());
    }
    public void add_items(int id,ArrayList<Product>lis,int items)throws ProductNotFoundException,OutOfStockException{
        Product p=Product.search(id,lis,items);
        list.add(new Pair(p.get_product_id(),items));
        price+=items*(p.get_product_price());
        p.set_product_stock(p.get_stock()-items);
    }
    public void remove_items(int id,int items,ArrayList<Product>lis)throws EmptyCartException,ProductNotFoundException,OutOfStockException{
        for(int i=0;i<list.size();i++){
            Pair x=list.get(i);
            if(x.first==id){
               if(x.second<items) throw new EmptyCartException("Not that much items in cart");
               if(x.second==items){
                Product p=Product.search(id,lis,items);
                p.set_product_stock(p.get_stock()+items);
                list.remove(i);
                price-=items*(p.get_product_price());
                return;
               }
               else{
                Product p=Product.search(id,lis,items);
                p.set_product_stock(p.get_stock()+items);
                x.second-=items;
                price-=items*(p.get_product_price());
                return;
               }
            }
        }
        throw new ProductNotFoundException("Product not in your Cart");
    }
    public ArrayList<Pair> get_Items(){
        return list;
    }
    public int get_cart_price(){
        return price;
    }

}

