package ui;
import services.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Parent extends JFrame{

	final int left=120,size=20,height=35,weight=250;

	JButton teachermsg=new JButton("See Teacher msg");
	JButton parentq=new JButton("Ask question");
	JButton seeteareply=new JButton("See Teacher Reply");

	JButton seedetails=new JButton("See Course Details");

	JButton logout=new JButton("Log out");


	UserService us=new UserService();
	Parent pa;
	Login log;

	Parent(Login log, String id){
		pa=this;
		this.log=log;
		setTitle("Parent ID : "+id);
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

		teachermsg.setBounds(left,40,weight,height);
		add(teachermsg);
		teachermsg.setForeground(new Color(13,102,0));
		teachermsg.setFont(new Font("Serif", Font.BOLD, size));
		teachermsg.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String sec=JOptionPane.showInputDialog(null,"Enter Section");
				String id=JOptionPane.showInputDialog(null,"Enter Your Child ID");
				String msg=us.teachermsg(sec,id);
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
				us.sendteareply(sec,id,reply);
			}}
			}	
		});

		parentq.setBounds(left,90,weight,height);
		add(parentq);
		parentq.setForeground(new Color(13,102,0));
		parentq.setFont(new Font("Serif", Font.BOLD, size));
		parentq.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String sec=JOptionPane.showInputDialog(null,"Enter Section");
				String id=JOptionPane.showInputDialog(null,"Enter Your Child ID");
				String msg=JOptionPane.showInputDialog(null,"Enter Message");
				if(us.sendteamsg(sec,id,msg))
					JOptionPane.showMessageDialog(null,"Message Sent Successfully  ");
				else
					JOptionPane.showMessageDialog(null,"Not Found !!");
		 }
		});

		seeteareply.setBounds(left,140,weight,height);
		add(seeteareply);
		seeteareply.setForeground(new Color(13,102,0));
		seeteareply.setFont(new Font("Serif", Font.BOLD, size));
		seeteareply.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String sec=JOptionPane.showInputDialog(null,"Enter Section");
				String id=JOptionPane.showInputDialog(null,"Enter Your Child ID");
				String[] msg=us.seeteareply(id,sec);

				if(msg[1]!=null){
				JOptionPane.showMessageDialog(null,"Q : "+msg[0]+"\n\n"+"A : "+msg[1]);
				}
				else
					JOptionPane.showMessageDialog(null,"OPPS , No Reply");

		 }
		});

		seedetails.setBounds(left,190,weight,height);
		add(seedetails);
		seedetails.setForeground(new Color(13,102,0));
		seedetails.setFont(new Font("Serif", Font.BOLD, size));
		seedetails.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String sec=JOptionPane.showInputDialog(null,"Enter Section");
				String id=JOptionPane.showInputDialog(null,"Enter Your Child ID");
				SeeDetails seeDetails=new SeeDetails(sec,id);
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