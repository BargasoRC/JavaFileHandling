/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration2;

/**
 *
 * @author bargasore_sd2023
 */
public class File {
    
    public int unit = 0;
    public String subject = null;
    public String time = null;
    public String days = null;
    public int file_ID = 0;
    public int fk = 0;
    
    public int getFile_ID() {
        return file_ID;
    }

    public int getFk() {
        return fk;
    }

    public boolean setFk(String fk) {
//        this.fk = fk;
        this.fk = (intCheck(fk)?Integer.parseInt(fk)+1:0);
        return intCheck(fk);
    }
    
    

    public boolean setFile_ID(String file_ID) {
        this.file_ID = (intCheck(file_ID)?Integer.parseInt(file_ID)+1:0);
        return intCheck(file_ID);
    }
    

    public int getUnit() {
        return unit;
    }

    public boolean setUnit(String unit) {
        this.unit = (intCheck(unit)?Integer.parseInt(unit):0);
        return intCheck(unit);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }
    
    private boolean intCheck(String num) {
        boolean ageCheck = true;
        try {
            Integer.valueOf(num);
        } catch (Exception e) {
            System.out.println(e);
            ageCheck = false;
        }
        return ageCheck;
    }
    
    public String toString(){
        return String.format("ID: %d\tFK: %d\tUNIT: %d\tSUBJECT: %s\tTIME: %s\tDAY/S: %s",this.file_ID, this.fk, this.unit, this.subject, this.time,this.days);
    }
}
