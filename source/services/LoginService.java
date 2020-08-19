package services;
import repositories.*;
public class LoginService{
    UserRepository userRepository=new UserRepository();
    public boolean userValidation(String tablename,String username,String password,int code){
    	System.out.println(tablename);
        return userRepository.getUserValidity(tablename,username,password,code);
    }
}