/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attributes;

/**
 *
 * @author Mohamed Magdy
 */
public class stadium {
    private String name,location,name_team;
    private int seat_capicty;

    public stadium(String name, String location,  int seat_capicty,String name_team) {
        this.name = name;
        this.location = location;
        this.name_team = name_team;
        this.seat_capicty = seat_capicty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName_team() {
        return name_team;
    }

    public void setName_team(String name_team) {
        this.name_team = name_team;
    }

    public int getSeat_capicty() {
        return seat_capicty;
    }

    public void setSeat_capicty(int seat_capicty) {
        this.seat_capicty = seat_capicty;
    }
    
}
