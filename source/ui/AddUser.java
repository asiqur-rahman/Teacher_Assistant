package ui;
import services.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AddUser extends JFrame{

    final int left=120,size=20,height=35,weight=250;
    JButton goBack=new JButton("Go Back");

    JButton jb=new JButton("Add User");
    JButton del=new JButton("Delete User");
    JTextField id=new JTextField();
    JTextField username=new JTextField();
    JPasswordField password=new JPasswordField();
    JLabel jl0=new JLabel("ID");
    JLabel jl1=new JLabel("Username");
    JLabel jl2=new JLabel("Password");
    UserService us=new UserService();
    Admin ad;

    public AddUser(Admin ad,String table,String code){
        this.ad=ad;
        setTitle("Adding "+table);
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

        jl0.setBounds(80,50,100,30);
        add(jl0);
        jl0.setFont(new Font("Serif", Font.BOLD, size));
        id.setBounds(200,50,120,30);
        add(id);
        id.setFont(new Font("Serif", Font.BOLD, size));


        jl1.setBounds(80,100,100,30);
        add(jl1);
        jl1.setFont(new Font("Serif", Font.BOLD, size));
        username.setBounds(200,100,120,30);
        add(username);
        username.setFont(new Font("Serif", Font.BOLD, size));

        jl2.setBounds(80,150,100,30);
        add(jl2);
        jl2.setFont(new Font("Serif", Font.BOLD, size));
        password.setBounds(200,150,120,30);
        add(password);
        password.setFont(new Font("Serif", Font.BOLD, size));

        
        jb.setBounds(left,200,weight,35);
        add(jb);
        jb.setForeground(new Color(13,102,0));
        jb.setFont(new Font("Serif", Font.BOLD, size));
        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(username.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Username Required !!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else if(password.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Password Required !!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else if(id.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"ID Required !!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    if(us.addNewUser(table,id.getText(),username.getText(),password.getText(),code)){
                        JOptionPane.showMessageDialog(null,table+" Added Successfully !!","Verified",JOptionPane.INFORMATION_MESSAGE);
                        ad.setVisible(true);
                        setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,table+" Adding Failed !!","Verification Denied",JOptionPane.ERROR_MESSAGE);
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
                DeleteUser du=new DeleteUser(ad,table);
                dispose();
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