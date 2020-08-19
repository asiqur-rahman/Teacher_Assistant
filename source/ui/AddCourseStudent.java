package ui;
import services.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AddCourseStudent extends JFrame{

    final int left=120,size=20,height=35,weight=250;
    JButton goBack=new JButton("Go Back");

    JButton jb=new JButton("Add Student");
    JButton del=new JButton("Delete Student");
    JTextField id=new JTextField();
    JTextField name=new JTextField();
    JTextField cgpa=new JTextField();
    JLabel jl0=new JLabel("id");
    JLabel jl1=new JLabel("name");
    JLabel jl2=new JLabel("cgpa");
    UserService us=new UserService();
    Admin ad;

    public AddCourseStudent(Admin ad){
        this.ad=ad;
        setTitle("Adding User");
        setSize(500,500);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent e){
                e.getWindow().dispose();
                ad.setVisible(true);
            }
        });

        String course=JOptionPane.showInputDialog(null,"Enter The Course Name :");

        jl0.setBounds(80,50,100,30);
        add(jl0);
        jl0.setFont(new Font("Serif", Font.BOLD, size));
        id.setBounds(200,50,120,30);
        add(id);
        id.setFont(new Font("Serif", Font.BOLD, size));


        jl1.setBounds(80,100,100,30);
        add(jl1);
        jl1.setFont(new Font("Serif", Font.BOLD, size));
        name.setBounds(200,100,120,30);
        add(name);
        name.setFont(new Font("Serif", Font.BOLD, size));

        jl2.setBounds(80,150,100,30);
        add(jl2);
        jl2.setFont(new Font("Serif", Font.BOLD, size));
        cgpa.setBounds(200,150,120,30);
        add(cgpa);
        cgpa.setFont(new Font("Serif", Font.BOLD, size));

        
        jb.setBounds(left,200,weight,35);
        add(jb);
        jb.setForeground(new Color(13,102,0));
        jb.setFont(new Font("Serif", Font.BOLD, size));
        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(id.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"ID Required !!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else if(name.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Name Required !!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    if(us.addCourseStudent(course,id.getText(),name.getText(),cgpa.getText())){
                        JOptionPane.showMessageDialog(null,"Adding Successfull !!","Verified",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Adding Failed !!","Verification Denied",JOptionPane.ERROR_MESSAGE);
                    }
                }
                
            }
        });

        del.setBounds(left,240,weight,35);
        add(del);
        del.setForeground(new Color(13,102,0));
        del.setFont(new Font("Serif", Font.BOLD, size));
        del.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(id.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"ID Required !!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    if(us.delStudent(course,id.getText())){
                        JOptionPane.showMessageDialog(null,"Delete Successfull !!","Verified",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Delete Failed !!","Verification Denied",JOptionPane.ERROR_MESSAGE);
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