package food.model;

 public abstract class FoodOrder {
    private int OrderId;
    private String CustomerName;
    private double Amount;
    static String RestaurentName="Haldirams";
    public abstract double CalculateDeliveryCharge();
    FoodOrder(int o,String n,double a){
        OrderId=o;
        CustomerName=n;
        Amount=a;
    }
    public int getOrderId(){
        return OrderId;
    }
    public String getCustomerName(){
        return CustomerName;
    }
    public double detAmount(){
        return Amount;
    }
}
