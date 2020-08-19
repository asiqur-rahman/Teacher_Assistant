package ui;
import services.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Teacher extends JFrame{

	final int left=120,size=20,height=35,weight=250;

	JButton atten=new JButton("Attendence");
	JButton marks=new JButton("Marks");
	JButton logout=new JButton("Log out");
	JButton indimsg=new JButton("Send Msg to Student");
	JButton checkmsg=new JButton("Check Admin Messgae");
	JButton checkStuReply=new JButton("Check Students Reply");


	JButton indimsgpa=new JButton("Send Msg to Parent");
	JButton checkques=new JButton("Check Recent Questions");
	JButton checkPaReply=new JButton("Check Parents Reply");

	UserService us=new UserService();
	Login log;
	Teacher tea;
	public String username;

	Teacher(Login log,String name){
		this.log=log;
		tea=this;
		this.username=name;
		setTitle("Teacher ID: "+name);
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

		atten.setBounds(left,30,weight,height);
		add(atten);
		atten.setForeground(new Color(13,102,0));
		atten.setFont(new Font("Serif", Font.BOLD, size));
		atten.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tea.setVisible(false);
				Attendence att=new Attendence(tea);
			}
		});
		marks.setBounds(left,70,weight,height);
		add(marks);	
		marks.setForeground(new Color(13,102,0));
		marks.setFont(new Font("Serif", Font.BOLD, size));	
		marks.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String course=JOptionPane.showInputDialog(null,"Enter course and sec (like: CourseSection)");
				int i=us.totalStudent(course);
				if(i!=0){
				Marking mark=new Marking(tea,course);
				tea.setVisible(false);
			}
			else
				JOptionPane.showMessageDialog(null,"Course Not Found !!","Error",JOptionPane.ERROR_MESSAGE);
		 }
		});

		indimsg.setBounds(left,110,weight,height);
		add(indimsg);
		indimsg.setForeground(new Color(13,102,0));
		indimsg.setFont(new Font("Serif", Font.BOLD, size));
		indimsg.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int x=JOptionPane.showConfirmDialog(null,"Want to send Indivitual Message ?","close",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if(x==JOptionPane.YES_OPTION){
				String sec=JOptionPane.showInputDialog(null,"Enter Section");
				String id=JOptionPane.showInputDialog(null,"Enter ID");
				String msg=JOptionPane.showInputDialog(null,"Enter Message");
				if(us.teachertostumsg(id,msg,sec))
					JOptionPane.showMessageDialog(null,"Message Sent Successfully  ");
				else
					JOptionPane.showMessageDialog(null,"Not Found !!");

		 }
		 else{
		 		String sec=JOptionPane.showInputDialog(null,"Enter Section");
				String msg=JOptionPane.showInputDialog(null,"Enter Message");
				if(us.teachertostumsg(msg,sec))
					JOptionPane.showMessageDialog(null,"Message Sent Successfully  ");
				else
					JOptionPane.showMessageDialog(null,"Not Found !!");

		 }}
		});
		checkStuReply.setBounds(left,150,weight,height);
		add(checkStuReply);
		checkStuReply.setForeground(new Color(13,102,0));
		checkStuReply.setFont(new Font("Serif", Font.BOLD, size));
		checkStuReply.addActionListener(new ActionListener(){       // Any Parent reply to the teacher message
			public void actionPerformed(ActionEvent e){

				String sec=JOptionPane.showInputDialog(null,"Enter Section");
				String id=JOptionPane.showInputDialog(null,"Enter ID");

				String[] msg=us.receiveStuReply(id,sec);

				if(msg[1]!=null){
				JOptionPane.showMessageDialog(null,"Q : "+msg[0]+"\n\n"+"A : "+msg[1]);
				}
				else
					JOptionPane.showMessageDialog(null,"OPPS , No Reply");
			}
		});	

		checkmsg.setBounds(left,190,weight,height);
		add(checkmsg);
		checkmsg.setForeground(new Color(13,102,0));
		checkmsg.setFont(new Font("Serif", Font.BOLD, size));
		checkmsg.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				String msg=us.receiveMsg(username);
				JOptionPane.showMessageDialog(null,msg);
		 }
		});

		indimsgpa.setBounds(left,270,weight,height);
		add(indimsgpa);
		indimsgpa.setForeground(new Color(13,102,0));
		indimsgpa.setFont(new Font("Serif", Font.BOLD, size));
		indimsgpa.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int x=JOptionPane.showConfirmDialog(null,"Want to send Indivitual Message ?","close",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if(x==JOptionPane.YES_OPTION){
				String sec=JOptionPane.showInputDialog(null,"Enter Section");
				String id=JOptionPane.showInputDialog(null,"Enter ID");
				String msg=JOptionPane.showInputDialog(null,"Enter Message");

				if(us.teachertopamsg(id,msg,sec))
					JOptionPane.showMessageDialog(null,"Message Sent Successfully  ");
				else
					JOptionPane.showMessageDialog(null,"Not Found !!");
	        }
	        else{
	        	String sec=JOptionPane.showInputDialog(null,"Enter Section");
				String msg=JOptionPane.showInputDialog(null,"Enter Message");
				
				if(us.teachertopamsg(msg,sec))
					JOptionPane.showMessageDialog(null,"Message Sent Successfully  ");
				else
					JOptionPane.showMessageDialog(null,"Not Found !!");
	        
	    }}
		});	


		checkques.setBounds(left,310,weight,height);
		add(checkques);
		checkques.setForeground(new Color(13,102,0));
		checkques.setFont(new Font("Serif", Font.BOLD, size));   // Is there any parent question available
		checkques.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String sec=JOptionPane.showInputDialog(null,"Enter Course name to check Inbox");
				String[] msg=us.receiveQuestion(sec);
				if(msg[1]!=null){
				JOptionPane.showMessageDialog(null,msg[1]);
				}
				else
					JOptionPane.showMessageDialog(null,"OPPS , Inbox is Empty ");
				if(msg[1]!=null){
				us.receiveQuestion(sec);
				int x=JOptionPane.showConfirmDialog(null,"Want To Reply Now ?","close",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if(x==JOptionPane.YES_OPTION){
				String reply=JOptionPane.showInputDialog(null,"Enter Reply");
				msg[1]=reply;
				if(us.answerQuestion(msg))
					JOptionPane.showMessageDialog(null,"Reply Send Successfully");
				else
					JOptionPane.showMessageDialog(null,"Not Send !!");
			}}

	        }
		});	

		checkPaReply.setBounds(left,350,weight,height);
		add(checkPaReply);
		checkPaReply.setForeground(new Color(13,102,0));
		checkPaReply.setFont(new Font("Serif", Font.BOLD, size));
		checkPaReply.addActionListener(new ActionListener(){       // Any Parent reply to the teacher message
			public void actionPerformed(ActionEvent e){

				String sec=JOptionPane.showInputDialog(null,"Enter Section");
				String id=JOptionPane.showInputDialog(null,"Enter ID");

				String[] msg=us.receiveReply(id,sec);

				if(msg[1]!=null){
				JOptionPane.showMessageDialog(null,"Q : "+msg[0]+"\n\n"+"A : "+msg[1]);
				}
				else
					JOptionPane.showMessageDialog(null,"OPPS , No Reply");
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