/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package league;



import attributes.team;

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
public class team_database implements refresh {
    public static Connection connect() throws SQLException {
    
       return DriverManager.getConnection("jdbc:sqlite:EGYPTION_LEAGUE_MANGMENT_SYSTEM.db");
    }
public static void insert_team(String name_of_team,int points) throws SQLException
{
try (
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("insert into TEAM values(?,?)");){
            
          
            p.setString(1, name_of_team);
            p.setInt(2,points);
            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
     
    }
 public static ArrayList<team> get_team() {
        ArrayList<team> list = new ArrayList<>();
        try (
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("select*from TEAM");){
            ResultSet r = p.executeQuery();
            while (r.next()) {
                list.add(new team(r.getString("NAME_OF_TEAM"),r.getInt("POINTS")));
            }

        } catch (SQLException EE) {
            System.out.println(EE.getMessage());
        }
        return list;
    }
   public static void update_team(String name_of_team,int points) throws SQLException {
        try (
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("update TEAM set POINTS=? where NAME_OF_TEAM =?");){
             p.setInt(1,points);
            p.setString(2,name_of_team);
          
            p.executeUpdate();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
    }
public static void delete_team(String name) throws SQLException {
        try (
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("DELETE FROM TEAM where NAME_OF_TEAM =?");){
              p.setString(1,name);
            p.executeUpdate();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
    }
    @Override
    public  void refresh_table(JTable table) throws SQLException
     {
      try (
             Connection con = connect();
            PreparedStatement p = con.prepareStatement("select*from TEAM");){
            ResultSet r = p.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(r));
      }catch (SQLException EE) {
            System.out.println(EE.getMessage());
        }
}
 
     
     
     
}



