/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;

/**
 *
 * @author David
 * 
 * This class represents a customer user in the system.
 * Responsibilities include managing their account.
 * This class is mutable.
 */
public class Customer extends User {
    private final String role = "Customer";
    private BankAccount account;
    public Customer(String username, String password,BankAccount account){
        this.username = username;
        this.password = password;
        this.account = account;
    }
   
    @Override
    public String toString(){
        return("Username: "+username+" Password: "+password);
    }
    
    public BankAccount getAccount(){
        return account;
    }
 

}
