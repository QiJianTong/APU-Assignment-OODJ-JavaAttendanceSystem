/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
public class Admin extends User{
    
        
        public Admin(String Username, String Password){
            super(Username, Password);
        }
        
        public Admin(){
        
        }

        
  

    /**
     *
     * @param username
     * @param password
     */
        @Override
    public void login(String username,String password){
        //admin list
        Admin[] adminlist = new Admin[3];
        adminlist[0] = new Admin("admin","admin");
        adminlist[1] = new Admin("admin1","admin1");
        adminlist[2] = new Admin("admin2","admin2");
    
        for(Admin adm: adminlist){
            
            if(adm.getName().equals(username) && (adm.getPassport().equals(password))){
                UIadmin mstu = new UIadmin();
                mstu.setVisible(true); 
                break;
            }
            else{
                JOptionPane.showMessageDialog(null,"wrong","pass",JOptionPane.ERROR_MESSAGE);
                UIlogin login = new UIlogin();
                login.setVisible(true);
                break;
            }
        }
    }
    

    
    //register Student
    public void registerstu(String name, String passport,String attendance,String Course,String Phonenum){
        
        Student stu = new Student();
        stu.setName(name);
        stu.setPassport(passport);
        stu.setAttendance(null);
        stu.setCourse(Course);
        stu.setPhonenum(Phonenum);
        String[] arr = new String[]{stu.getName(),stu.getPassport(),stu.getAttendance(),stu.getCourse(),stu.getPhonenum()}; 
        String line = null;
        int n = 5; //exact number of infos
        int i = 1;
        
        File file = new File("registerstu.txt");
        try{
            FileReader fr = new FileReader(file);
            BufferedReader bufr = new BufferedReader(fr);
                while((line = bufr.readLine()) != null){
                    i++;//id
                }
        }
        catch(IOException e){}
           
        try{
            FileWriter fw = new FileWriter(file, true);                
                try( BufferedWriter bufw = new BufferedWriter(fw)) {      
                    bufw.write(i + "\t");
                        for(int a=0;a<n;a++){
                            bufw.write( arr[a] + "\t" ); 
                        }
                        JOptionPane.showMessageDialog(null,"successful registered ");           
                        bufw.newLine();
                        bufw.flush();
                        fw.flush();                                                 
                }                                                           
                        fw.close();
            }
            catch(IOException e){} 
    }
    
    //register Lecturer
    public void registerlect(String name,String passport,String course, String phonenum){
        
        Lecturer lect = new Lecturer();
        lect.setPassport(passport);
        lect.setName(name);
        lect.setcourse(course);
        lect.setphonenum(phonenum);

        String[] arr = new String[]{lect.getName(), lect.getPassport(),lect.getcourse(),lect.getphonenum()}; 
        String line = null;
        int n = 4; //exact number of infos
        int i = 1;

        File file = new File("registerlect.txt");

        try {
            FileReader fr = new FileReader(file);
            BufferedReader bufr = new BufferedReader(fr);
            while ((line = bufr.readLine()) != null) {
                i++;
            }
        } catch (IOException e) {}

        try {
            FileWriter fw = new FileWriter(file, true);                 //If the file exists, add content; If the file does not exist, create the file;

            try (BufferedWriter bufw = new BufferedWriter(fw)) {       //for(int i=0;i<name.length(); i++){
                bufw.write(i + "\t");

                for (int a = 0; a < n; a++) {
                    bufw.write(arr[a] + "\t");//1....2.... 
                }
                JOptionPane.showMessageDialog(null, "successful registered ");
                bufw.newLine();
                bufw.flush();
                fw.flush();
            }
            fw.close();
        } catch (IOException e) {
        } 
    }
    
