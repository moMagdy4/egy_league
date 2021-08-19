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
public class team {
    
    private String name_of_team;
    private int points;

    public String getName_of_team() {
        return name_of_team;
    }

    public void setName_of_team(String name_of_team) {
        this.name_of_team = name_of_team;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public team(String name_of_team, int points) {
        this.name_of_team = name_of_team;
        this.points = points;
    }
    
}
