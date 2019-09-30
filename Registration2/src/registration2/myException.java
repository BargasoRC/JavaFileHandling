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
class myException extends Exception{

    public myException(String invalid_user_name) {
        System.out.println(invalid_user_name);
    }
}
