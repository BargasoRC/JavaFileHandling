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
    ArrayList< HashMap<String, File>> account_List1 = new ArrayList();
    int id = 0;
    int file_ID = 0;
    public ArrayList getAccountList(){
        return account_List1;
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
        String filePath = "C:\\Users\\bargasore_sd2023\\Documents\\NetBeansProjects\\Registration\\accounts.txt";
        String line = null;
        BufferedReader reader = null;
        FileReader freader = null;

        try {
            freader = new FileReader(filePath);
            reader = new BufferedReader(freader);
            while ((line = reader.readLine()) != null) {
                // ArrayList< HashMap<String, File>> account_List1 = new ArrayList();
                String[] detail = line.split("\t");
                HashMap<String,File> a = new HashMap();
                Account b = new Account();
                File f = new File();
                b.setUsername(detail[1]);
                b.setPassword(detail[2]);
                b.setAccount_ID(id);
                f.setAccount(b);
                a.put(String.valueOf(++file_ID),f);
                account_List1.add(a);
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
        
        String InformationfilePath = "C:\\Users\\bargasore_sd2023\\Documents\\NetBeansProjects\\Registration\\personalInformation.txt";

        try {
            freader = new FileReader(InformationfilePath);
            reader = new BufferedReader(freader);
            while ((line = reader.readLine()) != null) {
                for(int i = 0; i < account_List1.size(); ++i){
                    String[] detail = line.split("\t");
                    if(account_List1.get(i).get(i).getAccount().getAccount_ID()==Integer.parseInt(detail[1])){
                        
                    }
                }
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
    }
    
    private static class myException extends Exception {

        public myException(String invalid_user_name) {
            System.out.println(invalid_user_name);
        }
    }
}
