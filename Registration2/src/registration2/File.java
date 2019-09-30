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
    Account account;
    PersonalInformation information;
    int unit = 0;
    String subject = null;
    String time = null;
    String days = null;
    
    public File(){
        account = new Account();
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public PersonalInformation getInformation() {
        return information;
    }

    public void setInformation(PersonalInformation information) {
        this.information = information;
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
    
}
