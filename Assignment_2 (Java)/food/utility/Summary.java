package food.utility;
import food.model.*;
import java.time.LocalDateTime;
import food.service.*;

public class Summary {
    public Summary(FoodOrder f){
        System.out.println("Bill generatred at -> "+ LocalDateTime.now());
        double amount=f.detAmount();
        double discount=0;
        Discountable d=(Discountable)f;
        discount=d.ApplyDiscount(f.detAmount());
        double dilevery=f.CalculateDeliveryCharge();
        System.out.println("Customer Name ->"+f.getCustomerName());
        System.out.println("Amount -> "+f.detAmount());
        System.out.println("Discount -> "+discount);
        System.out.println("Delivery Charge -> "+f.CalculateDeliveryCharge());
        System.out.println("Total Bill -> "+ (amount-discount+dilevery));
    }
}
