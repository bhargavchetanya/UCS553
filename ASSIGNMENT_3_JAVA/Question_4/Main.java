package Question_4;
import java.util.*;

class Custom extends Exception{
    public Custom(String Message){
        super(Message);
    }
}

public class Main{

    public static void check(int s,int m) throws Custom{
        if((s>100||s<0)||(m>100||m<0)){
            throw new Custom("Error");
        }
        System.out.println("Marks :"+ s+ " "+ m);
    }
    
    public static void main(){
        int Science=0;
        int Maths=0;
        Scanner sc=new Scanner(System.in);
        Science=sc.nextInt();
        Maths=sc.nextInt();
        try{
            check(Maths,Science);
        }
        catch(Custom e){
            System.out.println(e.getMessage());
        }
        int total=Science+Maths;
        System.out.println("Total -> "+total);
        int Percentage=(total/2);
        System.out.println("Percentage -> "+Percentage);
        int m=(Percentage/10);
        m=m*10;
        switch(m){
            case 90:
                System.out.println("A+");
                break;
            case 80:
                System.out.println("A");
                break;
            case 70:
                System.out.println("B+");
                break;
            case 60:
                System.out.println("B");
                break;
            case 50:
                System.out.println("C+");
                break;
            case 40:
                System.out.println("C");
                break;
            case 30:
                System.out.println("D");
                break;
            case 20:
                System.out.println("F");
                break;
            case 10:
                System.out.println("F");
                break;
            case 0:
                System.out.println("F");
                break;
        }
    }
}