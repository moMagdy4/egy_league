/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package league;

import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author Mohamed Magdy
 */
public interface refresh{
    // method that refresh the table
     public  void refresh_table(JTable table)  throws SQLException;
   
    
}
