package ui;
import services.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCourse extends JFrame{

    final int left=120,size=20,height=35,weight=250;
    JButton jb=new JButton("Add Course");
    JButton delCourse=new JButton("Delete Course");
    JTextField course=new JTextField();
    JTextField sec=new JTextField();
    JPasswordField password=new JPasswordField();
    JLabel coursel=new JLabel("Course Name");
    JLabel secl=new JLabel("Section");
    JButton goBack=new JButton("Go Back");
    UserService us=new UserService();
    Admin ad;

    public AddCourse(Admin ad){
        this.ad=ad;
        setTitle("Adding Course");
        setSize(500,500);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent e){
            int x=JOptionPane.showConfirmDialog(null,"Are you sure about Log out","close",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
            if(x==JOptionPane.YES_OPTION){
                e.getWindow().dispose();
                ad.setVisible(true);
            }
        }
        });
        coursel.setBounds(170,65,200,30);
        add(coursel);
        coursel.setFont(new Font("Arial", Font.BOLD, size)); 
        course.setBounds(140,100,200,30);
        add(course);
        course.setFont(new Font("Arial", Font.BOLD, size));
        
        secl.setBounds(200,145,200,30);
        add(secl);
        secl.setFont(new Font("Arial", Font.BOLD, size));
        sec.setBounds(140,180,200,30);
        add(sec);
        sec.setFont(new Font("Arial", Font.BOLD, size));

        
        jb.setBounds(140,240,200,35);
        add(jb);
        jb.setFont(new Font("Arial", Font.BOLD, size));
        jb.setForeground(new Color(13,102,0));
        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(course.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Username Required !!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else if(sec.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Password Required !!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    int x=JOptionPane.showConfirmDialog(null,"Are you Sure to Create  [ "+course.getText()+""+sec.getText()+" ]  Course ","close",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                    if(x==JOptionPane.YES_OPTION){
                    if(us.addNewCourse(course.getText(),sec.getText())){
                        JOptionPane.showMessageDialog(null,"Adding Successfull !!","Verified",JOptionPane.INFORMATION_MESSAGE);
                        ad.setVisible(true);
                        setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Previously Added !!","Verification Denied",JOptionPane.ERROR_MESSAGE);
                    }
                }
                }
                
            }
        });
        delCourse.setBounds(140,285,200,35);
        add(delCourse);
        delCourse.setFont(new Font("Arial", Font.BOLD, size));
        delCourse.setForeground(new Color(13,102,0));
        delCourse.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(course.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Course Name Required !!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else if(sec.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Section Required !!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    int x=JOptionPane.showConfirmDialog(null,"Are you Sure to Delete [ "+course.getText()+""+sec.getText()+" ]  Course ","close",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                    if(x==JOptionPane.YES_OPTION){
                    if(us.delCourse(course.getText(),sec.getText())){
                        JOptionPane.showMessageDialog(null,"Delete Successfull !!","Verified",JOptionPane.INFORMATION_MESSAGE);
                        ad.setVisible(true);
                        setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"No Section Found!!","Verification Denied",JOptionPane.ERROR_MESSAGE);
                    }
                }
                }
                
            }
        });

        goBack.setBounds(left,390,weight,35);
        add(goBack);
        goBack.setForeground(Color.red);
        goBack.setFont(new Font("Serif", Font.BOLD, size));
        goBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                ad.setVisible(true);
            }
        });

        
    }

}