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
public abstract class Level {
    BankAccount account;
    public Level(BankAccount account){
        this.account = account;
    }
    public  void withdraw(double amount){
        Manager manager = FinalProject.manager;
        Customer customer = FinalProject.customer;
        double balance = account.getBalance();
        if(amount>balance||amount<0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Withdraw Error");
            alert.setContentText("Can't withdraw more than your balance or a negative amount!");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmation");
            alert.setContentText("You have withdrawn $"+amount);
            alert.showAndWait();
        account.subBalance(amount);
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
    public void deposit(double amount){
        Manager manager = FinalProject.manager;
        Customer customer = FinalProject.customer;
        double balance = account.getBalance();
        if(amount<0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Deposit Error");
            alert.setContentText("Can't deposit a negative amount!");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmation");
            alert.setContentText("You have deposited $"+amount);
            alert.showAndWait();
            account.addBalance(amount);
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
    public abstract void purchase(double amount);

}
