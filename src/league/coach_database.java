/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package league;

import attributes.coach;
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
public class coach_database implements refresh {
     public static Connection connect() throws SQLException {
    
       return DriverManager.getConnection("jdbc:sqlite:EGYPTION_LEAGUE_MANGMENT_SYSTEM.db");
    }
      public static ArrayList<coach> get_coach() {
        ArrayList<coach> list = new ArrayList<>();
        try (
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("select*from COACH");){
            ResultSet r = p.executeQuery();
            while (r.next()) {
                list.add(new coach(r.getInt("COAC_ID"),r.getString("NAME_of_COACH"),r.getInt("HEIGHT"),r.getInt("WEIGHT"),r.getString("NAME_OF_TEAM")));
            }

        } catch (SQLException EE) {
            System.out.println(EE.getMessage());
        }
        return list;
    }
        public static void insert_coach(int id,String name,int height,int weight,String name_of_team) throws SQLException
{
try (
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("insert into COACH values(?,?,?,?,?)");){
            
           p.setInt(1,id);
            p.setString(2, name);
              p.setInt(3,height);
               p.setInt(4,weight);
           
            p.setString(5, name_of_team);
            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
     
    }
        public static void update_coach(int id,String name,int height,int weight,String name_of_team) throws SQLException {
        try (
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("update PLAYERS set NAME_OF_COACH=?,HEIGHT=?,WEIGHT=?,NAME_OF_TEAM=? where COAC_ID =?");){
            p.setString(1, name);
              p.setInt(2,height);
               p.setInt(3,weight);
          
            p.setString(4, name_of_team);
             p.setInt(5,id);
            p.executeUpdate();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
    }
         public static void delete_coach(int id) throws SQLException {
        try (
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("DELETE FROM COACH where COAC_ID =?");){
              p.setInt(1,id);
            p.executeUpdate();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
    }


    @Override
    public void refresh_table(JTable table) throws SQLException {
        try (
             Connection con = connect();
            PreparedStatement p = con.prepareStatement("select*from COACH");){
            ResultSet r = p.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(r));
      }catch (SQLException EE) {
            System.out.println(EE.getMessage());
        }
        
    }

    
    public void search_table(JTable table, String NAME) throws SQLException {
         try (
             Connection con = connect();
            PreparedStatement p = con.prepareStatement("select*from COACH where NAME_OF_TEAM=?");){
           p.setString(1,NAME );
            ResultSet r = p.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(r));
      }catch (SQLException EE) {
            System.out.println(EE.getMessage());
        }
    }

    
    
}
