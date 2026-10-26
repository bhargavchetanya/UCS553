package food.main;
import food.model.*;
import food.utility.*;

public class Main {
    public static void main(){
        FoodOrder lis[]=new FoodOrder[6];
        FoodOrder order1 = new PremiumOrder(1,"Chetanya",500);
        lis[0]=order1;
        FoodOrder order2 = new PremiumOrder(2,"Anshaj",100);
        lis[1]=order2;
        FoodOrder order3 = new RegularOrder(3,"Anant",900);
        lis[2]=order3;
        FoodOrder order4 = new PremiumOrder(4,"Rumani",1000);
        lis[3]=order4;
        FoodOrder order5 = new PremiumOrder(5,"Bhavya",400);
        lis[4]=order5;
        FoodOrder order6 = new PremiumOrder(6,"Kasvi",700);
        lis[5]=order6;
        for(int i=0;i<6;i++){
            System.out.println("SUMMARY");
            new Summary(lis[i]);
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }
}
