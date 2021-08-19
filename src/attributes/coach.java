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
public class coach extends people{
    private String nameteam;
    private int coachid;

    public String getNameteam() {
        return nameteam;
    }

    public void setNameteam(String nameteam) {
        this.nameteam = nameteam;
    }

    public int getCoachid() {
        return coachid;
    }

    public void setCoachid(int coachid) {
        this.coachid = coachid;
    }
   

    public coach(int coachid,  String name, int height, int weight,String nameteam) {
        super(name, height, weight);
        this.nameteam = nameteam;
        this.coachid = coachid;
    }
    
}