    public void checkfeedback() {
      
        File file = new File("feedback.txt");

        String line = "";
        UIstufeedback fb = new UIstufeedback();
        fb.setVisible(true);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader bufr = new BufferedReader(fr);
            while ((line = bufr.readLine()) != null) {
                UIstufeedback.jtxtfeedback.append(line + "\r\n");
                UIstufeedback.jtxtfeedback.setLineWrap(true);   
            }
        } catch (IOException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deletestu(){
     
            try {
            File file = new File("registerstu.txt");
            FileReader fr = new FileReader(file);
            BufferedReader bufr = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();

            String name = String.valueOf(UIadmin.jtblect.getModel().getValueAt(0, 1));
            String line = "";

            while ((line = bufr.readLine()) != null) {
                String[] temp = line.split("\t");

                if (temp[1].equals(name)) {//**********************************************************************************************
                    sb = sb.append(UIadmin.jtblect.getModel().getValueAt(0, 0))
                            .append("(dropout)")
                            .append("\t")
                            .append(UIadmin.jtblect.getModel().getValueAt(0, 1))
                            .append("\t")
                            .append(UIadmin.jtblect.getModel().getValueAt(0, 2))
                            .append("\t")
                            .append(UIadmin.jtblect.getModel().getValueAt(0, 3))
                            .append("\t")
                            .append(UIadmin.jtblect.getModel().getValueAt(0, 4))
                            .append("\t")
                            .append(UIadmin.jtblect.getModel().getValueAt(0, 5));

                    sb = sb.append(System.getProperty("line.separator")); 
                } else {
                    sb = sb.append(line);
                    sb = sb.append(System.getProperty("line.separator"));
                }

            }

            JOptionPane.showMessageDialog(null, "successful deleted ");
            bufr.close();
            FileOutputStream fos = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(fos);
            pw.write(sb.toString().toCharArray());
            pw.flush();
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    
    
    }
    
    public void deletelect() {
    
        File file = new File("registerlect.txt");

        String name = String.valueOf(UIadmin.jtblect.getModel().getValueAt(0, 1));
        String line = "";
        try {
            FileReader fr = new FileReader(file);
            BufferedReader bufr = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            while ((line = bufr.readLine()) != null) {
                String[] temp = line.split("\t");

                if (temp[1].equals(name)) {//**********************************************************************************************
                    sb = sb.append(UIadmin.jtblect.getModel().getValueAt(0, 0))
                            .append("(ex-serving officer)")
                            .append("\t")
                            .append(UIadmin.jtblect.getModel().getValueAt(0, 1))
                            .append("\t")
                            .append(UIadmin.jtblect.getModel().getValueAt(0, 2))
                            .append("\t")
                            .append(UIadmin.jtblect.getModel().getValueAt(0, 3))
                            .append("\t")
                            .append(UIadmin.jtblect.getModel().getValueAt(0, 4));

                    sb = sb.append(System.getProperty("line.separator")); 
                } else {
                    sb = sb.append(line);
                    sb = sb.append(System.getProperty("line.separator"));
                }

            }
            JOptionPane.showMessageDialog(null, "successful deleted ");
            bufr.close();
            FileOutputStream fos = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(fos);
            pw.write(sb.toString().toCharArray());
            pw.flush();
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    
    public void checkattendace(){
        File file = new File("attendance.txt");
        String s = null;
        

        try {
            FileReader fr = new FileReader(file);
            BufferedReader bufr = new BufferedReader(fr);
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("ID");
            dtm.addColumn("Name");
            dtm.addColumn("Attendance");
            // 
            // 

            while ((s = bufr.readLine()) != null) {
                String[] temp = s.split("\t");
                String[] row = {temp[0], temp[1], temp[2]};
                dtm.addRow(row);
                UIadmin.jtblect.setModel(dtm);
            }
            TableColumn att = UIadmin.jtblect.getColumnModel().getColumn(2);
            JComboBox jcbatt = new JComboBox();
            jcbatt.addItem("ABSENT WITH REASON");
            att.setCellEditor(new DefaultCellEditor(jcbatt));
        } 
        catch (IOException e) {
        }
    }
    
    
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
            dtm.addColumn("Passport/IC");
            dtm.addColumn("Attendance");
            dtm.addColumn("Course");
            dtm.addColumn("Phone Num");
            // 
            // 

            
            while ((line = bufr.readLine()) != null) {

                String[] temp = line.split("\t");
                if (temp[0].contains("(dropout)")) {
                    continue;//skip this line the ex-stu will not display
                }

                
                dtm.addRow(temp);
                UIadmin.jtblect.setModel(dtm);
            }
        } catch (IOException e) {
        }
    
    
    
    }
    
    public void viewlect(){
        
        File file = new File("registerlect.txt");
        String line = null;

        try {
            FileReader fr = new FileReader(file);
            BufferedReader bufr = new BufferedReader(fr);
            //create table
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("ID");
            dtm.addColumn("Name");
            dtm.addColumn("Passport/IC");
            dtm.addColumn("Course");
            dtm.addColumn("Phone Num");
            // 
            // 

            //显示name列和id列
            while ((line = bufr.readLine()) != null) {
                String[] temp = line.split("\t");
                if (temp[0].contains("(ex-serving officer)")) {
                    continue;//skip this line the ex-staff will not display

                }
                String[] row = {temp[0], temp[1], temp[2],temp[3], temp[4]};
                dtm.addRow(row);
                UIadmin.jtblect.setModel(dtm);//public static JTable
            }

        } catch (IOException e) {
        }
        
    }
    
    public void modifystu(){
        try {
            File file = new File("registerstu.txt");
            FileReader fr = new FileReader(file);
            BufferedReader bufr = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();

            String name = String.valueOf(UIadmin.jtblect.getModel().getValueAt(0, 1));
            String passport = String.valueOf(UIadmin.jtblect.getModel().getValueAt(0, 2));
            String id = String.valueOf(UIadmin.jtblect.getModel().getValueAt(0, 0));
            String line = "";

            while ((line = bufr.readLine()) != null) {
                String[] temp = line.split("\t");

                if ( temp[2].equals(passport)&&temp[1].equals(name)&&temp[0].equals(id)) {
                   
                    sb = sb.append(UIadmin.jtblect.getModel().getValueAt(0, 0))
                            .append("\t")
                            .append(UIadmin.jtblect.getModel().getValueAt(0, 1))
                            .append("\t")
                            .append(UIadmin.jtblect.getModel().getValueAt(0, 2))
                            .append("\t")
                            .append(UIadmin.jtblect.getModel().getValueAt(0, 3))
                            .append("\t")
                            .append(UIadmin.jtblect.getModel().getValueAt(0, 4))
                            .append("\t")
                            .append(UIadmin.jtblect.getModel().getValueAt(0, 5));

                    sb = sb.append(System.getProperty("line.separator")); 
                    
                   
               } else {
                    sb = sb.append(line);
                    sb = sb.append(System.getProperty("line.separator"));
                }

            }

            JOptionPane.showMessageDialog(null, "successful update ");
            bufr.close();
            FileOutputStream fos = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(fos);
            pw.write(sb.toString().toCharArray());
            pw.flush();
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void modifylect() {
    
        File file = new File("registerlect.txt");

        String name = String.valueOf(UIadmin.jtblect.getModel().getValueAt(0, 1));
        String passport = String.valueOf(UIadmin.jtblect.getModel().getValueAt(0, 2));
        String id = String.valueOf(UIadmin.jtblect.getModel().getValueAt(0, 0));
        String line = "";
        try {
            FileReader fr = new FileReader(file);
            BufferedReader bufr = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            while ((line = bufr.readLine()) != null) {
                String[] temp = line.split("\t");

                if (temp[1].equals(name)&&temp[0].equals(id)&&temp[2].equals(passport)) {
                    sb = sb.append(UIadmin.jtblect.getModel().getValueAt(0, 0))
                            .append("\t")
                            .append(UIadmin.jtblect.getModel().getValueAt(0, 1))
                            .append("\t")
                            .append(UIadmin.jtblect.getModel().getValueAt(0, 2))
                            .append("\t")
                            .append(UIadmin.jtblect.getModel().getValueAt(0, 3))
                            .append("\t")
                            .append(UIadmin.jtblect.getModel().getValueAt(0, 4));

                    sb = sb.append(System.getProperty("line.separator"));
                } else {
                    sb = sb.append(line);
                    sb = sb.append(System.getProperty("line.separator"));
                }

            }
            JOptionPane.showMessageDialog(null, "successful update ");
            bufr.close();
            FileOutputStream fos = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(fos);
            pw.write(sb.toString().toCharArray());
            pw.flush();
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public void searchstu() {
        
        File file = new File("registerstu.txt");

        boolean check = false;
        String s = UIadmin.jtxtsearch.getText();
        String line = "";
        try {
            FileReader fr = new FileReader(file);
            BufferedReader bufr = new BufferedReader(fr);
            while ((line = bufr.readLine()) != null) {
                String[] temp = line.split("\t");

                if (temp[1].equalsIgnoreCase(s) || temp[0].equalsIgnoreCase(s)) {

                    DefaultTableModel dtm = new DefaultTableModel();
                    dtm.addColumn("ID");
                    dtm.addColumn("Name");
                    dtm.addColumn("Passport/IC");
                    dtm.addColumn("Attendance");
                    dtm.addColumn("Course");
                    dtm.addColumn("Phone Num");
                    dtm.addRow(temp);
                    UIadmin.jtblect.setModel(dtm);//pu
                    check = true;
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
         if (!check) {

            JOptionPane.showMessageDialog(null, "wrong");
        }
        TableColumn att = UIadmin.jtblect.getColumnModel().getColumn(3);
        JComboBox jcbatt = new JComboBox();

        jcbatt.addItem("ABSENT WITH REASON");

        att.setCellEditor(new DefaultCellEditor(jcbatt));
       
    
    }
    
    public void searchlect() {
        
        File file = new File("registerlect.txt");

        boolean check = false;
        String s = UIadmin.jtxtsearch.getText();
        String line = "";
        try {
            FileReader fr = new FileReader(file);
            BufferedReader bufr = new BufferedReader(fr);
            while ((line = bufr.readLine()) != null) {
                String[] temp = line.split("\t");

                if (temp[1].equalsIgnoreCase(s) || temp[0].equalsIgnoreCase(s)) {

                    DefaultTableModel dtm = new DefaultTableModel();
                    dtm.addColumn("ID");
                    dtm.addColumn("Name");
                    dtm.addColumn("Passport/IC");
                    dtm.addColumn("Course");
                    dtm.addColumn("Phone Num");
                    dtm.addRow(temp);
                    UIadmin.jtblect.setModel(dtm);//pu
                    check = true;
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!check) {

            JOptionPane.showMessageDialog(null, "wrong");
        }

    
    
    }
    

    
    public void createclasstime(String lecturedate,String starttime,String endtime,String modulename,String intakecode){
        classtime time = new classtime();
        time.setlecturedate(lecturedate);
        time.setsarttime(starttime);
        time.setendtime(endtime);
        time.setmodulename(modulename);
        time.setintakecode(intakecode);

        File file = new File("classtime.txt");

        try {
            FileWriter fw = new FileWriter(file);//true
            BufferedWriter bufw = new BufferedWriter(fw);

            bufw.write(time.getlecturedate()
                    + "-" + time.getstarttime()
                    + "-" + time.getendtime()
                    + "-" + time.getmodulename()
                    + "-" + time.getintakecode());

            bufw.newLine();
            fw.flush();
            bufw.flush();

        } catch (IOException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "ok");
    }
    
    
    
    
}
