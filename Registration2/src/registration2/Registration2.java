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
                    continue;
                }
            }

            if (cruds.toLowerCase().equals("r")) {
                register.readFiles();
                if(register.accounts.isEmpty() && register.info.isEmpty() && register.schedule.isEmpty()){
                    System.out.println("Nothing to show!");
                }else{
                    
                }
            }

            if (cruds.toLowerCase().equals("u") && !register.accounts.isEmpty()) {
                while (true) {

                }
            }

            if (cruds.toLowerCase().equals("d") && !register.accounts.isEmpty()) {
                while (true) {

                }
            }

            if (cruds.toLowerCase().equals("s")) {
                register.save();
            }

            if (cruds.toLowerCase().equals("e")) {
                break;
            }
        }
    }

}
