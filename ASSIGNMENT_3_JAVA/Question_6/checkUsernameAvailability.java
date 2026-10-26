package Question_6;
import java.util.*;

public class checkUsernameAvailability{
    checkUsernameAvailability(){}
    public void Check_Availability(String u,ArrayList<Account> lis) throws UsernameAlreadyTakenException{
        for(int i=0;i<lis.size();i++){
            Account temp=lis.get(i);
            if(u==temp.get_username())
                throw new UsernameAlreadyTakenException("Username already taken");
        }
    }
}
