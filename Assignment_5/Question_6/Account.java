package Question_6;

public class Account {
    String username;
    String password;
    int attempts=0;
    public Account(String u,String p){
        username=u;
        password=p;
        attempts=0;
    }
    public String get_username(){
        return username;
    }
    public String get_password(){
        return password;
    }
    public int get_attempts(){
        return attempts;
    }
    public void Appendattempts(Account temp){
        temp.attempts++;
    }
}
