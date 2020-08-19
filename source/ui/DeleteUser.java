package ui;
import services.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class DeleteUser extends JFrame{

    final int left=120,size=18,height=33,weight=250;
    JButton goBack=new JButton("Go Back");

    String text;
    JLabel jta=new JLabel("Please Select");
    JTextField jtf=new JTextField();
    JButton search=new JButton("Search");
    JButton del=new JButton("Delete");

    JLabel searchBy=new JLabel("Search by");
    JRadioButton id=new JRadioButton("ID");
    JRadioButton name=new JRadioButton("Name");


    ButtonGroup bg=new ButtonGroup();
    UserService us=new UserService();
    Admin ad;

    public DeleteUser(Admin ad,String table){
        this.ad=ad;
        setTitle("Deleting "+table);
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

        searchBy.setBounds(345,60,120,30);
        add(searchBy);
        searchBy.setForeground(Color.blue);
        searchBy.setFont(new Font("Arial", Font.BOLD, 17));
        
        bg.add(id);
        bg.add(name);
        id.setBounds(340,90,120,30);
        id.setForeground(Color.blue);
        add(id);
        id.setFont(new Font("Arial", Font.BOLD, 17));

        name.setBounds(340,120,120,30);
        add(name);
        name.setForeground(Color.blue);
        name.setFont(new Font("Arial", Font.BOLD, 17));

        jta.setBounds(80,100,100,30);
        add(jta);
        jta.setForeground(new Color(13,102,0));
        jta.setFont(new Font("Serif", Font.BOLD, size)); 

        jtf.setBounds(200,100,120,30);
        add(jtf);
        jtf.setForeground(new Color(13,102,0));
        jtf.setFont(new Font("Serif", Font.BOLD, size));


        search.setBounds(100,240,150,30);
        add(search);
        search.setForeground(new Color(13,102,0));
        search.setFont(new Font("Serif", Font.BOLD, size)); 
        search.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setText();
                jta.setText(text);
                if(jtf.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Username Required !!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    if(us.searchUser(table,text,jtf.getText())){
                        JOptionPane.showMessageDialog(null,table+" User Found !!","Verified",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,table+" User Not Found !!","Verification Denied",JOptionPane.ERROR_MESSAGE);
                    }
                }
                
            }
        });

        del.setBounds(270,240,150,30);
        add(del);
        del.setForeground(new Color(255,25,25));
        del.setFont(new Font("Serif", Font.BOLD, size)); 
        del.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                setText();
                jta.setText(text);
                if(jtf.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Username Required !!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    if(us.deleteUser(table,text,jtf.getText())){
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
     void setText(){
            if(id.isSelected()){ 
                text="id";
            }
            else if(name.isSelected()){
                text="name";
            }
            }

}