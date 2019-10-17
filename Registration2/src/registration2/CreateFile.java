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
import java.util.Iterator;

/**
 *
 * @author bargasore_sd2023
 */
public class CreateFile {

//    ArrayList<File> account_List = new ArrayList();
    public ArrayList<ArrayList<Account>> accounts = new ArrayList();
    public ArrayList<ArrayList<PersonalInformation>> info = new ArrayList();
    public ArrayList<ArrayList<File>> schedule = new ArrayList();

//    int id = 0;
    public ArrayList getAccount() {
        return accounts;
    }

    public ArrayList getPersonalInformation() {
        return info;
    }

    public ArrayList getCourse() {
        return schedule;
    }

//    public void createAccount(String username, String password) {
//        String filePath = "C:\\Users\\bargasore_sd2023\\Documents\\NetBeansProjects\\Registration\\accounts.txt";
//        String line = null;
//        BufferedReader reader = null;
//        FileReader freader = null;
//
//        try {
//            freader = new FileReader(filePath);
//            reader = new BufferedReader(freader);
//            while ((line = reader.readLine()) != null) {
//                ++id;
//            }
//        } catch (FileNotFoundException fnf) {
//            System.out.println(fnf);
//        } catch (IOException io) {
//            System.out.println(io);
//        } finally {
//            try {
//                reader.close();
//            } catch (IOException io) {
//                System.out.println(io);
//            } catch (NullPointerException np) {
//                System.out.println(np);
//            }
//        }
//
//        Path path = Paths.get("C:\\Users\\bargasore_sd2023\\Documents\\NetBeansProjects\\Registration\\accounts.txt");
//        try {
//            Files.write(path, String.format("%d\t%s\t%s\n", id, username, password).getBytes(), StandardOpenOption.APPEND);
//            System.out.println("Details has been added!");
//        } catch (IOException ioe) {
//            System.out.println(ioe);
//        }
//    }

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
    public void readFiles() {
        /**
         * store the information from the accounts.txt to the account_List which
         * is the arrayList 
         */

        accounts = new <ArrayList<Account>>ArrayList();
        info = new <ArrayList<PersonalInformation>>ArrayList();
        schedule = new <ArrayList<File>>ArrayList();

        String filePath = "C:\\Users\\2ndyrGroupC\\Desktop\\Bargaso_files\\JavaFileHandling\\Registration2\\accounts.txt";
        String line = null;
        BufferedReader reader = null;
        FileReader freader = null;

        try {
            freader = new FileReader(filePath);
            reader = new BufferedReader(freader);
            while ((line = reader.readLine()) != null) {
                Account account = new Account();
                ArrayList<Account> list = new ArrayList();
                String[] lines = line.split("\t");
                account.account_ID = Integer.parseInt(lines[0]);
                account.username = lines[1];
                account.password = lines[2];
                list.add(account);
                accounts.add(list);
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
         * store the information from the personalInformation.txt to the
         * account_List which is the arrayList above
         */
        String InformationfilePath = "C:\\Users\\2ndyrGroupC\\Desktop\\Bargaso_files\\JavaFileHandling\\Registration2\\personalInformation.txt";

        try {
            freader = new FileReader(InformationfilePath);
            reader = new BufferedReader(freader);

            while ((line = reader.readLine()) != null) {
                String[] lines = line.split("\t");
                PersonalInformation personalInfo = new PersonalInformation();
                ArrayList<PersonalInformation> list = new ArrayList();

                personalInfo.id = Integer.parseInt(lines[0]);
                personalInfo.fk = Integer.parseInt(lines[1]);
                personalInfo.firstName = lines[2];
                personalInfo.middleName = lines[3];
                personalInfo.lastName = lines[4];
                personalInfo.age = Integer.parseInt(lines[5]);
                list.add(personalInfo);
                info.add(list);

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

        String schedPath = "C:\\Users\\2ndyrGroupC\\Desktop\\Bargaso_files\\JavaFileHandling\\Registration2\\courses.txt";
        try {
            freader = new FileReader(schedPath);
            reader = new BufferedReader(freader);
            while ((line = reader.readLine()) != null) {
                String[] lines = line.split("\t");
                File sched = new File();
                ArrayList<File> list = new ArrayList();

                sched.file_ID = Integer.parseInt(lines[0]);
                sched.fk = Integer.parseInt(lines[1]);
                sched.unit = Integer.parseInt(lines[2]);
                sched.subject = lines[3];
                sched.time = lines[4];
                sched.days = lines[5];
                list.add(sched);
                schedule.add(list);

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

    public void createPersonalInformation(ArrayList list) {
        info.add(list);
    }

    public void createAccount(ArrayList list) {
        accounts.add(list);
    }

    public void createCourse(ArrayList list) {
        schedule.add(list);
    }

    public void save() {
        //remove the standardOpenOption.APPEND to write the details from the arrayList
        Path path = Paths.get("C:\\Users\\2ndyrGroupC\\Desktop\\Bargaso_files\\JavaFileHandling\\Registration2\\accounts.txt");
        try {
            Files.write(path,("").getBytes());
            for (ArrayList<Account> a : accounts) {
                Files.write(path, String.format("%d\t%s\t%s\n", a.get(0).getAccount_ID(), a.get(0).getUsername(), a.get(0).getPassword()).getBytes(), StandardOpenOption.APPEND);
            }
            System.out.println("Details has been added!");
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        Path infoPath = Paths.get("C:\\Users\\2ndyrGroupC\\Desktop\\Bargaso_files\\JavaFileHandling\\Registration2\\personalInformation.txt");
        try {
            Files.write(infoPath,("").getBytes());
            for (ArrayList<PersonalInformation> a : info) {
                Files.write(infoPath, String.format("%d\t%d\t%s\t%s\t%s\t%d\n", a.get(0).getId(), a.get(0).getFk(), a.get(0).getFirstName(), a.get(0).getMiddleName(), a.get(0).getLastName(), a.get(0).age).getBytes(), StandardOpenOption.APPEND);
            }
            System.out.println("Details has been added!");
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        Path coursePath = Paths.get("C:\\Users\\2ndyrGroupC\\Desktop\\Bargaso_files\\JavaFileHandling\\Registration2\\courses.txt");
        try {
            Files.write(coursePath,("").getBytes());
            for (ArrayList<File> a : schedule) {
                Files.write(coursePath, String.format("%d\t%d\t%d\t%s\t%s\t%s\n", a.get(0).file_ID, a.get(0).fk, a.get(0).unit, a.get(0).subject, a.get(0).time, a.get(0).days).getBytes(), StandardOpenOption.APPEND);
            }
            System.out.println("Details has been added!");
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public void deletePersonalInformation(int id) {
        Iterator itr = info.iterator();
        while(itr.hasNext()){
            ArrayList<PersonalInformation> a = (ArrayList<PersonalInformation>) itr.next();
            if(a.get(0).id == id){
                info.remove(info.indexOf(a));
                break;
            }
        }
        
        System.out.println("Deleted Successfully!");
    }

    public void deleteCourse(int id) {
        for (ArrayList<File> a : schedule) {
            if (a.get(0).file_ID == id) {
                schedule.remove(schedule.indexOf(a));
                break;
            }
        }
        System.out.println("Deleted Successfully!");
    }

    public String idGenerator(String file) {
        /**
         * this will generator Id for every transactions
         */
        String filePath = "C:\\Users\\2ndyrGroupC\\Desktop\\Bargaso_files\\JavaFileHandling\\Registration2\\" + file;
        String line = null;
        BufferedReader reader = null;
        FileReader freader = null;
        int id = 0;
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

        return String.valueOf(id);
    }

    private static class myException extends Exception {

        public myException(String invalid_user_name) {
            System.out.println(invalid_user_name);
        }
    }
}
