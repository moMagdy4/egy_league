/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package league;


import attributes.matches;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Mohamed Magdy
 */
public class matches_database implements refresh {

    public static Connection connect() throws SQLException {
    
       return DriverManager.getConnection("jdbc:sqlite:EGYPTION_LEAGUE_MANGMENT_SYSTEM.db");
    }

    public static void insert_matches(int id , String team1, String team2, String time, String date, String stadium, String refree) throws SQLException {
        try (
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("insert into LISTOFMATCHES values(?,?,?,?,?,?,?)");){
            p.setInt(1,id);
            p.setString(2, team1);
            p.setString(3, team2);
            p.setString(4, time);
            p.setString(5, date);
            p.setString(6, stadium);
            p.setString(7, refree);
            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
      
    }
     public static ArrayList<matches> get_matches() {
        ArrayList<matches> list = new ArrayList<>();
        try (
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("select*from LISTOFMATCHES");){
            ResultSet r = p.executeQuery();
            while (r.next()) {
                list.add(new matches(r.getInt("ID"),r.getString("TEAM1"), r.getString("TEAM2"),r.getString("TIME"),r.getString("DATE"),r.getString("STADIUM"),r.getString("REFREE")));
            }

        } catch (SQLException EE) {
            System.out.println(EE.getMessage());
        }
        return list;
    }
  
         public static void update_matches(int id , String team1, String team2, String time, String date, String stadium, String refree) throws SQLException {
        try (
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("update LISTOFMATCHES set TEAM1=?,TEAM2=?,TIME=?,DATE=?,STADIUM=?,REFREE=? where ID =?");){
            
            p.setString(1, team1);
            p.setString(2, team2);
            p.setString(3, time);
            p.setString(4, date);
            p.setString(5, stadium);
            p.setString(6, refree);
            p.setInt(7,id);
            p.executeUpdate();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
    }
           public static void delete_matches(int id) throws SQLException {
        try (
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("DELETE FROM LISTOFMATCHES where ID =?");){
              p.setInt(1,id);
            p.executeUpdate();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
    }
      
    
      public static void search_table(JTable table,String date) throws SQLException
     {
      try (
             Connection con = connect();
            PreparedStatement p = con.prepareStatement("select*from LISTOFMATCHES where DATE=?");){
           p.setString(1,date );
            ResultSet r = p.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(r));
      }catch (SQLException EE) {
            System.out.println(EE.getMessage());
        }
     
     
     
}

    @Override
    public void refresh_table(JTable table) throws SQLException {
      try (
             Connection con = connect();
            PreparedStatement p = con.prepareStatement("select*from LISTOFMATCHES");){
            ResultSet r = p.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(r));
      }catch (SQLException EE) {
            System.out.println(EE.getMessage());
        }   
    }

  

}