/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egyption_league;

import league.matches_database;
import attributes.matches;

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

import javax.swing.table.DefaultTableCellRenderer;



/**
 *
 * @author Mohamed Magdy
 */
public class show_matches extends JPanel implements ActionListener {

    JTable table;
    JScrollPane scroll;
    String data[][];
    String header[] = {"id", "team1", "team2", "time", "date", "stadium", "refree"};

    JLabel MATCHID, TEAM1, TEAM2, TIME, DATE, STADIUM, REFREE, lsearch,LTEXT;
    JTextField text_id, text_team1, text_team2, text_time, text_date, text_stadium, text_refree, text_search;
    JButton add_match, edit_match, delete_match, refresh, search;

    ArrayList<matches> arr = matches_database.get_matches();

    public show_matches() {
        this.setLayout(null);

        show_table();

        this.setBackground(Color.PINK);

    }

    public void show_table() {

        //initialize table
        data = new String[arr.size()][7];
        for (int i = 0; i < arr.size(); i++) {
            data[i][0] = "" + arr.get(i).getId();
            data[i][1] = arr.get(i).getTeam1();
            data[i][2] = arr.get(i).getTeam2();
            data[i][3] = arr.get(i).getTime();
            data[i][4] = arr.get(i).getDate();
            data[i][5] = arr.get(i).getStadium();
            data[i][6] = arr.get(i).getRefree();

        }
        table = new JTable(data, header);
        scroll = new JScrollPane(table);
        scroll.setBounds(0, 0, 600, 400);
        add(scroll);
        // label,text field and button

        MATCHID = new JLabel("Match ID");
        TEAM1 = new JLabel("Team 1");
        TEAM2 = new JLabel("Team 2");
        TIME = new JLabel("Time");
        DATE = new JLabel("Date");
        STADIUM = new JLabel("Stadium");
        REFREE = new JLabel("Refree");
        lsearch = new JLabel("Searching For Match By Date");
        LTEXT = new JLabel ("YOU Should Insert ID");

        MATCHID.setBounds(610, 20, 50, 25);
        TEAM1.setBounds(610, 60, 50, 25);
        TEAM2.setBounds(610, 100, 50, 25);
        TIME.setBounds(610, 140, 50, 25);
        DATE.setBounds(610, 180, 50, 25);
        STADIUM.setBounds(610, 220, 50, 25);
        REFREE.setBounds(610, 260, 50, 25);
        LTEXT.setBounds(610, 2, 200, 10);
        LTEXT.setForeground(Color.RED);
        lsearch.setBounds(130, 403, 300, 22);
        
        add(MATCHID);add(TEAM1);add(TEAM2);add(TIME);add(DATE);add(STADIUM);add(REFREE); add(lsearch);add(LTEXT);
      

        text_id = new JTextField();
        text_team1 = new JTextField();
        text_team2 = new JTextField();
        text_time = new JTextField();
        text_date = new JTextField();
        text_stadium = new JTextField();
        text_refree = new JTextField();
        text_search = new JTextField();

        text_id.setBounds(680, 20, 85, 22);
        text_team1.setBounds(680, 60, 85, 22);
        text_team2.setBounds(680, 100, 85, 22);
        text_time.setBounds(680, 140, 85, 22);
        text_date.setBounds(680, 180, 85, 22);
        text_stadium.setBounds(680, 220, 85, 22);
        text_refree.setBounds(680, 260, 85, 22);
        text_search.setBounds(170, 430, 95, 22);
        add(text_id); add(text_team1); add(text_team2); add(text_time); add(text_date); add(text_stadium); add(text_refree); add(text_search);

        add_match = new JButton("Add");
        edit_match = new JButton("Edit");
        delete_match = new JButton("Delete");
        refresh = new JButton("Refresh");
        search = new JButton("Search");
        
        add_match.setBounds(650, 300, 100, 30);
        edit_match.setBounds(650, 340, 100, 30);
        delete_match.setBounds(650, 380, 100, 30);
        refresh.setBounds(650, 420, 100, 30);
        search.setBounds(170, 455, 95, 22);
        add(add_match); add(edit_match); add(delete_match); add(refresh); add(search);

        add_match.addActionListener(this);
        edit_match.addActionListener(this);
        delete_match.addActionListener(this);
        refresh.addActionListener(this);
        search.addActionListener(this);
        //alliegn
        ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
        DefaultTableCellRenderer v = new DefaultTableCellRenderer();
        v.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(v);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setHeaderRenderer(v);
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
          matches_database re =new matches_database();
        if (ae.getSource() == add_match) {
          
            try {

                matches_database.insert_matches(Integer.parseInt(text_id.getText()), text_team1.getText(), text_team2.getText(), text_time.getText(), text_date.getText(), text_stadium.getText(), text_refree.getText());
                  re.refresh_table(table);
                JOptionPane.showMessageDialog(null, "Inserted match", "Egyption League.", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ee) {
                System.out.println(ee.getMessage());
            }

        }
        if (ae.getSource() == edit_match) {
            try {
               
                matches_database.update_matches(Integer.parseInt(text_id.getText()), text_team1.getText(), text_team2.getText(), text_time.getText(), text_date.getText(), text_stadium.getText(), text_refree.getText());
                    re.refresh_table(table);
                JOptionPane.showMessageDialog(null, "Edited match", "Egyption League.", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }
        if (ae.getSource() == delete_match) {
            try {
                matches_database.delete_matches(Integer.parseInt(text_id.getText()));
                   re.refresh_table(table);
                JOptionPane.showMessageDialog(null, "Match Deleted", "Egyption League.", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }
        if (ae.getSource() == refresh) {

            try {
                re.refresh_table(table);
                JOptionPane.showMessageDialog(null, "Table is refreshed", "Egyption League.", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException EE) {
                System.out.println(EE.getMessage());
            }

        }
        if (ae.getSource() == search) {

            try {
                matches_database.search_table(table, text_search.getText());
                JOptionPane.showMessageDialog(null, "Done!", "Egyption League.", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException EE) {
                System.out.println(EE.getMessage());
            }

        }

    }

}
