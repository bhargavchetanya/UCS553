package Question_2;

public class Main {
    public static void main(){
        try{
            String s="1";
            int x=Integer.parseInt(s);
            try{
                int y=x/0;
            }
            catch(Exception e){
                System.out.println("Arithmatic Error");
            }
        }
        catch(Exception e){
            System.out.println("NoFormat Exception");
        }
    }
}
