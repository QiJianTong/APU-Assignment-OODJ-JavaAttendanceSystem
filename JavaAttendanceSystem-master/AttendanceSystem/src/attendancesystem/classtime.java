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
public class classtime {
    private String lecturedate;
    private String starttime;
    private String endtime;
    private String modulename;
    private String intakecode;
    
    
    public classtime(String lecturedate,String starttime,String endtime,String modulename,String intakecode){
    
    }
    public classtime(){
    
    }
    
    public void setlecturedate(String date){
        lecturedate = date;
    }
    public  String getlecturedate(){
        return lecturedate;
    }
    
    public void setsarttime(String starttime){
        this.starttime = starttime;
    }
    public String getstarttime(){
        return starttime;
    }
    
    public void setendtime(String endtime){
        this.endtime = endtime;
    }
    public String getendtime(){
        return endtime;
    }
    
    public void setmodulename(String modulename){
        this.modulename = modulename;
    }
    public String getmodulename(){
        return modulename;
    }
    
    public void setintakecode(String intakecode){
        this.intakecode = intakecode;
    }
    public String getintakecode(){
        return intakecode;
    }

    
    
}
