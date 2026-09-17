package Question_5;
import java.util.*;



public class Main{
    public static Account[] lis=new Account[2];
    public static void checkAccountNo(int x)throws InvalidAccountNo{
        int count=0;
        for(int i=0;i<lis.length;i++){
            if(x!=lis[i].number)count++;
            else break;
        }
        if(count==2)throw new InvalidAccountNo("Invalid Account Number");
    }
    public static void checkbal(Account a,int amount) throws InsufficientBalanceException{
        if(a.bal<amount){
            throw new InsufficientBalanceException("Insufficient Balance");
        }
    }
    public static void checkAmount(int amount) throws InvalidAmountException{
        if(amount<=0) throw new InvalidAmountException("Invalid Amount");
    }

    public static void main(){
        lis[0]= new Account(5000,1);
        lis[1]=new Account(3000,2);
        int sa=0;
        int ra=0;
        int amount=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Sender's Account Number ->");
        sa=sc.nextInt();
        try{
            checkAccountNo(sa);
        }
        catch(InvalidAccountNo e){
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Enter Reciever's's Account Number ->");
        ra=sc.nextInt();
        try{
            checkAccountNo(ra);
        }
        catch(InvalidAccountNo e){
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Enter Amount");
        amount=sc.nextInt();
        try{
            checkAmount(amount);
        }
        catch(InvalidAmountException e){
            System.out.println("Message");
            return;
        }
        try{
            Account a=null;
            for(int i=0;i<lis.length;i++){
                if(sa==lis[i].number)a=lis[i];
            }
            checkbal(a, amount);
        }
        catch(InsufficientBalanceException e){
            System.out.println(e.getMessage());
            return;
        }
        Account l=null;
        Account m=null;
        for(int i=0;i<lis.length;i++){
            if(lis[i].number==sa)l=lis[i];
            if(lis[i].number==ra)m=lis[i];
        }
        l.bal-=amount;
        m.bal+=amount;
        System.out.println("Amount = "+amount);
        System.out.println("Balance of account number (sender) : "+l.number+" is "+l.bal);
        System.out.println("Balance of account number (reciever) : "+m.number+" is "+m.bal);
    }
}