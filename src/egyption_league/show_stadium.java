/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egyption_league;

import league.stadium_database;
import attributes.stadium;
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
public class show_stadium extends JPanel implements ActionListener {
    JTable table;
    JScrollPane scroll;
    String data[][];
    String header[] = {"Name Of Stadium","Location","Seat Capicty","Name Of Team"};
   JLabel name,location,seat,nameofteam,lsearch,LTEXT;
   JTextField text_name,text_location,text_seat,text_nameofteam,text_search;
   JButton add_stadium, edit_stadium, delete_stadium, refresh,search;
    ArrayList<stadium>arr=stadium_database.get_stadium();
    
    public show_stadium()
    {
    this.setLayout(null);
    
        show_table();
        this.setBackground(Color.MAGENTA);
    }
    public void show_table()
    {
    //initialize table
        data = new String[arr.size()][4];
        for (int i = 0; i < arr.size(); i++) {
            data[i][0] = arr.get(i).getName();
            data[i][1]=arr.get(i).getLocation();
            data[i][2] = "" + arr.get(i).getSeat_capicty();
            data[i][3]=arr.get(i).getName_team();

        }
        table = new JTable(data, header);
        scroll = new JScrollPane(table);
        scroll.setBounds(0, 0, 600, 400);
        add(scroll);
         // label,text field and button
         name= new JLabel("Name");
         location=new JLabel("Location");
         seat=new JLabel("Seat Capicity");
         nameofteam=new JLabel("Team name");
          lsearch = new JLabel("Searching For stadiums By Name Of team");
           LTEXT = new JLabel ("YOU Should Insert Name");
          LTEXT.setBounds(610, 2, 200, 10);
        LTEXT.setForeground(Color.RED);
         
          name.setBounds(610, 60, 50, 25);
       location.setBounds(610, 100, 50, 25);
        seat.setBounds(610, 140, 80, 25);
        nameofteam.setBounds(610, 180, 70, 25);
         lsearch.setBounds(130, 403, 400, 22);
        
        add(name);add(location);add(seat);add(nameofteam);add(lsearch);add(LTEXT);
        
        text_name= new JTextField ();
        text_location= new JTextField ();
        text_seat= new JTextField ("0");
        text_nameofteam= new JTextField ();
        text_search= new JTextField ();
        
         text_name.setBounds(690, 60, 85, 22);
        text_location.setBounds(690, 100, 85, 22);
        text_seat.setBounds(690, 140, 85, 22);
        text_nameofteam.setBounds(690, 180, 85, 22);
        text_search.setBounds(170, 430, 95, 22);
           add(text_name);add(text_location);add(text_seat);add(text_nameofteam);add(text_search);
           add_stadium = new JButton("Add");
        edit_stadium = new JButton("Edit");
        delete_stadium = new JButton("Delete");
        refresh = new JButton("Refresh");
        search = new JButton("Search");
        
         add_stadium.setBounds(650, 300, 100, 30);
        edit_stadium.setBounds(650, 340, 100, 30);
        delete_stadium.setBounds(650, 380, 100, 30);
        refresh.setBounds(650, 420, 100, 30);
        search.setBounds(170, 455, 95, 22);
        add(add_stadium);add(edit_stadium);add(delete_stadium);add(refresh);add(search);
        
        add_stadium.addActionListener(this);
        edit_stadium.addActionListener(this);
        delete_stadium.addActionListener(this);
        refresh.addActionListener(this);
        search.addActionListener(this);

    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        stadium_database re_s= new stadium_database();
        if (ae.getSource() == add_stadium)
        {
        try {
            stadium_database.insert_stadium(text_name.getText(),text_location.getText(),Integer.parseInt(text_seat.getText()), text_nameofteam.getText());
                re_s.refresh_table(table);
                JOptionPane.showMessageDialog(null, "Inserted Stadium", "Egyption League.", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException EE) {
                System.out.println(EE.getMessage());
            }
        }
        if (ae.getSource() == edit_stadium)
        {
        try {
            stadium_database.update_stadium(text_name.getText(),text_location.getText(),Integer.parseInt(text_seat.getText()), text_nameofteam.getText());
                re_s.refresh_table(table);
                JOptionPane.showMessageDialog(null, "Stadium updated", "Egyption League.", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException EE) {
                System.out.println(EE.getMessage());
            }
        }
        if (ae.getSource() == delete_stadium)
        {
        try {
            stadium_database.delete_stadium(text_name.getText());
                re_s.refresh_table(table);
                JOptionPane.showMessageDialog(null, "Stadium deleted", "Egyption League.", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException EE) {
                System.out.println(EE.getMessage());
            }
        }
        if (ae.getSource() == refresh)
        {
        try {
                re_s.refresh_table(table);
                JOptionPane.showMessageDialog(null, "Table is refreshed", "Egyption League.", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException EE) {
                System.out.println(EE.getMessage());
            }
        }
        if (ae.getSource() == search)
        {
        try {
                stadium_database.search_table(table,text_search.getText());
                JOptionPane.showMessageDialog(null, "Done", "Egyption League.", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException EE) {
                System.out.println(EE.getMessage());
            }
        }
    }
    
}
