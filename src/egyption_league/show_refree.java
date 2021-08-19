/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egyption_league;

import attributes.refree;
import league.refree_database;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Mohamed Magdy
 */
public class show_refree extends JPanel implements ActionListener {
    JTable table;
    JScrollPane scroll;
    String data[][];
    String header[] = {"Name Of player","height","weight"};
   JLabel  name,height,weight,LTEXT;
   JTextField text_name,text_height,text_weight;
   JButton add, edit, delete, refresh;
   ArrayList<refree>arr=refree_database.get_refree();
   public show_refree()
   {
    this.setLayout(null);
    
        show_table();
        this.setBackground(Color.PINK);
   }
   public void show_table()
   {
   //initialize table
        data = new String[arr.size()][3];
        for (int i = 0; i < arr.size(); i++) {
           
            data[i][0]=arr.get(i).getName();
            data[i][1] = "" + arr.get(i).getHeight();
            data[i][2] = "" + arr.get(i).getWeight();
            

        }
        table = new JTable(data, header);
        scroll = new JScrollPane(table);
        scroll.setBounds(0, 0, 600, 400);
        add(scroll);
        //labels&buttons
       
         name= new JLabel("Name");
       
         height=new JLabel("height");
         weight=new JLabel("weight");
         
        
           LTEXT = new JLabel ("YOU Should Insert name");
          LTEXT.setBounds(610, 2, 200, 10);
         
        name.setBounds(610, 100, 50, 25);
        height.setBounds(610, 140, 50, 25);
        weight.setBounds(610, 180, 50, 25);
       
          
       add(name);add(height);add(weight);add(LTEXT);
           
        text_name = new JTextField();
        text_height = new JTextField("0");
        text_weight = new JTextField("0");
       
     
     
        text_name.setBounds(680, 100, 85, 22);
        text_height.setBounds(680, 140, 85, 22);
        text_weight.setBounds(680, 180, 85, 22);
        
         add(text_name); add(text_height); add(text_weight);

        add = new JButton("Add");
        edit = new JButton("Edit");
        delete = new JButton("Delete");
        refresh = new JButton("Refresh");
       
        
        add.setBounds(650, 300, 100, 30);
        edit.setBounds(650, 340, 100, 30);
        delete.setBounds(650, 380, 100, 30);
        refresh.setBounds(650, 420, 100, 30);
       
        add(add); add(edit); add(delete); add(refresh); 

        add.addActionListener(this);
        edit.addActionListener(this);
        delete.addActionListener(this);
        refresh.addActionListener(this);
        
   
   
   
   }

    @Override
    public void actionPerformed(ActionEvent ae) {
        refree_database re_r= new refree_database();
        if (ae.getSource() == refresh)
        {
        try {
                re_r.refresh_table(table);
                JOptionPane.showMessageDialog(null, "Table is refreshed", "Egyption League.", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException EE) {
                System.out.println(EE.getMessage());
            }
        }
        if (ae.getSource() == add)
        {
        
        try{
        refree_database.insert_refree( text_name.getText(),Integer.parseInt(text_height.getText()),Integer.parseInt(text_weight.getText()));
        re_r.refresh_table(table);
                JOptionPane.showMessageDialog(null, "refree inserted", "Egyption League.", JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException EE) {
                System.out.println(EE.getMessage());
            }
        
        }
        if (ae.getSource() == edit)
        {
        
        try{
        refree_database.update_refree(text_name.getText(),Integer.parseInt(text_height.getText()),Integer.parseInt(text_weight.getText()));
        re_r.refresh_table(table);
                JOptionPane.showMessageDialog(null, "refree updated", "Egyption League.", JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException EE) {
                System.out.println(EE.getMessage());
            }
        
        }
            if (ae.getSource() == delete)
        {
        
        try{
        refree_database.delete_refree(text_name.getText());
        re_r.refresh_table(table);
                JOptionPane.showMessageDialog(null, "refree deleted", "Egyption League.", JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException EE) {
                System.out.println(EE.getMessage());
            }
        
        }
       
    }
    
}
