package Question_6;
import java.util.*;

public class Main {

    public static void main(){
        int choice=0;
        ArrayList<Account> lis=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("Enter choice");
            System.out.println("1 -> Make Account");
            System.out.println("2 -> Login");
            System.out.println("3 -> Exit");
            choice=sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Enter username -> ");
                    String u=sc.nextLine();
                    checkUsernameAvailability obj=new checkUsernameAvailability();
                    try{
                        obj.Check_Availability(u, lis);
                        System.out.println("Username Available...");
                        System.out.println("Enter Password ->");
                        String p=sc.nextLine();
                        lis.add(new Account(u,p));
                        System.out.println("Account Created...");
                    }
                    catch(UsernameAlreadyTakenException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    String username;
                    String password;
                    System.out.println("Enter Username -> ");
                    username=sc.nextLine();
                    try{
                        CheckUsername obj1=new CheckUsername();
                        Account temp=obj1.Check_Username(username,lis);
                        while(true){
                            if(temp.attempts>=5){
                                System.out.println("Password Attempts Reached...");
                                System.out.println("Contact Admin...");
                                break;
                            }
                            System.out.println("Enter Password -> ");
                            password=sc.nextLine();
                            CheckPassword obj2=new CheckPassword();
                            try{
                                obj2.Check_password(temp, password);
                                System.out.println("Correct Password");
                            }
                            catch(InvalidPasswordException e){
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                        catch(InvalidUsernameException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                    case 3:
                        System.out.println("Exiting...");
                        sc.close();
                        return;

                default:System.out.println("Wrong Choice");
            }
        }
    }
}
