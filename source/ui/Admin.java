package ui;
import services.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Admin extends JFrame{

	final int left=120,size=18,height=33,weight=250;

	JButton addSection=new JButton("Another Course");
	JButton addCourseStudent=new JButton("Course Student");

	JButton addteacher=new JButton("Teacher");
	JButton teamsg=new JButton("Send Message to Teacher");

	JButton addStudent=new JButton("Student");
	JButton stumsg=new JButton("Send Message to Students");

	JButton parent=new JButton("Parents Section");

	JButton logout=new JButton("Log out");

	ButtonGroup bg=new ButtonGroup();
	UserService us=new UserService();
	Admin ad;
	Login log;

	Admin(Login log,String id){
		ad=this;
		this.log=log;
		setTitle("Admin ID : "+id);
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
				log.setVisible(true);
			}
		}
		});

		addSection.setBounds(left,30,weight,height);
		add(addSection);
		addSection.setForeground(new Color(13,102,0));
		addSection.setFont(new Font("Serif", Font.BOLD, size));	
		addSection.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddCourse ac=new AddCourse(ad);
				ad.setVisible(false);
			}});

		addCourseStudent.setBounds(left,70,weight,height);
		add(addCourseStudent);
		addCourseStudent.setForeground(new Color(13,102,0));
		addCourseStudent.setFont(new Font("Serif", Font.BOLD, size));	
		addCourseStudent.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddCourseStudent ac=new AddCourseStudent(ad);
				ad.setVisible(false);
			}});

		addteacher.setBounds(left,140,weight,height);
		add(addteacher);
		addteacher.setForeground(new Color(13,102,0));
		addteacher.setFont(new Font("Serif", Font.BOLD, size));	
		addteacher.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddUser au=new AddUser(ad,"teacher","22");
				ad.setVisible(false);

			}});
		teamsg.setBounds(left,180,weight,height);
		add(teamsg);
		teamsg.setForeground(new Color(13,102,0));
		teamsg.setFont(new Font("Serif", Font.BOLD, size));	
		teamsg.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			int x=JOptionPane.showConfirmDialog(null,"Are you want to send Indivitual Message","close",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
			if(x==JOptionPane.NO_OPTION){
				// e.getWindow().dispose();
				// Login log=new Login();
				String msg=JOptionPane.showInputDialog(null,"Enter Message");
				System.out.println(msg);
				us.admintoteamsg(msg);
			}

			if(x==JOptionPane.YES_OPTION){
				// e.getWindow().dispose();
				// Login log=new Login();
				String id=JOptionPane.showInputDialog(null,"Enter ID");
				String msg=JOptionPane.showInputDialog(null,"Enter Message");
				us.admintoteamsg(id,msg);
			}
			}});
		

//---------------------------------------------------------------------------------------
		addStudent.setBounds(left,250,weight,height);
		add(addStudent);
		addStudent.setForeground(new Color(13,102,0));
		addStudent.setFont(new Font("Serif", Font.BOLD, size));	
		addStudent.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddUser as=new AddUser(ad,"student","33");
				ad.setVisible(false);

			}});
		stumsg.setBounds(left,290,weight,height);
		add(stumsg);
		stumsg.setForeground(new Color(13,102,0));
		stumsg.setFont(new Font("Serif", Font.BOLD, size));	
		stumsg.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			int x=JOptionPane.showConfirmDialog(null,"Are you want to send Indivitual Message","close",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
			if(x==JOptionPane.NO_OPTION){
				String sec=JOptionPane.showInputDialog(null,"Enter Section");
				String msg=JOptionPane.showInputDialog(null,"Enter Message");
				us.admintostumsg(msg,sec);
			}

			if(x==JOptionPane.YES_OPTION){
				String sec=JOptionPane.showInputDialog(null,"Enter Section");
				String id=JOptionPane.showInputDialog(null,"Enter ID");
				String msg=JOptionPane.showInputDialog(null,"Enter Message");
				us.admintostumsg(id,msg,sec);
			}
			}});
		
		
		parent.setBounds(left,350,weight,height);
		add(parent);
		parent.setForeground(new Color(13,102,0));
		parent.setFont(new Font("Serif", Font.BOLD, size));	
		parent.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddParent du=new AddParent(ad);
				ad.setVisible(false);
			}});

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
	        }}
		});	
		
	}
}