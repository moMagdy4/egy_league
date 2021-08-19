/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egyption_league;

import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Mohamed Magdy
 */
public class image extends JPanel{
    
  
     private ImageIcon i;
     
    public image()
    {
    
    this.setLayout(null);
    }
    @Override
    public void paintComponent(Graphics g)
    {
    super.paintComponent(g);
    i=new ImageIcon(getClass().getResource("..\\img\\ulrich.jpg"));
    
    i.paintIcon(this, g, 0, 0);
    
    
    }

   
}
