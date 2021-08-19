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
public class admin {
   private String user_name;
    private String password;
    
    //setter and getter

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //constructor
public admin()
{

}
    public admin(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }
    
}
