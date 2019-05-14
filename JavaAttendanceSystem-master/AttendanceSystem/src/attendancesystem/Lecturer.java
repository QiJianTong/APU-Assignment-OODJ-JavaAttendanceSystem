/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem;

import static attendancesystem.UIlect.jtbattendance;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author 91310
 */
public class Lecturer extends User {
    private String course;
    private String phonenum;
    public Lecturer(String Name,String Passport){
        super(Name, Passport);
    }
    
      public Lecturer(){
      
      }  
       public void setphonenum(String phonenum){
       this.phonenum = phonenum;
   }

    public String getphonenum(){
       return phonenum;
   }
      public void setcourse(String course){
          this.course = course;
      }
      public String getcourse(){
          return course;
      }


    /**
     *
     * @param username
     * @param password
     */

   
    @Override
   public void login(String username,String password){
       InputStreamReader read = null;
       boolean testing = false;
       File file = new File("registerlect.txt"); //create a for lect

       try {
           read = new InputStreamReader(new FileInputStream(file));
           BufferedReader in = new BufferedReader(read);
           String line = null;

           while ((line = in.readLine()) != null) {      
               String[] temp = line.split("\t");         

               if (temp[1].equals(username) && (temp[2].equals(password))) {
                   testing = true;
                   UIlect lect = new UIlect();
                   lect.setVisible(true);
                   UIlect.jlcourse.setText(temp[3]);   
                   lect.jlname.setText(username);

                   break;
               }
           }
       } catch (IOException ex) {
           Logger.getLogger(UIlogin.class.getName()).log(Level.SEVERE, null, ex);
       }

       //用户名密码不符    
       if (!testing) {
           JOptionPane.showMessageDialog(null, "wrong", "pass", JOptionPane.ERROR_MESSAGE);
           UIlogin login = new UIlogin();
           login.setVisible(true);
       }

       
   }
  

   
   //view all student
   public void viewstu(){
       File file = new File("registerstu.txt");
       String line = null;
       
       try {
           FileReader fr = new FileReader(file);
           BufferedReader bufr = new BufferedReader(fr);
           //create table
           DefaultTableModel dtm = new DefaultTableModel();
           dtm.addColumn("ID");
           dtm.addColumn("Name");
           dtm.addColumn("Attendance");
           
           //display 
           while ((line = bufr.readLine()) != null) {
                if(line.contains(UIlect.jlcourse.getText())){
                    String[] temp = line.split("\t");
                    String[] row = {temp[0], temp[1], temp[3]};
                    dtm.addRow(row);
                    UIlect.jtbattendance.setModel(dtm);//public static JTable
                }
                else{}
              
           }
           TableColumn att = UIlect.jtbattendance.getColumnModel().getColumn(2);
           JComboBox jcbatt = new JComboBox();
           jcbatt.addItem("PRESENT");
           jcbatt.addItem("ABSENT");
           jcbatt.addItem("LATE");
           att.setCellEditor(new DefaultCellEditor(jcbatt));

       } catch (IOException e) {
       }
   }
   
   //save attendance list
    public void markattendace() {
        try {
            File file = new File("attendance.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bufw = new BufferedWriter(fw);

            //traversal the Jtable 
            for (int i = 0; i < jtbattendance.getRowCount(); i++) {
                for (int j = 0; j < jtbattendance.getColumnCount(); j++) {
                    bufw.write(jtbattendance.getModel().getValueAt(i, j) + "\t");

                    String temp = "";
                    String name = String.valueOf(jtbattendance.getModel().getValueAt(i, 0));
                    try {
                        File file2 = new File("registerstu.txt");
                        FileReader fr = new FileReader(file2);
                        BufferedReader bufr = new BufferedReader(fr);
                        StringBuffer buf = new StringBuffer();

                        while ((temp = bufr.readLine()) != null) {
                            String[] s = temp.split("\t");

                            switch ((String) jtbattendance.getModel().getValueAt(i, 2)) {

                                case "PRESENT":
                                    if (s[0].equals(name)) {
                                        buf = buf.append(s[0]).append("\t")
                                                .append(s[1]).append("\t")
                                                .append(s[2]).append("\t")
                                                .append("PRESENT").append("\t")
                                                .append(s[4]).append("\t")
                                                .append(s[5]);
                                        buf = buf.append(System.getProperty("line.separator"));
                                    } else {
                                        buf = buf.append(temp);
                                        buf = buf.append(System.getProperty("line.separator"));
                                    }
                                    break;

                                case "ABSENT":
                                    if (s[0].equals(name)) {
                                        buf = buf.append(s[0]).append("\t")
                                                .append(s[1]).append("\t")
                                                .append(s[2]).append("\t")
                                                .append("ABSENT").append("\t")
                                                .append(s[4]).append("\t")
                                                .append(s[5]);
                                        buf = buf.append(System.getProperty("line.separator"));
                                    } else {
                                        buf = buf.append(temp);
                                        buf = buf.append(System.getProperty("line.separator"));
                                    }
                                    break;

                                case "LATE":
                                    if (s[0].equals(name)) {
                                        buf = buf.append(s[0]).append("\t")
                                                .append(s[1]).append("\t")
                                                .append(s[2]).append("\t")
                                                .append("LATE").append("\t")
                                                .append(s[4]).append("\t")
                                                .append(s[5]);
                                        buf = buf.append(System.getProperty("line.separator"));
                                    } else {
                                        buf = buf.append(temp);
                                        buf = buf.append(System.getProperty("line.separator"));
                                    }
                                    break;
                            }
                        }
                        bufr.close();
                        FileOutputStream fos = new FileOutputStream(file2);
                        PrintWriter pw = new PrintWriter(fos);
                        pw.write(buf.toString().toCharArray());
                        pw.flush();
                        pw.close();
                    } catch (IOException e) {}
            }
                bufw.write((String) UIlect.jcbclasstime.getSelectedItem());
                bufw.write("\r\n");
            }
            bufw.close();
            fw.close();
            JOptionPane.showMessageDialog(null, "saved");
        } catch (IOException ex) {
            Logger.getLogger(UIlect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
