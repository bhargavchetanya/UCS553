package food.model;
import food.service.*;

public class PremiumOrder extends FoodOrder implements Discountable {
    public PremiumOrder(int o,String n,double a){
        super(o,n,a);
    }

    @Override
    public double CalculateDeliveryCharge(){
        return 50;
    }

    @Override
    public double ApplyDiscount(double amount){
        return (15*amount)/100;
    }
}
