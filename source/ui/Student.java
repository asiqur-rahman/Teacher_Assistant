package ui;
import services.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Student extends JFrame{

	int code=-1;
	final int left=120,size=20,height=35,weight=250;

	JButton adminMsg=new JButton("See Admin msg");
	JButton teacherMsg=new JButton("See Teacher msg");
	JButton studenta=new JButton("Answer the question");

	JButton seedetails=new JButton("See Course Details");
	JButton logout=new JButton("Log out");

	UserService us=new UserService();
	Login log;
	Student stu;

	Student(Login log,String id){
		this.log=log;
		stu=this;
		setTitle("Student ID: "+id);
		setSize(500,500);
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
			int x=JOptionPane.showConfirmDialog(null,"Are you sure about Log out","close",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
			if(x==JOptionPane.YES_OPTION){
				e.getWindow().dispose();
				Login log=new Login();
			}
		}
		});

		adminMsg.setBounds(left,30,weight,height);
		add(adminMsg);
		adminMsg.setForeground(new Color(13,102,0));
		adminMsg.setFont(new Font("Serif", Font.BOLD, size));
		adminMsg.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String sec=JOptionPane.showInputDialog(null,"Enter Section");
				String msg=us.adtostumsg(sec,id);
				if(msg!=null){
				JOptionPane.showMessageDialog(null,msg);
				}
				else
					JOptionPane.showMessageDialog(null,"OPPS , Inbox is Empty ");

			}	
		});

		teacherMsg.setBounds(left,70,weight,height);
		add(teacherMsg);
		teacherMsg.setForeground(new Color(13,102,0));
		teacherMsg.setFont(new Font("Serif", Font.BOLD, size));
		teacherMsg.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String sec=JOptionPane.showInputDialog(null,"Enter Section");
				String msg=us.teatostumsg(sec,id);
				if(msg!=null){
				JOptionPane.showMessageDialog(null,msg);
				}
				else
					JOptionPane.showMessageDialog(null,"OPPS , Inbox is Empty ");

				if(msg!=null){
				us.receiveQuestion(sec);
				int x=JOptionPane.showConfirmDialog(null,"Want To Reply Now ?","close",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if(x==JOptionPane.YES_OPTION){
				String reply=JOptionPane.showInputDialog(null,"Enter Reply");
				if(us.teatostureply(sec,id,reply)){
				JOptionPane.showMessageDialog(null,"Reply Sent Succesfully ");
				}
				else
				JOptionPane.showMessageDialog(null,"OPPS , Inbox is Empty ");
			}}
			}	
		});

		seedetails.setBounds(left,150,weight,height);
		add(seedetails);
		seedetails.setForeground(new Color(13,102,0));
		seedetails.setFont(new Font("Serif", Font.BOLD, size));
		seedetails.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String sec=JOptionPane.showInputDialog(null,"Enter Section");
				if(sec!=""){
					SeeDetails seeDetails=new SeeDetails(sec,id);
				}
				else{
					JOptionPane.showMessageDialog(null,"Course name Must not Blank");
				}		
		 }
		});

		logout.setBounds(left,390,weight,height);
		add(logout);
		logout.setForeground(Color.red);
		logout.setFont(new Font("Serif", Font.BOLD, size));
		logout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int x=JOptionPane.showConfirmDialog(null,"Are you sure about Log out","close",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
			if(x==JOptionPane.YES_OPTION){
				dispose();
				log.setVisible(true);
			}
	        }
		});	
	
	}
}