/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egyption_league;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author Mohamed Magdy
 */
public class third_screen extends JFrame {

    JTabbedPane tap;
    show_matches m1;
    show_teames m2;
    show_stadium m3;
    show_players m4;
    show_refree m5;
    show_coach m6;
    image i = new image();

    public third_screen() {

    }

    public void show_third_screen() {
        m1 = new show_matches();
        m2 = new show_teames();
        m3 = new show_stadium();
        m4= new show_players();
        m5=new show_refree();
        m6=new show_coach();
        //main form
        setTitle("league");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(800, 600);
        setVisible(true);

        tap = new JTabbedPane();
        tap.addTab("List Of Matches", m1);
        tap.addTab("List Of Teams", m2);
        tap.addTab("Head Coaches", m6);
         tap.addTab("List Of Players",m4);
         tap.addTab("Refrees", m5);
        tap.addTab("Stadiums", m3);
       
        
       

        add(tap);

    }

}
