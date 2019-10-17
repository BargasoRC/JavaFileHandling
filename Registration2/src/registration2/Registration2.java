/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author bargasore_sd2023
 */
public class Registration2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner intInput = new Scanner(System.in);
        Scanner stringInput = new Scanner(System.in);
        CreateFile register = new CreateFile();
        /*
         create a method in the create file that will read the personal
         information's lines and Course's lines for their PK(ID) of each
         transaction
         */
        String accountID = register.idGenerator("accounts.txt");
        String informationPK = register.idGenerator("personalInformation.txt");
        String coursePK = register.idGenerator("courses.txt");

        while (true) {
            ArrayList<Account> accountFiles = new ArrayList();
            ArrayList<PersonalInformation> personalInformationFiles = new ArrayList();
            ArrayList<File> courseFile = new ArrayList();

            Account account = new Account();
            PersonalInformation information = new PersonalInformation();
            File course = new File();

            String userName = null;
            String passWord = null;
            String firstName = null;
            String lastName = null;
            String middleName = null;
            String age = null;
            String subject = null;
            String unit = null;
            String time = null;
            String days = null;

            System.out.println("C\tCreate");
            System.out.println("R\tRetrieve");
            System.out.println("U\tUpdate");
            System.out.println("D\tDelete");
            System.out.println("S\tSave");
            System.out.println("SE\tSearch");
            System.out.println("[E]\tExit");

            System.out.print("Choice: ");
            String cruds = stringInput.nextLine();

            if (cruds.toLowerCase().equals("c")) {
                while (true) {
                    System.out.print("User Name: ");
                    userName = stringInput.nextLine();
                    if (account.setUsername(userName)) {
                        account.setUsername(userName);
                        break;
                    }
                }
                while (true) {
                    System.out.print("Password: ");
                    passWord = stringInput.nextLine();
                    if (account.setPassword(passWord)) {
                        account.setPassword(passWord);
                        break;
                    }
                }

                System.out.print("Do you want to proceed? (Y/N) : ");
                String toInformation = stringInput.nextLine();

                if (toInformation.toLowerCase().equals("y")) {

                    account.setAccount_ID(accountID);
                    accountFiles.add(account);
                    register.accounts.add(accountFiles);

                    information.setFk(accountID);
                    information.setId(informationPK);
                    while (true) {
                        System.out.print("First Name: ");
                        firstName = stringInput.nextLine();
                        if (information.setFirstName(firstName)) {
                            information.setFirstName(firstName);
                            break;
                        }
                    }
                    while (true) {
                        System.out.print("Middle Name: ");
                        middleName = stringInput.nextLine();
                        if (information.setMiddleName(middleName)) {
                            information.setMiddleName(middleName);
                            break;
                        }
                    }

                    while (true) {
                        System.out.print("Last Name: ");
                        lastName = stringInput.nextLine();
                        if (information.setLastName(lastName)) {
                            information.setLastName(lastName);
                            break;
                        }
                    }

                    while (true) {
                        System.out.print("Age : ");
                        age = stringInput.nextLine();
                        if (information.setAge(age)) {
                            information.setAge(age);
                            break;
                        }
                    }

                    personalInformationFiles.add(information);
                    register.info.add(personalInformationFiles);
                    //informationPK
                    informationPK = String.valueOf(Integer.parseInt(informationPK) + 1);

                    System.out.print("Do you want to proceed? (Y/N) : ");
                    String toCourse = stringInput.nextLine();

                    if (toCourse.toLowerCase().equals("y")) {
                        course.setFile_ID(coursePK);
                        course.setFk(accountID);

                        System.out.print("Subject : ");
                        subject = stringInput.nextLine();
                        course.setSubject(subject);

                        while (true) {
                            System.out.print("Unit : ");
                            unit = stringInput.nextLine();
                            if (course.setUnit(unit)) {
                                course.setUnit(unit);
                                break;
                            }
                        }

                        System.out.print("Time : ");
                        time = stringInput.nextLine();
                        course.setTime(time);

                        System.out.print("Day/s : ");
                        days = stringInput.nextLine();
                        course.setDays(days);

                        courseFile.add(course);
                        register.schedule.add(courseFile);
                        //coursePK
                        coursePK = String.valueOf(Integer.parseInt(coursePK) + 1);
                    }
                    //accountID
                    accountID = String.valueOf(Integer.parseInt(accountID) + 1);
                } else {
                    account.setAccount_ID(accountID);
                    accountFiles.add(account);
                    accountID = String.valueOf(Integer.parseInt(accountID) + 1);
                    register.accounts.add(accountFiles);
                    coursePK = String.valueOf(Integer.parseInt(coursePK)+1);
                    informationPK = String.valueOf(Integer.parseInt(informationPK) + 1);
                    
                    continue;
                }
            }

            if (cruds.toLowerCase().equals("r")) {
                register.readFiles();
                if (register.accounts.isEmpty() && register.info.isEmpty() && register.schedule.isEmpty()) {
                    System.out.println("Nothing to show!");
                } else {
                    System.out.println("\n");
                    System.out.printf("%s%20s%20s\n", "ID", "USERNAME", "PASSWORD");
                    for (ArrayList<Account> a : register.accounts) {
                        System.out.printf("%d", a.get(0).getAccount_ID());
                        System.out.printf("%20s", a.get(0).username);
                        System.out.printf("%20s\n", a.get(0).password);
                    }
                    System.out.println("\n");
                    System.out.printf("%s%10s%20s%20s%20s%20s\n", "ID", "FK", "FIRSTNAME", "MIDDLENAME", "LASTNAME", "AGE");
                    for (ArrayList<PersonalInformation> pf : register.info) {
                        System.out.printf("%d", pf.get(0).getId());
                        System.out.printf("%10d", pf.get(0).fk);
                        System.out.printf("%20s", pf.get(0).firstName);
                        System.out.printf("%20s", pf.get(0).middleName);
                        System.out.printf("%20s", pf.get(0).lastName);
                        System.out.printf("%20s\n", pf.get(0).age);
                    }
                    System.out.println("\n");
                    System.out.printf("%s%10s%10s%20s%20s%20s\n", "ID", "FK", "UNIT", "SUBJECT", "TIME", "DAY/S");
                    for (ArrayList<File> f : register.schedule) {
                        System.out.printf("%d", f.get(0).getFile_ID());
                        System.out.printf("%10d", f.get(0).fk);
                        System.out.printf("%10d", f.get(0).unit);
                        System.out.printf("%20s", f.get(0).subject);
                        System.out.printf("%20s", f.get(0).time);
                        System.out.printf("%20s\n", f.get(0).days);
                    }
                }
            }

            if (cruds.toLowerCase().equals("u")) {

                System.out.println("[1]\tPersonal Information");
                System.out.println("[2]\tSchedule");

                while (true) {
                    System.out.print("choice : ");
                    int updateChoice = intInput.nextInt();

                    if (updateChoice == 1) {
                        System.out.print("Enter ID : ");
                        int id = intInput.nextInt();
                        
                        //loop the update
                        boolean check = false;
                        for(ArrayList<PersonalInformation> pf : register.info){
                            if(pf.get(0).id == id){
                                check = true;
                            }
                        }
                        
                        if(!check){
                            information.id = id;
                            information.fk = id;
                            personalInformationFiles.add(information);
                            register.info.add(personalInformationFiles);
                        }

                        for (ArrayList<PersonalInformation> pf : register.info) {
                            if (pf.get(0).id == id) {
                                while (true) {
                                    System.out.print("First Name: ");
                                    firstName = stringInput.nextLine();
                                    if (information.setFirstName(firstName)) {
                                        register.info.get(register.info.indexOf(pf)).get(0).firstName = firstName;
                                        break;
                                    }
                                }
                                while (true) {
                                    System.out.print("Middle Name: ");
                                    middleName = stringInput.nextLine();
                                    if (information.setMiddleName(middleName)) {
                                        register.info.get(register.info.indexOf(pf)).get(0).middleName = middleName;
                                        break;
                                    }
                                }

                                while (true) {
                                    System.out.print("Last Name: ");
                                    lastName = stringInput.nextLine();
                                    if (information.setLastName(lastName)) {
                                        register.info.get(register.info.indexOf(pf)).get(0).lastName = lastName;
                                        break;
                                    }
                                }

                                while (true) {
                                    System.out.print("Age : ");
                                    age = stringInput.nextLine();
                                    if (information.setAge(age)) {
                                        register.info.get(register.info.indexOf(pf)).get(0).age = Integer.parseInt(age);
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    } else if (updateChoice == 2) {
                        System.out.print("Enter ID : ");
                        int id = intInput.nextInt();
                        
                        //loop the update
                        boolean check = false;
                        for(ArrayList<File> f : register.schedule){
                            if(f.get(0).file_ID == id){
                                check = true;
                            }
                        }
                        
                        if(!check){
                            course.file_ID = id;
                            course.fk = id;
                            courseFile.add(course);
                            register.schedule.add(courseFile);
                        }

                        for (ArrayList<File> f : register.schedule) {
                            if (f.get(0).file_ID == id) {

                                System.out.print("Subject : ");
                                subject = stringInput.nextLine();
                                register.schedule.get(register.schedule.indexOf(f)).get(0).subject = subject;

                                while (true) {
                                    System.out.print("Unit : ");
                                    unit = stringInput.nextLine();
                                    if (course.setUnit(unit)) {
                                        register.schedule.get(register.schedule.indexOf(f)).get(0).unit = Integer.parseInt(unit);
                                        break;
                                    }
                                }

                                System.out.print("Time : ");
                                time = stringInput.nextLine();
                                register.schedule.get(register.schedule.indexOf(f)).get(0).time = time;

                                System.out.print("Day/s : ");
                                days = stringInput.nextLine();
                                register.schedule.get(register.schedule.indexOf(f)).get(0).days = days;
                            }
                        }
                        break;
                    } else {
                        System.out.println("Invalid Input!");
                    }
                }
            }

            if (cruds.toLowerCase().equals("d")) {
                System.out.println("[1]\tPersonal Information");
                System.out.println("[2]\tSchedule");
                int deleteChoice;
                while (true) {
                    System.out.print("choice : ");
                    deleteChoice = intInput.nextInt();
                    if (deleteChoice == 1 || deleteChoice == 2) {
                        break;
                    } else {
                        System.out.println("Invalid Input!");
                    }
                }
                if (!register.info.isEmpty() && deleteChoice == 1) {
                    System.out.print("Enter ID : ");
                    int id = intInput.nextInt();
                    register.deletePersonalInformation(id);
                    
                } else if (!register.schedule.isEmpty() && deleteChoice == 2) {
                    System.out.print("Enter ID : ");
                    int id = intInput.nextInt();
                    register.deleteCourse(id);
                } else {
                    System.out.println("Empty Files!");
                }
            }

            if (cruds.toLowerCase().equals("s")) {
                register.save();
            }
            if(cruds.toLowerCase().equals("se")){
                System.out.println("[1]\tPersonal Information");
                System.out.println("[2]\tSchedule");

                while (true) {
                    System.out.print("choice : ");
                    int updateChoice = intInput.nextInt();

                    if (updateChoice == 1) {
                        System.out.print("Enter ID : ");
                        int id = intInput.nextInt();
                        for(ArrayList<PersonalInformation> pf : register.info){
                            if(pf.get(0).id == id){
                                System.out.println(pf.toString());
                                break;
                            }
                        }
                        break;
                    } else if (updateChoice == 2) {
                        System.out.print("Enter ID : ");
                        int id = intInput.nextInt();
                        for(ArrayList<File> f : register.schedule){
                            if(f.get(0).file_ID == id){
                                System.out.println(f.toString());
                                break;
                            }
                        }
                        break;
                    } else {
                        System.out.println("Invalid Input!");
                    }
                }
            }

            if (cruds.toLowerCase().equals("e")) {
                break;
            }
        }
    }

}
