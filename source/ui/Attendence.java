package ui;
import services.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

public class Attendence extends JFrame{

    final int left=120,size=20,height=35,weight=250;
    JButton goBack=new JButton("Go Back");
    Statement stmt;
    Boolean next;
    ResultSet rs;
    String query;
    JLabel today=new JLabel("ID");

    int i=1,fontsize=20;
    JLabel idl=new JLabel("ID");
    JLabel namel=new JLabel("Name");
    JLabel id=new JLabel();
    JLabel name=new JLabel();

    JLabel rolll=new JLabel("Roll");
    JTextField roll=new JTextField();

    JButton attendance=new JButton("Attendance");
    JButton check=new JButton("Check Details");

    UserService us=new UserService();
    Teacher tea;
    int totalStudent;
    Attendence att;

    public Attendence(Teacher tea){
        this.tea=tea;
        att=this;
        setTitle("Attendence");
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

        rolll.setBounds(160,200,80,30);
        rolll.setFont(new Font("Serif", Font.BOLD, 20));
        add(rolll);
        roll.setBounds(240,200,50,30);
        roll.setFont(new Font("Serif", Font.BOLD, 20));
        add(roll);

        idl.setBounds(240,30,80,30);
        idl.setFont(new Font("Serif", Font.BOLD, fontsize));
        add(idl);
        id.setBounds(220,70,100,30);
        id.setFont(new Font("Serif", Font.BOLD, fontsize));
        add(id);
        id.setForeground(new Color(13,102,0));

        namel.setBounds(230,110,80,30);
        namel.setFont(new Font("Serif", Font.BOLD, fontsize));
        add(namel);
        name.setBounds(160,140,200,30);
        name.setFont(new Font("Serif", Font.BOLD, fontsize));
        add(name);
        name.setForeground(new Color(13,102,0));


        String sec=JOptionPane.showInputDialog(null,"Enter course and sec (like: CourseSection)");
        String day=JOptionPane.showInputDialog(null,"Today is Day");
        if(day==null){
            JOptionPane.showMessageDialog(null,"Day Must not Blank !!","Error",JOptionPane.ERROR_MESSAGE);
            att.dispose();
            tea.setVisible(true);
        }
    
    if(!us.dayCreate(sec,day)){
        int x=JOptionPane.showConfirmDialog(null,"This Day Already Created\n\nWant to Continue with this day ?","close",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
    if(x==JOptionPane.YES_OPTION){

        today.setBounds(160,0,200,30);
        add(today);
        today.setText("Attendance for Day "+day);
        today.setFont(new Font("Arial", Font.BOLD, size));
        today.setForeground(new Color(13,102,0));

        check.setBounds(left,250,weight,30);
        add(check);
        check.setFont(new Font("Arial", Font.BOLD, size));
        check.setForeground(new Color(13,102,0));
        check.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String details[] = us.checkDetails(sec,roll.getText());
                if(details[0]==null){
                    id.setText("No data Found");
                    name.setText("No data Found");
                }
                else{
                id.setText(details[0]);
                name.setText(details[1]);
            }
        }
        });
        
        attendance.setBounds(left,300,weight,30);
        add(attendance);
        attendance.setFont(new Font("Arial", Font.BOLD, size));
        attendance.setForeground(new Color(13,102,0));
        attendance.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            String details[] = us.checkDetails(sec,roll.getText());
            id.setText(details[0]);
            name.setText(details[1]);
            us.giveAttendance(sec,day,roll.getText());
        }
        });
    }
    }

        goBack.setBounds(left,390,weight,35);
        add(goBack);
        goBack.setForeground(Color.red);
        goBack.setFont(new Font("Serif", Font.BOLD, size));
        goBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                att.dispose();
                tea.setVisible(true);
            }
        });

    }}