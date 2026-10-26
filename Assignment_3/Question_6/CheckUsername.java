package Question_6;
import java.util.*;

public class CheckUsername {
    public CheckUsername(){}
    public Account Check_Username(String username,ArrayList<Account> lis) throws InvalidUsernameException{
        for(int i=0;i<lis.size();i++){
            Account temp=lis.get(i);
            if(username.equals(temp.get_username())){
                return temp;
            }
        }
        throw new InvalidUsernameException("Username Not Found");
    }
}
