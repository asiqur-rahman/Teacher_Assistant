package ui;
import services.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;

public class Login extends JFrame{

	int code=-1,size=19;
	JTextField username=new JTextField();
	JPasswordField password=new JPasswordField();

	JLabel userl=new JLabel("Your ID");
	JLabel passl=new JLabel("Your Password");

    JLabel lable=new JLabel("Developed by Ashik-Soft");

	JLabel iam=new JLabel("User");
	JRadioButton admin=new JRadioButton("Admin");
    JRadioButton teacher=new JRadioButton("Teacher");
    JRadioButton student=new JRadioButton("Student");
    JRadioButton parent=new JRadioButton("Parent");

	JButton sub=new JButton("Submit");
	JButton fpass=new JButton("Forget Password");
	JButton clr=new JButton("Clear");
	ButtonGroup bg=new ButtonGroup();

    LoginService ls=new LoginService();
    Login log;

    public Login(){
    	log=this;
        //log.getContentPane().setBackground(new Color(153,170,255));
        setTitle("Login Frame");
		setSize(500,500);
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		userl.setBounds(160,65,200,30);
		add(userl);
        userl.setFont(new Font("Arial", Font.BOLD, size)); 
		username.setBounds(100,100,200,30);
		add(username);

        //username.setBackground(new Color(26,0,0));
        username.setFont(new Font("Arial", Font.BOLD, size));
		
		passl.setBounds(130,145,200,30);
		add(passl);
        passl.setFont(new Font("Arial", Font.BOLD, size));
		password.setBounds(100,180,200,30);
		add(password);
        //password.setForeground(Color.white);
        // password.setBackground(new Color(26,0,0));
        password.setFont(new Font("Arial", Font.BOLD, size));
		
        iam.setBounds(345,60,120,30);
        add(iam);
        iam.setForeground(Color.blue);
        iam.setFont(new Font("Arial", Font.BOLD, 17));
		
        bg.add(admin);
        bg.add(teacher);
        bg.add(student);
        bg.add(parent);
        admin.setBounds(320,90,120,30);
        add(admin);
        admin.setForeground(Color.blue);
        admin.setFont(new Font("Arial", Font.BOLD, 17));
        teacher.setBounds(320,120,120,30);
        add(teacher);
        teacher.setForeground(Color.blue);
        teacher.setFont(new Font("Arial", Font.BOLD, 17));
        student.setBounds(320,150,120,30);
        add(student);
        student.setForeground(Color.blue);
        student.setFont(new Font("Arial", Font.BOLD, 17));
        parent.setBounds(320,180,120,30);
        add(parent);
        parent.setForeground(Color.blue);
        parent.setFont(new Font("Arial", Font.BOLD, 17));

		sub.setBounds(100,240,150,30);
		add(sub);
        sub.setFont(new Font("Arial", Font.BOLD, 17));
        sub.setForeground(new Color(13,102,0));
        sub.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(username.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Username Required !!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else if(password.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Password Required !!","Error",JOptionPane.ERROR_MESSAGE);
                }
              
                else{
                    if(admin.isSelected()){
						code=11;
						System.out.println("Admin Selected and code is "+code);
						if(ls.userValidation("admin",username.getText(),password.getText(),code)){
                        JOptionPane.showMessageDialog(null,"Login Successfull !!","Verified",JOptionPane.INFORMATION_MESSAGE);
                        Admin admin=new Admin(log,username.getText());
                        log.setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"                Dear Admin \nUsename or Password does not Match !!","Verification Denied",JOptionPane.ERROR_MESSAGE);
                    }
			        }
			        else if(teacher.isSelected()){
			        	code=22;
			        	System.out.println("Teacher Selected and code is "+code);
			        	if(ls.userValidation("teacher",username.getText(),password.getText(),code)){
                        JOptionPane.showMessageDialog(null,"Login Successfull !!","Verified",JOptionPane.INFORMATION_MESSAGE);
                        Teacher teacher=new Teacher(log,username.getText());
                        log.setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"                Dear Teacher \nUsename or Password does not Match !!","Verification Denied",JOptionPane.ERROR_MESSAGE);
                    }
			    	}
			        else if(student.isSelected()){
			        	code=33;
			        	System.out.println("Student Selected and code is "+code);
			            if(ls.userValidation("student",username.getText(),password.getText(),code)){
                        JOptionPane.showMessageDialog(null,"Login Successfull !!","Verified",JOptionPane.INFORMATION_MESSAGE);
                        Student student=new Student(log,username.getText());
                        log.setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"            Dear Student \nUsename or Password does not Match !! ","Verification Denied",JOptionPane.ERROR_MESSAGE);
                    }
			        }
			        else if(parent.isSelected()){
			        	code=44;
			        	System.out.println("Parent Selected and code is "+code);
			            if(ls.userValidation("parent",username.getText(),password.getText(),code)){
                        JOptionPane.showMessageDialog(null,"Login Successfull !!","Verified",JOptionPane.INFORMATION_MESSAGE);
                        Parent parent=new Parent(log,username.getText());
                        log.setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"                Dear Parent \nUsename or Password does not Match !!","Verification Denied",JOptionPane.ERROR_MESSAGE);
                    }
                }
                }

            }
        });


		clr.setBounds(270,240,150,30);
		add(clr);
        clr.setFont(new Font("Arial", Font.BOLD, 17));
        clr.setForeground(new Color(255,25,25));
		clr.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			username.setText("");
			password.setText("");
		 }
		});

        lable.setBounds(350,420,150,30);
        add(lable);
        lable.setFont(new Font("Arial", Font.BOLD, 10));
    }

    // public static void main(String[] args) {
    //      Splash s=new Splash();
    //     // s.dispose();
    //     Login l=new Login();
    // }
}