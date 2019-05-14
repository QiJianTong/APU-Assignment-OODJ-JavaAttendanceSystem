/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem;

/**
 *
 * @author 91310
 */
public abstract class User {
    protected String Name;
    protected String  Passport;
    
    public User(){
    
    }
    public User(String username, String password){
        this.Name = username;
        this.Passport = password;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public void setPassport(String Passport){
        this.Passport = Passport;
    }
    public String getName(){
        return Name;
    }
    public String getPassport(){
        return Passport;
    }
    abstract void login(String username, String password);
    
    public void logout(){
    UIlogin login = new UIlogin();
    login.setVisible(true);
    
    }
}
