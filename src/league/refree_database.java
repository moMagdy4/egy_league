/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package league;



import attributes.refree;
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
public class refree_database implements refresh {
     public static Connection connect() throws SQLException {
    
       return DriverManager.getConnection("jdbc:sqlite:EGYPTION_LEAGUE_MANGMENT_SYSTEM.db");
    }
      public static ArrayList<refree> get_refree() {
        ArrayList<refree> list = new ArrayList<>();
        try (
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("select*from REFREE");){
            ResultSet r = p.executeQuery();
            while (r.next()) {
                list.add(new refree(r.getString("NAME"),r.getInt("HEIGHT"),r.getInt("WEIGHT")));
            }

        } catch (SQLException EE) {
            System.out.println(EE.getMessage());
        }
        return list;
    }
       public static void insert_refree(String name,int height,int weight) throws SQLException
{
try (
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("insert into REFREE values(?,?,?)");){
            
          
            p.setString(1, name);
              p.setInt(2,height);
               p.setInt(3,weight);
         
            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
     
    }
        public static void update_refree(String name,int height,int weight) throws SQLException {
        try (
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("update REFREE set HEIGHT=?,WEIGHT=? where NAME =?");){
           
              p.setInt(1,height);
               p.setInt(2,weight);
                p.setString(3, name);
          
            p.executeUpdate();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
    }
         public static void delete_refree(String name) throws SQLException {
        try (
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("DELETE FROM REFREE where NAME =?");){
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
            PreparedStatement p = con.prepareStatement("select*from REFREE");){
            ResultSet r = p.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(r));
      }catch (SQLException EE) {
            System.out.println(EE.getMessage());
        }
}
    
}
