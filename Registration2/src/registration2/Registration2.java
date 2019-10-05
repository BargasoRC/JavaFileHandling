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
        ArrayList<Account> accountFiles = new ArrayList();
        ArrayList<PersonalInformation> personalInformationFiles = new ArrayList();
        ArrayList<File> courseFile = new ArrayList();
        String accountID = null;
        String userName = null;
        String passWord = null;
        String firstName = null;
        String lastName = null;
        String middleName = null;
        String age = null;
        
        /*
            create a method in the create file that will read the personal
            information's lines and Course's lines for their PK(ID) of each
            transaction
        */
        
        

        while (true) {
            System.out.println("C\t\tCreate");
            System.out.println("R\t\tRetrieve");
            System.out.println("U\t\tUpdate");
            System.out.println("D\t\tDelete");
            System.out.println("S\t\tSave");
            System.out.println("SE\t\tSearch");

            System.out.println("Choice: ");
            String cruds = stringInput.next();

            if (cruds.toLowerCase().equals("c")) {
                while (true) {
                    
                }
            }
            
            if(cruds.toLowerCase().equals("r")){
                while (true) {

                }
            }
            
            if(cruds.toLowerCase().equals("u") && !register.accounts.isEmpty()){
                while (true) {
                    
                }
            }
            
            if(cruds.toLowerCase().equals("d") && !register.accounts.isEmpty()){
                while (true) {

                }
            }
            
            if(cruds.toLowerCase().equals("s")){
                while (true) {

                }
            }
            
            break;
        }
    }

}
