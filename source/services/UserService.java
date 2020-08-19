package services;
import repositories.*;
import java.sql.*;
public class UserService{
    UserRepository userRepository=new UserRepository();

    //---------------ADMIN---------------

    public boolean addNewUser(String table,String id,String username,String password,String code){
        return userRepository.insertTeacherIntoDB(table,id,username,password,code);
    }
    public boolean addStudent(String id,String username,String password){
        return userRepository.addStudent(id,username,password);
    }
    public boolean addCourseStudent(String course,String id,String name,String cgpa){
        return userRepository.addCourseStudent(course,id,name,cgpa);
    }
    public boolean delStudent(String course,String id){
        return userRepository.delStudent(course,id);
    }
    public boolean addNewCourse(String course,String sec){
        return userRepository.addNewCourse(course,sec);
    }
    public boolean delCourse(String course,String sec){
        return userRepository.delCourse(course,sec);
    }
    public boolean deleteUser(String table,String searchBy,String keyword){
        return userRepository.deleteUser(table,searchBy,keyword);
    }
    public boolean searchUser(String table,String searchBy,String keyword){
        return userRepository.searchUser(table,searchBy,keyword);
    }
    public boolean admintoteamsg(String msg){
        return userRepository.admintoteamsg(msg);
    }
    public boolean admintoteamsg(String id,String msg){
        return userRepository.admintoteamsg(id,msg);
    }
    public boolean admintostumsg(String msg,String sec){
        return userRepository.admintostumsg(msg,sec);
    }
    public boolean admintostumsg(String id,String msg,String sec){
        return userRepository.admintostumsg(id,msg,sec);
    }

    //---------------Teacher---------------

    public Statement getStatement(){
          return userRepository.getStatement();
    }
    public String attendance(String sec){
          return userRepository.attendance(sec);   
    }
    public int totalStudent(String sec){
        return userRepository.totalStudent(sec);
    }
    public String receiveMsg(String username){
        return userRepository.receiveMsg(username);
    }
    public boolean teachertostumsg(String msg,String sec){
        return userRepository.teachertostumsg(msg,sec);
    }
    public boolean teachertostumsg(String id,String msg,String sec){
        return userRepository.teachertostumsg(id,msg,sec);
    }

    public String[] receiveQuestion(String sec){
        return userRepository.receiveQuestion(sec);
    }

    public String[] receiveReply(String id,String sec){
        return userRepository.receiveReply(id,sec);     // receive parent reply
    }

    public String[] receiveStuReply(String id,String sec){
        return userRepository.receiveStuReply(id,sec);     // receive parent reply
    }

    public boolean teachertopamsg(String msg,String sec){
        return userRepository.teachertopamsg(msg,sec);
    }
    public boolean teachertopamsg(String id,String msg,String sec){
        return userRepository.teachertopamsg(id,msg,sec);
    }
    public boolean dayCreate(String sec,String day){
        return userRepository.dayCreate(sec,day);
    }
    public String[] checkDetails(String sec,String id){
        return userRepository.checkDetails(sec,id);
    }
    public boolean giveAttendance(String sec,String day,String id){
        return userRepository.giveAttendance(sec,day,id);
    }

    //---------------------Parent------------------------------

    public String teachermsg(String sec,String id){
        return userRepository.teachermsg(sec,id);
    }
    public boolean sendteamsg(String sec,String id,String msg){
    	 return userRepository.sendteamsg(sec,id,msg);
    }
    public boolean sendteareply(String sec,String id,String msg){
    	 return userRepository.sendteareply(sec,id,msg);
    }
    public String[] seeDetails(String sec,String id){
        return userRepository.seeDetails(sec,id);
    }
    public boolean answerQuestion(String[] id){
        return userRepository.answerQuestion(id);
    }

    //------------------------Student-------------------------------------

    public String[] seeteareply(String id,String sec){
        return userRepository.seeteareply(id,sec);
    }
    public String adtostumsg(String sec,String id){
        return userRepository.adtostumsg(sec,id);
    }
    public String teatostumsg(String sec,String id){
        return userRepository.teatostumsg(sec,id);
    }
    public boolean teatostureply(String sec,String id,String msg){
        return userRepository.teatostureply(sec,id,msg);
    }
}