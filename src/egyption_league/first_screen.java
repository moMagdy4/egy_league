/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egyption_league;

import league.admin_database;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Mohamed Magdy
 */
public class first_screen extends JFrame implements ActionListener {
    JLabel user,pass;
    JTextField user_name;
    JPasswordField password;
    JButton signin,signup;
    image I = new image();
    
    
    public first_screen()
            {
            
           
            }
    public void show_firstt_screen()
    {
      
        // intialize user and password label
        user=new JLabel ("user name");
        pass=new JLabel ("password");
        
         user_name=new JTextField();
        password=new JPasswordField();
        
          signin = new JButton("sign in");
        signup = new JButton("sign up");
        
          // intialize main form
    setTitle("Egyption league");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    setSize(600,600);
        setVisible(true);
        // setLayout(null);
        
        user.setBounds(100, 70, 80, 25);
        pass.setBounds(100, 100, 80, 25);
        
          user_name.setBounds(190, 70, 150, 25);
        password.setBounds(190, 100, 150, 25);
        
         signin.setBounds(120, 140, 80, 20);
        signup.setBounds(210,140,80,20);
        
         user.setBackground(Color.red);
        user.setForeground(Color.yellow);
        pass.setBackground(Color.red);
        pass.setForeground(Color.yellow);
     I. add(user);
       I. add(pass);
       
      I. add(user_name);
      I. add(password);
       
     I.  add(signin);
       I. add(signup);
       add(I);
        signin.addActionListener(this);
        signup.addActionListener(this);
      
      
      
     
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource()==signin)
       {
          
        int i =   admin_database.check_user(user_name.getText(),String.valueOf( password.getPassword()));
           switch (i) {
               case 1:
                   this.dispose();
                   new third_screen().show_third_screen();
                    JOptionPane.showMessageDialog(null,"Hello Admin","Egyption League.",JOptionPane.INFORMATION_MESSAGE);
                   
                   break;
               case 2:
                    JOptionPane.showMessageDialog(null,"Password Is Wrong","Egyption League.",JOptionPane.INFORMATION_MESSAGE);
                   break;
               default:
                    JOptionPane.showMessageDialog(null,"User Is Not Found","Egyption League.",JOptionPane.INFORMATION_MESSAGE);
                   
                           break;
           }
            
            
       }
       if(ae.getSource()==signup)
       {
       this.dispose();
       new second_screen().show_second_screen();
        JOptionPane.showMessageDialog(null,"HELLO!","Egyption League.",JOptionPane.INFORMATION_MESSAGE);
       }
    }
    
}
