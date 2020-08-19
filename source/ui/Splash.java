package ui;
import services.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;

public class Splash extends JFrame{

  JLabel welcome1=new JLabel();
  JLabel welcome2=new JLabel();
  JLabel welcome3=new JLabel();
  JLabel welcome4=new JLabel();
  JLabel welcome5=new JLabel();
  JLabel loading=new JLabel();
  JLabel welcomeMsg=new JLabel("Application is Loading. Please wait . . ");
  JLabel welcomeMsg1=new JLabel();
  JLabel lable=new JLabel("Developed by Ashik-Soft");
  JProgressBar jb=new JProgressBar();

  public Splash()
  {
    // setTitle("Login Frame");
    setSize(1000,500);
    setLayout(null);
    setVisible(true);
    setLocationRelativeTo(null);
    // setDefaultCloseOperation(EXIT_ON_CLOSE);

    welcome1.setBounds(100,100,190,40);
    add(welcome1);
    welcome1.setFont(new Font("Arial", Font.BOLD, 40));
    welcome1.setForeground(new Color(13,102,0));

    welcome2.setBounds(290,100,60,40);
    add(welcome2);
    welcome2.setFont(new Font("Arial", Font.BOLD, 40));
    welcome2.setForeground(new Color(13,102,0));

    welcome3.setBounds(335,100,170,40);
    add(welcome3);
    welcome3.setFont(new Font("Arial", Font.BOLD, 40));
    welcome3.setForeground(new Color(13,102,0));

    welcome4.setBounds(500,100,190,40);
    add(welcome4);
    welcome4.setFont(new Font("Arial", Font.BOLD, 40));
    welcome4.setForeground(new Color(13,102,0));

    welcome5.setBounds(690,100,220,40);
    add(welcome5);
    welcome5.setFont(new Font("Arial", Font.BOLD, 40));
    welcome5.setForeground(new Color(13,102,0));

    loading.setBounds(460,200,90,40);
    add(loading);
    loading.setFont(new Font("Arial", Font.BOLD, 30));
    loading.setForeground(new Color(13,102,0));

    jb.setBounds(30,260,920,20);
    add(jb);
    // jb.setFont(new Font("Arial", Font.BOLD, 30));
    // jb.setForeground(new Color(13,102,0));

    welcomeMsg.setBounds(340,310,600,30);
    add(welcomeMsg);
    welcomeMsg.setFont(new Font("Arial", Font.BOLD, 20));
    welcomeMsg.setForeground(new Color(13,102,0));

    welcomeMsg1.setBounds(700,310,60,30);
    add(welcomeMsg1);
    welcomeMsg1.setFont(new Font("Arial", Font.BOLD, 20));
    welcomeMsg1.setForeground(new Color(13,102,0));

    lable.setBounds(850,420,150,30);
    add(lable);
    lable.setFont(new Font("Arial", Font.BOLD, 10));

    try{
      for(int i=0; i<=100; i++){
      Thread.sleep(8);
      loading.setText(i+"%");
      jb.setValue(i);
      if(i==20)
        welcome1.setText("Welcome");
      if(i==40)
        welcome2.setText("to");
      if(i==60)
        welcome3.setText("Teacher");
      if(i==80)
        welcome4.setText("Assistant");
      if(i==100)
        welcome5.setText("Application");
      if(i%4==0)
        welcomeMsg1.setText(". . . .");
      if(i%3==0)
        welcomeMsg1.setText("");
      
     }
    }catch(Exception e){

    }
    try{
    Thread.sleep(300);
  }
  catch(Exception e){}

    Login l=new Login();
    dispose();
}
    }