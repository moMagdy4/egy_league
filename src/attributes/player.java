/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attributes;

import attributes.people;

/**
 *
 * @author Mohamed Magdy
 */
public class player extends people {

    public player(int playeid,String name, int height, int weight,String position, String nameofteam) {
        super(name, height, weight);
        this.playeid = playeid;
        this.position = position;
        this.nameofteam = nameofteam;
    }

    public int getPlayeid() {
        return playeid;
    }

    public void setPlayeid(int playeid) {
        this.playeid = playeid;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNameofteam() {
        return nameofteam;
    }

    public void setNameofteam(String nameofteam) {
        this.nameofteam = nameofteam;
    }
    private int playeid;
    private String position,nameofteam;
    
}
