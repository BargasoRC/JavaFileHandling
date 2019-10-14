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
public class Account {
    public String password = null;
    public String username = null;
    public int account_ID = 0;
    
    public String getPassword() {
        return password;
    }

    public boolean setPassword(String password) {
        this.password = password;
        return checkPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public boolean setUsername(String username) {
        this.username = username;
        return checkUsername(username);
    }

    public int getAccount_ID() {
        return account_ID;
    }

    public boolean setAccount_ID(String account_ID) {
        this.account_ID = (intCheck(account_ID)?Integer.parseInt(account_ID)+1:0);
        return intCheck(account_ID);
    }
    
    private boolean checkUsername(String username){
        String matcher = "[a-zA-Z .]+";
        boolean pass = false;
        try {
            if (username.matches(matcher)) {
                pass = true;
            } else if (username == null) {
                throw new NullPointerException("user name should not be null");
            } else {
                throw new myException("Invalid user name!");
            }
        } catch (NullPointerException npe) {
            System.out.println(npe);
        } catch (myException ioe) {
            System.out.println(ioe);
        }

        return pass;
    }
    
    private boolean checkPassword(String password){
         boolean pass = false;
        try {
            if (password.length() >= 8 && password != null) {
                pass = true;
            } else if (password == null) {
                throw new NullPointerException("password should not be null");
            } else {
                throw new myException("Invalid password! password should be minimum of eight(e) characters");
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
            Integer.valueOf(id);
        } catch (Exception e) {
            System.out.println(e);
            ageCheck = false;
        }
        return ageCheck;
    }
    
    public String toString(){
        return String.format("account id : %d\nusername : %s\npassword : %s", account_ID,username,password);
    }
}
