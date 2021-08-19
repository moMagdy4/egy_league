/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package league;

import attributes.admin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Mohamed Magdy
 */
public class admin_database {

    public static Connection connect() throws SQLException {
       
       return DriverManager.getConnection("jdbc:sqlite:EGYPTION_LEAGUE_MANGMENT_SYSTEM.db");
    }

    public static void insert_admin(String user, String pass) throws SQLException {
        try (
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("insert into ADMINS values(?,?)");){
            p.setString(1, user);
            p.setString(2, pass);
            p.execute();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }
    }

    public static ArrayList<admin> get_admins() {
        ArrayList<admin> list = new ArrayList<admin>();
        try (
            Connection con = connect();
            PreparedStatement p = con.prepareStatement("select*from ADMINS");){
            ResultSet r = p.executeQuery();
            while (r.next()) {
                list.add(new admin(r.getString("USER_NAME"), r.getString("PASSWORD")));
            }

        } catch (SQLException EE) {
            System.out.println(EE.getMessage());
        }
        return list;
    }

    public static int check_user(String user, String pass) {
        ArrayList<admin> ar = get_admins();
        int x = 0;
        for (int i = 0; i < ar.size(); i++) {
            if (ar.get(i).getUser_name().equalsIgnoreCase(user)) {
                if (ar.get(i).getPassword().equalsIgnoreCase(pass)) 
                {
                    x = 1;
                    break;
                } 
                else 
                {
                    x = 2;
                    break;
                }

            }
            else
            {
                x = 0;

            }

        }
        return x;
    }

}
