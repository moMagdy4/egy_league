/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egyption_league;

import league.player_database;
import league.team_database;
import attributes.matches;
import attributes.team;
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
public class show_teames extends JPanel implements ActionListener {

    JTable table;
    JScrollPane scroll;
    String data[][];
    String header[] = {"Name Of Team", "Points"};
    JLabel teams,points,Lsearch,LTEXT;
    JTextField text_teams,text_points,text_search;
     JButton add_team, edit_team, delete_team, refresh,search;
     

    ArrayList<team> arr = team_database.get_team();

    public show_teames() {
        this.setLayout(null);
        show_table();
         this.setBackground(Color.MAGENTA);

    }

    public void show_table() {
        //initialize table
        data = new String[arr.size()][2];
        for (int i = 0; i < arr.size(); i++) {
            data[i][0] = arr.get(i).getName_of_team();
            data[i][1] = "" + arr.get(i).getPoints();

        }
        table = new JTable(data, header);
        scroll = new JScrollPane(table);
        scroll.setBounds(0, 0, 600, 400);
        add(scroll);
        // label,text field and button
        teams=new JLabel("Teams");
        points=new JLabel("Points");
        Lsearch = new JLabel("Searching For Players By Name Of team");
         LTEXT = new JLabel ("YOU Should Insert Name");
          LTEXT.setBounds(610, 2, 200, 10);
       
        teams.setBounds(610, 100, 50, 25);
        points.setBounds(610, 140, 50, 25); 
        Lsearch.setBounds(130, 403, 400, 22);
        add(teams);add(points);add(Lsearch);add(LTEXT);
        
        text_teams= new JTextField ();
        text_points= new JTextField("0");
         text_search= new JTextField ();
        
         text_teams.setBounds(680, 100, 85, 22);
        text_points.setBounds(680, 140, 85, 22);
         text_search.setBounds(170, 430, 95, 22);
        add(text_teams);add(text_points);add(text_search);
        
        add_team = new JButton("Add");
        edit_team = new JButton("Edit");
        delete_team = new JButton("Delete");
        refresh = new JButton("Refresh");
        search = new JButton("Search");
        
         add_team.setBounds(650, 300, 100, 30);
        edit_team.setBounds(650, 340, 100, 30);
        delete_team.setBounds(650, 380, 100, 30);
        refresh.setBounds(650, 420, 100, 30);
        search.setBounds(170, 455, 95, 22);
        add(add_team);add(edit_team);add(delete_team);add(refresh);add(search);
        
        add_team.addActionListener(this);
        edit_team.addActionListener(this);
        delete_team.addActionListener(this);
        refresh.addActionListener(this);
        search.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        team_database re_te= new team_database();
        if (ae.getSource() == add_team)
        {
              
            try{
               
            team_database.insert_team(text_teams.getText(),Integer.parseInt(text_points.getText()));
             re_te.refresh_table(table);
            JOptionPane.showMessageDialog(null, "Inserted Team", "Egyption League.", JOptionPane.INFORMATION_MESSAGE);
            }catch (SQLException ex)
            {
             System.out.println(ex.getMessage());
            }
        
        }
        if (ae.getSource() == edit_team)
        {
             try{
            team_database.update_team(text_teams.getText(),Integer.parseInt(text_points.getText()));
              re_te.refresh_table(table);
            JOptionPane.showMessageDialog(null, "Edited Team", "Egyption League.", JOptionPane.INFORMATION_MESSAGE);
            }catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        
        }
        if (ae.getSource() == delete_team)
        {
          try{
            team_database.delete_team(text_teams.getText());
              re_te.refresh_table(table);
            JOptionPane.showMessageDialog(null, "Team is Deleted", "Egyption League.", JOptionPane.INFORMATION_MESSAGE);
            }catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        if (ae.getSource() == refresh)
        {
           try {
                re_te.refresh_table(table);
                JOptionPane.showMessageDialog(null, "Table is refreshed", "Egyption League.", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException EE) {
                System.out.println(EE.getMessage());
            }
        
        }
         if (ae.getSource() == search)
         {
         try {
            
             player_database.search_table(table,text_search.getText());
                JOptionPane.showMessageDialog(null, "Done!", "Egyption League.", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException EE) {
                System.out.println(EE.getMessage());
            }
         }

    }
}
