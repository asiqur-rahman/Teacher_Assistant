package repositories;
import java.sql.*;
public class UserRepository{
    Connection con;
    Statement stmt;
    ResultSet rs;
    String query;
    int i=0;

    public UserRepository(){
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aiub","root","");
            stmt=con.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public boolean getUserValidity(String tablename,String username,String password,int code){
        try{
            query="SELECT * FROM "+tablename+" WHERE id='"+username+"' AND password='"+password+"' AND code='"+code+"'";
            rs=stmt.executeQuery(query);
            if(rs.next()){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }

    }

//--------------------------Admin---------------------------------------------

    public boolean insertTeacherIntoDB(String table,String id,String username,String password,String code){
        try{
            query="INSERT INTO "+table+" (code,id,name,password) VALUES("+code+",'"+id+"','"+username+"','"+password+"')";
            int i=stmt.executeUpdate(query);
                return true;
            
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }

    }

    public boolean addStudent(String id,String username,String password){
        try{
            query="INSERT INTO student (code,id,name,password) VALUES(33,'"+id+"','"+username+"','"+password+"')";
            int i=stmt.executeUpdate(query);
                return true;
            
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }

    }

    public boolean addNewCourse(String course,String sec){
        try{
            query="CREATE TABLE "+course+""+sec+" (no int(11) AUTO_INCREMENT,id varchar(15),Name varchar(30),cgpa float NOT NULL,AdminMsg varchar(1000) DEFAULT NULL,TeacherMsg varchar(1000) DEFAULT NULL,Quiz1 float DEFAULT (0),Quiz2 float DEFAULT (0),Quiz3 float DEFAULT (0),QuizTotal float DEFAULT (0),Midterm float DEFAULT (0),Finalterm float DEFAULT (0),TotalMark float DEFAULT (0),ParentQ varchar(1000) DEFAULT NULL,TeacherA varchar(1000) DEFAULT NULL,StudentA varchar(1000) DEFAULT NULL,TeacherQ varchar(1000) DEFAULT NULL,ParentA varchar(1000) DEFAULT NULL,PRIMARY KEY (no));";
            stmt.executeUpdate(query);
            return true;
            
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }

    }

    public boolean delStudent(String course,String id){
        try{
            query="DELETE FROM "+course+" WHERE id='"+id+"';";
            int i=stmt.executeUpdate(query);
                return true;
            
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }

    }

    public boolean delCourse(String course,String sec){
        try{
            query="DROP TABLE "+course+""+sec+";";
            stmt.executeUpdate(query);
            return true;
            
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }

    }

    public boolean addCourseStudent(String course,String id,String name,String cgpa){
        try{
            System.out.println(course+id+name);
            query="INSERT INTO "+course+" (id,name,cgpa) VALUES ('"+id+"','"+name+"',"+cgpa+")";
            stmt.executeUpdate(query);
            return true;
            
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }


    public boolean deleteUser(String table,String searchBy,String keyword){
        try{
            query="DELETE FROM "+table+" where "+searchBy+"='"+keyword+"'";
            stmt.executeUpdate(query);
                return true;
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }

    }

    public boolean searchUser(String table,String searchBy,String keyword){
        try{
            query="SELECT * from "+table+" where "+searchBy+"='"+keyword+"'";
            rs=stmt.executeQuery(query);
            if(rs.next()){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    public boolean admintoteamsg(String msg){
        System.out.println(msg);
        try{
            query="UPDATE teacher SET message='"+msg+"'";
            int i=stmt.executeUpdate(query);
            if(i==1){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean admintoteamsg(String id,String msg){
        try{
            query="UPDATE teacher SET message='"+msg+"' where id='"+id+"'";
            int i=stmt.executeUpdate(query);
            if(i==1){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean admintostumsg(String msg,String sec){
        System.out.println(msg);
        try{
            query="UPDATE "+sec+" SET AdminMsg='"+msg+"'";
            int i=stmt.executeUpdate(query);
            if(i==1){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean admintostumsg(String id,String msg,String sec){
        try{
            query="UPDATE "+sec+" SET AdminMsg='"+msg+"' where id='"+id+"'";
            int i=stmt.executeUpdate(query);
            if(i==1){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    //----------------------------------------------

    public boolean teachertostumsg(String msg,String sec){
        System.out.println(msg);
        try{
            query="UPDATE "+sec+" SET teacherMsg='"+msg+"'";
            int i=stmt.executeUpdate(query);
            if(i==1){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean teachertostumsg(String id,String msg,String sec){
        try{
            query="UPDATE "+sec+" SET teacherMsg='"+msg+"' where id='"+id+"'";
            int i=stmt.executeUpdate(query);
            if(i==1){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    public String receiveMsg(String username){
        try{
           query="SELECT message FROM teacher WHERE id='"+username+"'";
            rs=stmt.executeQuery(query);
            if(rs.next()){
                return rs.getString(1);
            }
            else{
                return "No Msg";
            }
        }
        catch(Exception e){
            System.out.println(e);
            return "No Msg";
        }
    }

    public boolean teachertopamsg(String msg,String sec){
        System.out.println(msg);
        try{
            query="UPDATE "+sec+" SET teacherq='"+msg+"'";
            int i=stmt.executeUpdate(query);
            if(i==1){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean teachertopamsg(String id,String msg,String sec){
        try{
            query="UPDATE "+sec+" SET teacherq='"+msg+"' where id='"+id+"'";
            int i=stmt.executeUpdate(query);
            return true;
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    public String[] receiveQuestion(String sec){
        String array[]=new String[3];
        try{
           query="SELECT id,parentq FROM "+sec+"";
            rs=stmt.executeQuery(query);
            while(rs.next()){
                if(rs.getString(2)!=null){
                    System.out.println(rs.getString(1)+"  "+rs.getString(2));
                array[0]=rs.getString(1);  // ---------save id
                array[1]=rs.getString(2);  // -------save msg
                array[2]=sec;
            }
        }
                return array;  //--------------return msg
        }
        catch(Exception e){
            System.out.println(e);
            return array;
        }
    }

    public String[] receiveReply(String id,String sec){
        String array[]=new String[2];
        try{
           query="SELECT teacherq,parenta FROM "+sec+" where id='"+id+"'";
            rs=stmt.executeQuery(query);
            while(rs.next()){
                if(rs.getString(2)!=null){
                    System.out.println(rs.getString(1)+"  "+rs.getString(2));

                array[0]=rs.getString(1);  // ---------save teacher question
                array[1]=rs.getString(2);  // -------save parent answer
            }
        }
                return array;  //--------------return msg
        }
        catch(Exception e){
            System.out.println(e);
            return array;
        }
    }

    public String[] receiveStuReply(String id,String sec){
        String array[]=new String[2];
        try{
           query="SELECT teachermsg,studenta FROM "+sec+" where id='"+id+"'";
            rs=stmt.executeQuery(query);
            while(rs.next()){
                if(rs.getString(2)!=null){
                    System.out.println(rs.getString(1)+"  "+rs.getString(2));

                array[0]=rs.getString(1);  // ---------save teacher question
                array[1]=rs.getString(2);  // -------save parent answer
            }
        }
                return array;  //--------------return msg
        }
        catch(Exception e){
            System.out.println(e);
            return array;
        }
    }

    public boolean answerQuestion(String[] id){

        try{               //sec                   //msg                 //id
            query="UPDATE "+id[2]+" SET teachera='"+id[1]+"' where id='"+id[0]+"'";
            stmt.executeUpdate(query);
            query="UPDATE "+id[2]+" SET parentq=NULL where id='"+id[0]+"'";
            int i=stmt.executeUpdate(query);
            if(i==1){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    //-------------------------------------------------

    public int totalStudent(String sec){
        try{
            System.out.println(sec);
            query="SELECT Count(*) from "+sec+"";
            rs=stmt.executeQuery(query);
            while (rs.next()) {
            i=Integer.parseInt(rs.getString(1));
            System.out.println(i);
            return i;
            }
            return i;
        }
        catch (Exception e) {
            System.out.println("An error occured. " + e);
            return i;
        }
    }

    public Statement getStatement(){
        return this.stmt;
    }

    public String attendance(String sec){
        int i=totalStudent(sec),j=1;
        System.out.println(i);
        String details[][] = new String[i][2];
        try{
            query="SELECT id,name from "+sec+"";
            rs=stmt.executeQuery(query);
            while (rs.next()) {
                for(int k=1; k<=2; k++){
                    System.out.println(rs.getString(k));
                    //details[j][k]=rs.getString(k);
                }
                j++;
            } 
            return null;
        }
        catch (Exception e) {
            System.out.println("An error occured. " + e);
            return null;
        }
    }


    public boolean dayCreate(String sec,String day){
        try{
            query="ALTER TABLE "+sec+" ADD day"+day+" int(1) default (0)";
            int i=stmt.executeUpdate(query);
            if(i==1){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    public String[] checkDetails(String sec,String id){
        String name[]=new String[2];
        try{
           query="SELECT id,name FROM "+sec+" WHERE no="+id+"";
            rs=stmt.executeQuery(query);
            while (rs.next()) {
                name[0]=rs.getString(1);
                name[1]=rs.getString(2);
                return name;
                }
                return name;
            }
        catch(Exception e){
            System.out.println(e);
            return name;
        }
    }

    public boolean giveAttendance(String sec,String day,String id){
        try{
            query="UPDATE "+sec+" SET day"+day+"=1 where no='"+id+"'";
            int i=stmt.executeUpdate(query);
            if(i==1){
                System.out.println("Take Attendence");
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    //--------------------------------------------------------
        public String teachermsg(String sec,String id){
        try{
           query="SELECT teacherq FROM "+sec+" WHERE id='"+id+"'";
            rs=stmt.executeQuery(query);
            if(rs.next()){
                return rs.getString(1);
            }
            else{
                return "No Msg";
            }
        }
        catch(Exception e){
            System.out.println(e);
            return "No Msg";
        }
    }

    public boolean sendteamsg(String sec,String id,String msg){
        try{
            query="UPDATE "+sec+" SET parentq='"+msg+"' where id='"+id+"'";
            int i=stmt.executeUpdate(query);
            if(i==1){
                System.out.println("Message sent");
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean sendteareply(String sec,String id,String msg){
        try{
            query="UPDATE "+sec+" SET parenta='"+msg+"' where id='"+id+"'";
            int i=stmt.executeUpdate(query);
            if(i==1){
                System.out.println("Message sent");
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

     public String[] seeDetails(String sec,String id){
        String name[]=new String[11];
        try{
           query="SELECT id,name,cgpa,quiz1,quiz2,quiz3,quiztotal,midterm,finalterm,totalmark FROM "+sec+" WHERE id="+id+"";
            rs=stmt.executeQuery(query);
            while (rs.next()) {
                name[0]=rs.getString(1);
                name[1]=rs.getString(2);
                name[2]=rs.getString(3);
                name[3]=rs.getString(4);
                name[4]=rs.getString(5);
                name[5]=rs.getString(6);
                name[6]=rs.getString(7);
                name[7]=rs.getString(8);
                name[8]=rs.getString(9);
                name[9]=rs.getString(10);
                return name;
                }
                return name;
            }
        catch(Exception e){
            System.out.println(e);
            return name;
        }
    }
    //--------------------------------------------------------------------------------------
    public String[] seeteareply(String id,String sec){
        String array[]=new String[2];
        try{
           query="SELECT parentq,teachera FROM "+sec+" where id='"+id+"'";
            rs=stmt.executeQuery(query);
            while(rs.next()){
                if(rs.getString(2)!=null){
                    System.out.println(rs.getString(1)+"  "+rs.getString(2));

                array[0]=rs.getString(1);  // ---------save teacher question
                array[1]=rs.getString(2);  // -------save parent answer
            }
        }
                return array;  //--------------return msg
        }
        catch(Exception e){
            System.out.println(e);
            return array;
        }
    }

    public String teatostumsg(String sec,String id){
        try{
           query="SELECT teachermsg FROM "+sec+" WHERE id='"+id+"'";
            rs=stmt.executeQuery(query);
            if(rs.next()){
                return rs.getString(1);
            }
            else{
                return "No Msg";
            }
        }
        catch(Exception e){
            System.out.println(e);
            return "No Msg";
        }
    }

    public String adtostumsg(String sec,String id){
        try{
           query="SELECT adminmsg FROM "+sec+" WHERE id='"+id+"'";
            rs=stmt.executeQuery(query);
            if(rs.next()){
                return rs.getString(1);
            }
            else{
                return "No Msg";
            }
        }
        catch(Exception e){
            System.out.println(e);
            return "No Msg";
        }
    }

    public boolean teatostureply(String sec,String id,String msg){
        try{
            query="UPDATE "+sec+" SET studenta='"+msg+"' where id='"+id+"'";
            int i=stmt.executeUpdate(query);
            if(i==1){
                System.out.println("Message sent");
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
}