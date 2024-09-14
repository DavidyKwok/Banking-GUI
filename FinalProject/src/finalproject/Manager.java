/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import javafx.scene.control.Alert;
/**
 *
 * @author David
 */
public class Manager extends User {
   
   private final String role = "Manager";
   public ArrayList<Customer> customerList;
   public Customer customer = FinalProject.customer;
   private File file;
   public Manager(){
       this.customerList = new ArrayList();
       getCustomerList();
   }
   public Customer getCustomer(String username){
       for(Customer i: customerList){
           if(i.getUsername().equals(username)){
               return (i);
           }
       }
       return(null);
   }

   public void createCustomer(String username, String password, BankAccount account){
    try {
        file = new File("src/customerFiles",username+".txt");
        if (file.exists()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Files");
            alert.setContentText("File already exists.");
            alert.showAndWait();
        } else {
            if (file.createNewFile()) {
                    System.out.println("File created");
            } else {
                System.out.println("Failed to create file.");
            }
        }
        FileWriter writer = new FileWriter(file);
        writer.write("Level: "+account.getLevel());
        writer.write(System.lineSeparator());
        writer.write("Username: "+username);
        writer.write(System.lineSeparator());
        writer.write("Password: "+password);
        writer.write(System.lineSeparator());
        writer.write("Balance: "+account.getBalance());  
        writer.close();
    } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
    }
   public void deleteCustomer(String username) {
    File file = new File("src/customerFiles", username + ".txt");
    
    if (file.exists()) {
        file.delete();
        customerList.remove(this.getCustomer(username));
        System.out.println("File deleted successfully.");
    } else {
        System.out.println("File not found.");
    }
    }
   
    public ArrayList readFile(String username) {
    ArrayList<String> data = new ArrayList();
    try {
        File file = new File("src/customerFiles", username);
        Scanner scanner = new Scanner(file);
        String usernames = "";
        String passwords = "";
        String balance = "";

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.startsWith("Username: ")) {
                usernames = line.substring(10); 
            } else if (line.startsWith("Password: ")) {
                passwords = line.substring(10);
            } else if (line.startsWith("Balance: ")) {
                balance = line.substring(9);
            }
        }
        scanner.close();
    data.add(usernames);
    data.add(passwords);
    data.add(balance);
    } catch (IOException e) {
        System.out.println("An error occurred.");
    }
    return(data);
    }
    
    public void getCustomerList(){
        customerList.clear();
         ArrayList<String> data;
         Customer cus;
         File folder = new File("src/customerFiles");
         File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                   data = this.readFile(file.getName());
                   BankAccount account = new BankAccount(Double.parseDouble(data.get(2)));
                   cus = new Customer(data.get(0),data.get(1),account.findLevel());
                   customerList.add(cus);
                }
            }
        }
    }
    public void updateFile(String username,BankAccount account){
        Customer cus = this.getCustomer(username);
        deleteCustomer(username);
        createCustomer(username,cus.getPassword(),account);
        getCustomerList();
    }
   
   
}
