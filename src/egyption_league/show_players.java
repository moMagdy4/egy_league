/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egyption_league;

import attributes.player;
import league.player_database;
import java.awt.Color;
import java.awt.Component;
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
public class show_players  extends JPanel implements ActionListener {
     JTable table;
    JScrollPane scroll;
    String data[][];
    String header[] = {"ID","Name Of player","height","weight","position","Name Of Team"};
   JLabel id, name,height,weight,position,nameofteam,lsearch,LTEXT;
   JTextField text_id,text_name,text_height,text_weight,text_position,text_nameofteam,text_search;
   JButton add, edit, delete, refresh,search;
   ArrayList<player>arr=player_database.get_player();
   public show_players()
   {
    this.setLayout(null);
    
        show_table();
        this.setBackground(Color.MAGENTA);
   }
   public void show_table()
   {
   //initialize table
        data = new String[arr.size()][6];
        for (int i = 0; i < arr.size(); i++) {
            data[i][0] = ""+arr.get(i).getPlayeid();
            data[i][1]=arr.get(i).getName();
            data[i][2] = "" + arr.get(i).getHeight();
            data[i][3] = "" + arr.get(i).getWeight();
            data[i][4] =  arr.get(i).getPosition();
            data[i][5]=arr.get(i).getNameofteam();

        }
        table = new JTable(data, header);
        scroll = new JScrollPane(table);
        scroll.setBounds(0, 0, 600, 400);
        add(scroll);
        //labels&buttons
        id=new JLabel("player id");
         name= new JLabel("Name");
         position=new JLabel("position");
         height=new JLabel("height");
         weight=new JLabel("weight");
         nameofteam=new JLabel("Team name");
          lsearch = new JLabel("Searching For players By Name Of team");
           LTEXT = new JLabel ("YOU Should Insert id");
          LTEXT.setBounds(610, 2, 200, 10);
          id.setBounds(610, 60, 50, 25);
        name.setBounds(610, 100, 50, 25);
        height.setBounds(610, 140, 50, 25);
        weight.setBounds(610, 180, 50, 25);
        position.setBounds(610, 220, 50, 25);
        nameofteam.setBounds(610, 260, 70, 25);
        lsearch.setBounds(130, 403, 400, 22);
          
          add(id);add(name);add(height);add(weight);add(position);add(nameofteam);add(LTEXT);add(lsearch);
            text_id = new JTextField();
        text_name = new JTextField();
        text_height = new JTextField("0");
        text_weight = new JTextField("0");
        text_position = new JTextField();
        text_nameofteam = new JTextField();
     text_search = new JTextField();
     
      text_id.setBounds(680, 60, 85, 22);
        text_name.setBounds(680, 100, 85, 22);
        text_height.setBounds(680, 140, 85, 22);
        text_weight.setBounds(680, 180, 85, 22);
        text_position.setBounds(680, 220, 85, 22);
        text_nameofteam.setBounds(680, 260, 85, 22);
        text_search.setBounds(170, 430, 95, 22);
        add(text_id); add(text_name); add(text_height); add(text_weight); add(text_position); add(text_nameofteam);  add(text_search);

        add = new JButton("Add");
        edit = new JButton("Edit");
        delete = new JButton("Delete");
        refresh = new JButton("Refresh");
        search = new JButton("Search");
        
        add.setBounds(650, 300, 100, 30);
        edit.setBounds(650, 340, 100, 30);
        delete.setBounds(650, 380, 100, 30);
        refresh.setBounds(650, 420, 100, 30);
        search.setBounds(170, 455, 95, 22);
        add(add); add(edit); add(delete); add(refresh); add(search);

        add.addActionListener(this);
        edit.addActionListener(this);
        delete.addActionListener(this);
        refresh.addActionListener(this);
        search.addActionListener(this);
   }

    @Override
    public void actionPerformed(ActionEvent ae) {
        player_database re_p=new player_database();
       if (ae.getSource() == refresh)
        {
        try {
               re_p.refresh_table(table);
                JOptionPane.showMessageDialog(null, "Table is refreshed", "Egyption League.", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException EE) {
                System.out.println(EE.getMessage());
            }
        }
        if (ae.getSource() == add)
        {
        
        try{
        player_database.insert_player(Integer.parseInt(text_id.getText()), text_name.getText(),Integer.parseInt(text_height.getText()),Integer.parseInt(text_weight.getText()), text_position.getText(),text_nameofteam.getText());
        re_p.refresh_table(table);
                JOptionPane.showMessageDialog(null, "player inserted", "Egyption League.", JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException EE) {
                System.out.println(EE.getMessage());
            }
        
        }
          if (ae.getSource() == edit)
        {
        
        try{
        player_database.update_player(Integer.parseInt(text_id.getText()), text_name.getText(),Integer.parseInt(text_height.getText()),Integer.parseInt(text_weight.getText()), text_position.getText(),text_nameofteam.getText());
        re_p.refresh_table(table);
                JOptionPane.showMessageDialog(null, "player updated", "Egyption League.", JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException EE) {
                System.out.println(EE.getMessage());
            }
        
        }
            if (ae.getSource() == delete)
        {
        
        try{
        player_database.delete_player(Integer.parseInt(text_id.getText()));
        re_p.refresh_table(table);
                JOptionPane.showMessageDialog(null, "player deleted", "Egyption League.", JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException EE) {
                System.out.println(EE.getMessage());
            }
        
        }
              if (ae.getSource() == search)
        {
        
        try{
        player_database.search_table(table,text_search.getText());
       
                JOptionPane.showMessageDialog(null, "Done", "Egyption League.", JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException EE) {
                System.out.println(EE.getMessage());
            }
        
        }
    }
    
}
