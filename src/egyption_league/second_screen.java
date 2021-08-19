/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egyption_league;

import league.admin_database;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Mohamed Magdy
 */
public class second_screen extends JFrame implements ActionListener {
    image ii = new image();
    JLabel user,pass;
    JTextField user_name,password;
    JButton send,back;
    public second_screen()
    {
    
    }
    public void show_second_screen()
    {
        // intialize user and password label
        user=new JLabel("user name");
        pass=new JLabel ("password");
        user.setBounds(10, 50, 80, 25);
        user.setBackground(Color.red);
        user.setForeground(Color.yellow);
        pass.setBounds(10,80,80,25);
        pass.setBackground(Color.red);
        pass.setForeground(Color.yellow);
        ii.add(user);
        ii.add(pass);
        //intialize user, passsword texet field
        user_name=new JTextField();
        password=new JTextField();
        user_name.setBounds(100,50,120,18);
        password.setBounds(100,80,120,18);
       
        ii.add(user_name);
        ii.add(password);
        //intialize buttons
        send=new JButton("send data");
        back = new JButton("back");
        send.setBounds(180,150,110,20);
        back.setBounds(0,0,70,20);
        back.setBackground(Color.red);
        back.setForeground(Color.yellow);
        ii.add(send);
        ii.add(back);
        send.addActionListener(this);
        back.addActionListener(this);
     // intialize main form
    setTitle("SIGN UP");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    setSize(500,500);
        setVisible(true);
       // setLayout(null);
       add(ii);
    
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back)
        {
            this.dispose();
            new first_screen().show_firstt_screen();
        
        }
        if(ae.getSource()==send)
        {
        try
        {
        admin_database.insert_admin(user_name.getText(), password.getText());
         this.dispose();
          new first_screen().show_firstt_screen();
           JOptionPane.showMessageDialog(null,"DONE!","Egyption League.",JOptionPane.INFORMATION_MESSAGE);
        
        }catch(SQLException ee)
        {
        System.out.println(ee.getMessage());
        }
        
        
        }
        
        
    }
    
    
}
