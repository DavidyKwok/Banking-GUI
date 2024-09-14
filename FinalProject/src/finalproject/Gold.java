/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;

import javafx.scene.control.Alert;

/**
 *
 * @author David
 */
public class Gold extends Level{
    public Gold(BankAccount account){
        super(account);
    }
    
    @Override
    public void purchase(double amount){
        Manager manager = FinalProject.manager;
        Customer customer = FinalProject.customer;
        if(amount<50){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Purchase Error");
            alert.setContentText("Amount has to be greater than $50!");
            alert.showAndWait();
        }else{
        double balance = account.getBalance();
        if(amount>balance||amount<0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Purchase Error");
            alert.setContentText("Can't purchase more than your balance!");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmation");
            alert.setContentText("You have made a purchase for $"+(amount+10));
            alert.showAndWait();
        account.subBalance(amount+10);
        balance = account.getBalance();
        if(balance<10000){
           account.setLevel(new Silver(account));
        }else if(balance>=10000 && balance<20000){
           account.setLevel(new Gold(account));
        }else{
            account.setLevel(new Platinum(account));
           
        }
        }
        manager.updateFile(customer.getUsername(),account);
    }
    }
    
    
    @Override
    public String toString(){
        return("Gold");
    }

}

