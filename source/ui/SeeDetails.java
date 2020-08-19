package ui;
import services.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SeeDetails extends JFrame{

    final int left=120,size=20,height=35,weight=250;

	JLabel idl=new JLabel("ID: ");
    JLabel namel=new JLabel("Name: ");
    JLabel cgpal=new JLabel("CGPA: ");
    JLabel quiz1l=new JLabel("Quiz 1: ");
    JLabel quiz2l=new JLabel("Quiz 2: ");
    JLabel quiz3l=new JLabel("Quiz 3: ");
    JLabel quiztotall=new JLabel("Quiz Total:");
    JLabel midterml=new JLabel("Mid term: ");
    JLabel finalterml=new JLabel("Final term: ");
    JLabel totalMarkl=new JLabel("Total Mark: ");

    JLabel id=new JLabel();
    JLabel name=new JLabel();
    JLabel cgpa=new JLabel();
    JLabel quiz1=new JLabel();
    JLabel quiz2=new JLabel();
    JLabel quiz3=new JLabel();
    JLabel quiztotal=new JLabel();
    JLabel midterm=new JLabel();
    JLabel finalterm=new JLabel();
    JLabel totalMark=new JLabel();

    JButton goBack=new JButton("Go Back");

    UserService us=new UserService();

	SeeDetails(String sec, String idd){

		setTitle("SeeDetails");
		setSize(450,450);
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
				e.getWindow().dispose();
			}
		});
		

		idl.setBounds(50,20,100,30);
        add(idl);
        idl.setFont(new Font("Serif", Font.BOLD, size));
        id.setBounds(150,20,100,30);
        id.setFont(new Font("Serif", Font.BOLD, size));
        add(id);
        id.setForeground(new Color(13,102,0));
        

        namel.setBounds(50,60,100,30);
        namel.setFont(new Font("Serif", Font.BOLD, size));
        add(namel);
        name.setBounds(150,60,200,30);
        name.setFont(new Font("Serif", Font.BOLD, size));
        add(name);
        name.setForeground(new Color(13,102,0));
        

        quiz1l.setBounds(50,100,100,30);
        quiz1l.setFont(new Font("Serif", Font.BOLD, size));
        add(quiz1l);
        quiz1.setBounds(150,100,100,30);
        quiz1.setFont(new Font("Serif", Font.BOLD, size));
        add(quiz1);
        

        quiz2l.setBounds(50,140,100,30);
        quiz2l.setFont(new Font("Serif", Font.BOLD, size));
        add(quiz2l);
        quiz2.setBounds(150,140,100,30);
        quiz2.setFont(new Font("Serif", Font.BOLD, size));
        add(quiz2);
        

        quiz3l.setBounds(50,180,100,30);
        quiz3l.setFont(new Font("Serif", Font.BOLD, size));
        add(quiz3l);
        quiz3.setBounds(150,180,100,30);
        quiz3.setFont(new Font("Serif", Font.BOLD, size));
        add(quiz3);
        

        quiztotall.setBounds(50,220,150,30);
        quiztotall.setFont(new Font("Serif", Font.BOLD, size));
        add(quiztotall);
        quiztotal.setBounds(170,220,100,30);
        quiztotal.setFont(new Font("Serif", Font.BOLD, size));
        add(quiztotal);
        

        cgpal.setBounds(250,20,100,30);
        cgpal.setFont(new Font("Serif", Font.BOLD, size));
        add(cgpal);
        cgpa.setBounds(350,20,100,30);
        cgpa.setFont(new Font("Serif", Font.BOLD, size));
        add(cgpa);
        cgpa.setForeground(new Color(13,102,0));


        midterml.setBounds(250,140,100,30);
        midterml.setFont(new Font("Serif", Font.BOLD, size));
        add(midterml);
        midterm.setBounds(350,140,100,30);
        midterm.setFont(new Font("Serif", Font.BOLD, size));
        add(midterm);
        

        finalterml.setBounds(250,180,100,30);
        finalterml.setFont(new Font("Serif", Font.BOLD, size));
        add(finalterml);
        finalterm.setBounds(350,180,100,30);
        finalterm.setFont(new Font("Serif", Font.BOLD, size));
        add(finalterm);
        
        totalMarkl.setBounds(250,220,150,30);
        totalMarkl.setFont(new Font("Serif", Font.BOLD, size));
        add(totalMarkl);
        totalMark.setBounds(370,220,100,30);
        totalMark.setFont(new Font("Serif", Font.BOLD, size));
        add(totalMark);


		String details[]=us.seeDetails(sec,idd);
        
        id.setText(details[0]);
		name.setText(details[1]);
		cgpa.setText(details[2]);
		quiz1.setText(details[3]);
		quiz2.setText(details[4]);
		quiz3.setText(details[5]);
		quiztotal.setText(details[6]);
		midterm.setText(details[7]);
		finalterm.setText(details[8]);
		totalMark.setText(details[9]);

        goBack.setBounds(75,310,weight,35);
        add(goBack);
        goBack.setForeground(new Color(255,0,0));
        goBack.setFont(new Font("Serif", Font.BOLD, size));
        goBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });

	}
}