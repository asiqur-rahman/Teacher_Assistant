package ui;
import services.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

public class Marking extends JFrame{

    Statement stmt;
    ResultSet rs;
    String query;
    final int left=120,size=20,height=35,weight=250;
    JButton goBack=new JButton("Go Back");

    JLabel idl=new JLabel("ID : ");
    JLabel namel=new JLabel("Name : ");
    JLabel quiz1l=new JLabel("Quiz 1 : ");
    JLabel quiz2l=new JLabel("Quiz 2 :");
    JLabel quiz3l=new JLabel("Quiz 3 :");
    JLabel quiztotall=new JLabel("Quiz Total :");
    JLabel midterml=new JLabel("Mid Term :");
    JLabel finalterml=new JLabel("Final term :");
    JLabel totalMarkl=new JLabel("Total Mark :");

    JTextField id=new JTextField();
    JTextField quiz1=new JTextField("0");
    JTextField quiz2=new JTextField("0");
    JTextField quiz3=new JTextField("0");
    JLabel quiztotal=new JLabel("0");
    JTextField midterm=new JTextField("0");
    JTextField finalterm=new JTextField("0");
    JLabel totalMark=new JLabel("0");
    JTextField name=new JTextField("0");

    JButton details=new JButton("SEE Details");
    JButton update=new JButton("Update");
    JButton calculate=new JButton("Calculate");

    UserService us=new UserService();
    Teacher tea;
    int totalStudent;
    Marking mark;

