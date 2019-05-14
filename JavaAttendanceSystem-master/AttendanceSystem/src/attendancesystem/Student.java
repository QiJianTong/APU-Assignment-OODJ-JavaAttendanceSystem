/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 91310
 */
public class Student extends User {

    private String ID;
    private String Attendance;
    private String Course;
    private String Phonenum;

    public Student() {
    }

    public Student(String Name, String ID, String Passport, String Attendance) {
        super(Name, Passport);
        this.ID = ID;
        this.Attendance = Attendance;
    }

    public void setPhonenum(String phonenum) {
        this.Phonenum = phonenum;
    }

    public String getPhonenum() {
        return Phonenum;
    }

    public void setID(String id) {
        this.ID = id;
    }

    public String getID() {
        return ID;
    }
  
    public void setAttendance(String attendance){
       this.Attendance = attendance;
   }

    public String getAttendance(){
       return Attendance;
   }
    public void setCourse(String course){
        Course = course;
    }
    public String getCourse(){
        return Course;
    }
    
    
    
    
    

    /**
     *
     * @param username
     * @param password
     */
    @Override//student login
    public void login(String username, String password){
       
        boolean testing = false;
        File file = new File("registerstu.txt");
        InputStreamReader read = null;

        try {
            read = new InputStreamReader(new FileInputStream(file));
            BufferedReader in = new BufferedReader(read);
            String line = null;

            while ((line = in.readLine()) != null) {      
                String[] temp = line.split("\t");         

                if (temp[1].equals(username) && (temp[2].equals(password))) {
                    testing = true;
                    UIstu stu = new UIstu();
                    stu.setVisible(true);
                    UIstu.jlname.setText(username);     
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(UIlogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        //username or password incorrect    
        if (!testing) {
            JOptionPane.showMessageDialog(null, "Please check your username and Password", "Wrong username or password", JOptionPane.ERROR_MESSAGE);
            UIlogin login = new UIlogin();
            login.setVisible(true);
        }

   }
    
   /* public void logout(){
    UIlogin login = new UIlogin();
    login.setVisible(true);
    
    }*/
    
    //Student check attendance
    public void checkattendance(){
        String line = "";
        File file = new File("registerstu.txt");

        try {
            FileReader fr = new FileReader(file);
            BufferedReader bufr = new BufferedReader(fr);
            while ((line = bufr.readLine()) != null) {
                String[] temp = line.split("\t");
                if (temp[1].equals(UIstu.jlname.getText())) {

                    UIstu.jlattendance.setText(temp[3]);
                }

            }
            fr.close();
            bufr.close();
        } catch (IOException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    
    public void feedback(){
        String feedback = UIstu.jtxtareafeedback.getText();
        String stuname = UIstu.jlname.getText();
        File file = new File("feedback.txt");
        FileWriter fw;
        try {
            fw = new FileWriter(file, true);
            BufferedWriter bufw = new BufferedWriter(fw);
            bufw.write(stuname + ":" + "\r\n");
            bufw.write(feedback);
            UIstu.jtxtareafeedback.setText("");
            bufw.newLine();
            bufw.flush();
            fw.flush();

        } catch (IOException ex) {
            Logger.getLogger(UIstu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
