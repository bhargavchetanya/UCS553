package Question_6;

public class CheckPassword {
    public CheckPassword(){}
    public void Check_password(Account a,String Password) throws InvalidPasswordException{
        if(!Password.equals(a.get_password())){
            a.Appendattempts(a);
            int x=5-a.get_attempts();
            System.out.println("Remaining Attempts = "+ x);
            throw new InvalidPasswordException("Wrong Password...");
        }
        return;
    }
}