    public Marking(Teacher tea,String sec){
        this.tea=tea;
        mark=this;
        setTitle("Marking System");
        setSize(500,500);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent e){
                e.getWindow().dispose();
                tea.setVisible(true);
            }
        });

        idl.setBounds(50,20,100,30);
        add(idl);
        idl.setFont(new Font("Serif", Font.BOLD, size));
        id.setBounds(150,20,100,30);
        id.setFont(new Font("Serif", Font.BOLD, size));
        add(id);
        

        namel.setBounds(50,60,100,30);
        namel.setFont(new Font("Serif", Font.BOLD, size));
        add(namel);
        name.setBounds(150,60,300,30);
        name.setFont(new Font("Serif", Font.BOLD, size));
        add(name);
        name.setForeground(new Color(13,102,0));
        

        quiz1l.setBounds(50,100,100,30);
        quiz1l.setFont(new Font("Serif", Font.BOLD, size));
        add(quiz1l);
        quiz1.setBounds(150,100,50,30);
        quiz1.setFont(new Font("Serif", Font.BOLD, size));
        add(quiz1);
        

        quiz2l.setBounds(50,140,100,30);
        quiz2l.setFont(new Font("Serif", Font.BOLD, size));
        add(quiz2l);
        quiz2.setBounds(150,140,50,30);
        quiz2.setFont(new Font("Serif", Font.BOLD, size));
        add(quiz2);
        

        quiz3l.setBounds(50,180,100,30);
        quiz3l.setFont(new Font("Serif", Font.BOLD, size));
        add(quiz3l);
        quiz3.setBounds(150,180,50,30);
        quiz3.setFont(new Font("Serif", Font.BOLD, size));
        add(quiz3);
        

        quiztotall.setBounds(50,220,110,30);
        quiztotall.setFont(new Font("Serif", Font.BOLD, size));
        add(quiztotall);
        quiztotal.setBounds(160,220,50,30);
        quiztotal.setFont(new Font("Serif", Font.BOLD, size));
        add(quiztotal);


        midterml.setBounds(250,140,100,30);
        midterml.setFont(new Font("Serif", Font.BOLD, size));
        add(midterml);
        midterm.setBounds(350,140,50,30);
        midterm.setFont(new Font("Serif", Font.BOLD, size));
        add(midterm);
        

        finalterml.setBounds(250,180,100,30);
        finalterml.setFont(new Font("Serif", Font.BOLD, size));
        add(finalterml);
        finalterm.setBounds(350,180,50,30);
        finalterm.setFont(new Font("Serif", Font.BOLD, size));
        add(finalterm);
        
        totalMarkl.setBounds(250,220,110,30);
        totalMarkl.setFont(new Font("Serif", Font.BOLD, size));
        add(totalMarkl);
        totalMark.setBounds(360,220,50,30);
        totalMark.setFont(new Font("Serif", Font.BOLD, size));
        add(totalMark);

        details.setBounds(left,280,weight,30);
        add(details);
        details.setFont(new Font("Arial", Font.BOLD, 17));
        details.setForeground(new Color(13,102,0));
        details.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
        try{
            stmt=us.getStatement();
            query="SELECT id,name,quiz1,quiz2,quiz3,QuizTotal,midterm,finalterm,totalmark from "+sec+" where id='"+id.getText()+"'";
            rs=stmt.executeQuery(query);
            while (rs.next()) {
                id.setText(rs.getString(1));
                name.setText(rs.getString(2));
                quiz1.setText(rs.getString(3));
                quiz2.setText(rs.getString(4));
                quiz3.setText(rs.getString(5));
                quiztotal.setText(rs.getString(6));
                midterm.setText(rs.getString(7));
                finalterm.setText(rs.getString(8));
                totalMark.setText(rs.getString(9));
                }
            }
        catch (Exception ee) {
            System.out.println("An error occured. " + ee);

        }
    }});

        update.setBounds(left,320,weight,30);
        add(update);
        update.setFont(new Font("Arial", Font.BOLD, 17));
        update.setForeground(new Color(13,102,0));
        update.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
        try{
            System.out.println(quiz1.getText()+quiz2.getText()+quiz3.getText()+midterm.getText()+finalterm.getText());
            stmt=us.getStatement();
            query="UPDATE "+sec+" SET name='"+name.getText()+"',Quiz1="+quiz1.getText()+",quiz2="+quiz2.getText()+",quiz3="+quiz3.getText()+",midterm="+midterm.getText()+",finalterm="+finalterm.getText()+" where id='"+id.getText()+"'";
            stmt.executeUpdate(query);
            stmt=us.getStatement();
            query="SELECT quiz1,quiz2,quiz3,midterm,finalterm from "+sec+" where id='"+id.getText()+"'";
            rs=stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5));
                int a=Integer.parseInt(rs.getString(1));
                int b=Integer.parseInt(rs.getString(2));
                int c=Integer.parseInt(rs.getString(3)),d,f;
                System.out.println(a+b+c);

                d=Integer.parseInt(rs.getString(4));

                if(rs.getString(5)!="")
                f=Integer.parseInt(rs.getString(5));
                else
                f=0;

                float sum;
                if(a<b && a<c){
                    sum=(b+c);
                }
                else if(b<c && b<a){
                    sum=(a+c);
                }
                else
                    sum=(a+b);
                String total1=String.valueOf(sum);
                quiztotal.setText(total1);

                sum=((float)(d*.4)+(float)(f*.6));
                String total2=String.valueOf(sum);
                totalMark.setText(total2);
                System.out.println(a+b+c+d+f);
                }
            query="UPDATE "+sec+" SET quiztotal="+quiztotal.getText()+",totalmark="+totalMark.getText()+" where id='"+id.getText()+"'";
            stmt.executeUpdate(query);
            }
        catch (Exception ee) {
            System.out.println("An error occured. " + ee);
        }
    }});

    //     calculate.setBounds(100,360,120,30);
    //     add(calculate);
    //     calculate.addActionListener(new ActionListener(){
    //         public void actionPerformed(ActionEvent e){
    //     try{
    //         stmt=us.getStatement();
    //         query="SELECT quiz1,quiz2,quiz3 from "+sec+" where id='"+id.getText()+"'";
    //         rs=stmt.executeQuery(query);
    //         while (rs.next()) {
    //             int a=Integer.parseInt(rs.getString(1));
    //             int b=Integer.parseInt(rs.getString(2));
    //             int c=Integer.parseInt(rs.getString(3));
    //             int sum;
    //             if(a<b && a<c){
    //                 sum=(b+c);
    //             }
    //             else if(b<c && b<a){
    //                 sum=(a+c);
    //             }
    //             else
    //                 sum=(a+b);

    //             String total=String.valueOf(sum);
    //             quiztotal.setText(total);
    //             }
    //         query="UPDATE javac SET quiztotal="+quiztotal.getText()+" where id='"+id.getText()+"'";
    //         stmt.executeUpdate(query);
    //         }
    //     catch (Exception ee) {
    //         System.out.println("An error occured. " + ee);
    //     }
    // }});

        goBack.setBounds(left,390,weight,35);
        add(goBack);
        goBack.setForeground(Color.red);
        goBack.setFont(new Font("Serif", Font.BOLD, size));
        goBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mark.dispose();
                tea.setVisible(true);
            }
        });
        
 
    }}