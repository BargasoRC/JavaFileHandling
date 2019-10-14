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
public class PersonalInformation {
    public String firstName = null;
    public String lastName = null;
    public String middleName = null;
    public int id = 0;
    public int age = 0;
    public int fk = 0;

    public int getFk() {
        return fk;
    }

    public boolean setFk(String fk) {
        this.fk = (intCheck(fk)?Integer.parseInt(fk)+1:0);
        return intCheck(fk);
    }

    public int getAge() {
        return age;
    }

    public boolean setAge(String age) {
        this.age = (intCheck(age)?Integer.parseInt(age):0);
        return intCheck(age);
    }

    public String getFirstName() {
        return firstName;
    }

    public boolean setFirstName(String firstName) {
        this.firstName = (checkName(firstName)?firstName:null);
        return checkName(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public boolean setLastName(String lastName) {
        this.lastName = (checkName(lastName)? lastName : null);
        return checkName(lastName);
    }

    public String getMiddleName() {
        return middleName;
    }

    public boolean setMiddleName(String middleName) {
        this.middleName = (checkName(middleName)? middleName : null);
        return checkName(middleName);
    }

    public int getId() {
        return id;
    }

    public boolean setId(String id) {
        this.id = (intCheck(id)?Integer.parseInt(id)+1:0);
        return intCheck(id);
    }
    
    private boolean checkName(String name){
        String matcher = "[a-zA-Z .]+";
        boolean pass = false;
        try {
            if (name.matches(matcher)) {
                pass = true;
            } else if (name == null) {
                throw new NullPointerException("It should not be null");
            } else {
                throw new myException("Invalid!");
            }
        } catch (NullPointerException npe) {
            System.out.println(npe);
        } catch (myException ioe) {
            System.out.println(ioe);
        }

        return pass;
    }
    
    private boolean intCheck(String id) {
        boolean ageCheck = true;
        try {
            Integer.parseInt(id);
        } catch (Exception e) {
            System.out.println(e);
            ageCheck = false;
        }
        return ageCheck;
    }
    
    @Override
    public String toString(){
        return String.format("id : %d\nfirst name : %s\nmiddle name : %s"
                + "\nlastname : %s\nage: %d",id,firstName,middleName,lastName,age);
    }
}
