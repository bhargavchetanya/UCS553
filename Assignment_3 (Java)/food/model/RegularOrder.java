package food.model;
import food.service.*;

public class RegularOrder extends FoodOrder implements Discountable{
    public RegularOrder(int o,String n,double a){
        super(o,n,a);
    }

    @Override
    public double CalculateDeliveryCharge(){
        return 80;
    }

    @Override
    public double ApplyDiscount(double amount){
        return (10*amount)/100;
    }
}
