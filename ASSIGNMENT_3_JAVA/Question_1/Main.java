package Question_1;
import java.util.*;
class Main {
    static void main(){
        try{
            int result=10/0;
        }
        catch(Exception e){
            System.out.println("ArithmaticOperationError");
        }
        try{
            String n=null;
            int x=n.length();
        }
        catch(Exception e){
            System.out.println("NULL pointer Exception");
        }
        try{
            int[] arr={1,2,3};
            int m=arr[9];
        }
        catch(Exception e){
            System.out.println("Out of bond error");
        }
        try{
            String newstring="abc";
            int s=Integer.parseInt(newstring);
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }
}
