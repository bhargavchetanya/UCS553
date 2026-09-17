package Question_3;
import java.util.*;

public class Main{
    public static void main(String[] args){
        int a=0;
        int b=0;
        Scanner sc=new Scanner(System.in);
        a=sc.nextInt();
        b=sc.nextInt();
        System.out.println("Enter Choice->");
        System.out.println("1->Addition");
        System.out.println("2->Subtraction");
        System.out.println("3->Multiplication");
        System.out.println("2->Division");
        int c=sc.nextInt();
        if(c>4||c<1)System.out.println("Wrong choice");
        switch(c){
            case 1:
                System.out.println(a+b);
            case 2:
                System.out.println(a-b);
            case 3:
                System.out.println(a*b);
            case 4:
                try{
                    int ans=a/b;
                    System.out.println(ans);
                }
                catch(ArithmeticException e){
                    System.out.println("Arithmatic Exception");
                }
        }
    }
}