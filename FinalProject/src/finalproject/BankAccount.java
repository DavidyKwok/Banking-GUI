/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;

/**
 *
 * @author David
 */
public class BankAccount {
    private Level level;
    private double balance = 100.00;
    public BankAccount (double balance){
        this.balance = balance;
        setLevel(new Silver(this));
    }
    public double getBalance(){
        return balance;
    }
    public void addBalance(double balance){
        this.balance += balance;
    }
    public void subBalance(double balance){
        this.balance -= balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public void setLevel(Level level){
        this.level = level;
    }
    public Level getLevel(){
        return level;
    }
    public BankAccount findLevel(){
         if(balance<10000){
           this.setLevel(new Silver(this));
        }else if(balance>=10000 && balance<20000){
           this.setLevel(new Gold(this));
        }else{
            this.setLevel(new Platinum(this));
        }
        return this;
    }
    @Override
    public String toString(){
        return String.format("%.2f",balance);
    }

}
