package Question_7.Model;
import java.util.*;
import Question_7.Services.*;

public class Orders {
    private int order_id;
    private String customer_name;
    private ArrayList<Pair> product_list=new ArrayList<>();
    Cart c;
    public Orders(int order_id,String Customer_name,Cart c){
        this.order_id=order_id;
        this.customer_name=Customer_name;
        product_list = new ArrayList<>(c.get_Items());
        this.c=c;
    }
    public void get_order_details(int id,ArrayList<Orders> arr){
        Orders it;
        boolean flag=false;
        for(int i=0;i<product_list.size();i++){
            it=arr.get(i);
            if(id==it.order_id){
                flag=true;
                System.out.println("Customer Name -> "+it.customer_name);
                System.out.println("Order ID -> "+it.order_id);
                System.out.println("Products(product_id,price of one) -> ");
                for(int j=0;j<product_list.size();j++){
                    Pair v=product_list.get(j);
                    System.out.println(v.first +"  "+ v.second);
                }
                System.out.println("Price -> "+it.c.get_cart_price());
                break;
            }
        }
        if(!flag)System.out.println("Wrong order id entered");

    }
}