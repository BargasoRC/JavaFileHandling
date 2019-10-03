/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author bargasore_sd2023
 */
public class CreateFile {
    ArrayList<File> account_List = new ArrayList();
    int id = 0;
    
    public ArrayList getAccountList(){
        return account_List;
    }

    public void createAccount(String username, String password) {
        String filePath = "C:\\Users\\bargasore_sd2023\\Documents\\NetBeansProjects\\Registration\\accounts.txt";
        String line = null;
        BufferedReader reader = null;
        FileReader freader = null;

        try {
            freader = new FileReader(filePath);
            reader = new BufferedReader(freader);
            while ((line = reader.readLine()) != null) {
                ++id;
            }
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf);
        } catch (IOException io) {
            System.out.println(io);
        } finally {
            try {
                reader.close();
            } catch (IOException io) {
                System.out.println(io);
            } catch (NullPointerException np) {
                System.out.println(np);
            }
        }

        Path path = Paths.get("C:\\Users\\bargasore_sd2023\\Documents\\NetBeansProjects\\Registration\\accounts.txt");
        try {
            Files.write(path, String.format("%d\t%s\t%s\n", id, username, password).getBytes(), StandardOpenOption.APPEND);
            System.out.println("Details has been added!");
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
    
     /*level 1 check the username and password */

    public static boolean userName(String username) {
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

    public static boolean password(String password) {
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

    /* checking of username and password end block*/
    
    
    public void readFiles(){
        /**
         * store the information from the accounts.txt to the account_List which
         * is the arrayList above
         */
        String filePath = "C:\\Users\\bargasore_sd2023\\Documents\\NetBeansProjects\\Registration\\accounts.txt";
        String line = null;
        BufferedReader reader = null;
        FileReader freader = null;

        try {
            freader = new FileReader(filePath);
            reader = new BufferedReader(freader);
            while ((line = reader.readLine()) != null) {
                String[] lines = line.split("\t");
                File files = new File();
                files.account.account_ID = Integer.parseInt(lines[0]);
                files.account.username = lines[1];
                files.account.password = lines[2];
                account_List.add(files);
            }
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf);
        } catch (IOException io) {
            System.out.println(io);
        } finally {
            try {
                reader.close();
            } catch (IOException io) {
                System.out.println(io);
            } catch (NullPointerException np) {
                System.out.println(np);
            }
        }
        /* end block of accounts.txt reading */
        
        
        /**
         * store the information from the personalInformation.txt to the account_List which
         * is the arrayList above
         */
        
        String InformationfilePath = "C:\\Users\\bargasore_sd2023\\Documents\\NetBeansProjects\\Registration\\personalInformation.txt";

        try {
            freader = new FileReader(InformationfilePath);
            reader = new BufferedReader(freader);
            while ((line = reader.readLine()) != null) {
                String[] lines = line.split("\t");
                File files = new File();
                files.information.id = Integer.parseInt(lines[0]);
                files.information.firstName = lines[1];
                files.information.middleName = lines[2];
                files.information.lastName = lines[3];
            }
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf);
        } catch (IOException io) {
            System.out.println(io);
        } finally {
            try {
                reader.close();
            } catch (IOException io) {
                System.out.println(io);
            } catch (NullPointerException np) {
                System.out.println(np);
            }
        }
        /* end block of personalInformation.txt reading */
        
        
        
    }
    
    private static class myException extends Exception {

        public myException(String invalid_user_name) {
            System.out.println(invalid_user_name);
        }
    }
}
