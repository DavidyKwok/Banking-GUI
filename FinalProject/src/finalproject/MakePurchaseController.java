/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package finalproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author David
 */
public class MakePurchaseController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Customer customer = FinalProject.customer;
    @FXML
    private Label accountLevel;
    @FXML
    private Label accountBalance;
    @FXML
    private Text name;
    @FXML
    private TextField purchaseText;
    @FXML Text fee;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        accountLevel.setText(customer.getAccount().getLevel().toString());
        accountBalance.setText(customer.getAccount().toString());
        name.setText("Welcome, "+customer.getUsername());
        if(customer.getAccount().getLevel().toString().equals("Silver")){
        fee.setText("There is a fee of $20 applied to your purchase amount");
        }else if(customer.getAccount().getLevel().toString().equals("Gold")){
            fee.setText("There is a fee of $10 applied to your purchase amount");
        }
    }    
    @FXML
    public void widthdrawSceneAction(ActionEvent event)throws Exception{
        makeScene.changeScene(getClass(),event,"Withdraw.fxml");
       
    }
    @FXML
    public void depositSceneAction(ActionEvent event)throws Exception{
        makeScene.changeScene(getClass(),event,"Deposit.fxml");
    }
    @FXML
    public void purchaseAction(ActionEvent event){
        try{
            double amount = Double.parseDouble(purchaseText.getText());
            customer.getAccount().getLevel().purchase(amount);
            accountLevel.setText(customer.getAccount().getLevel().toString());
            accountBalance.setText(customer.getAccount().toString());
            purchaseText.clear();
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Purchase Error");
            alert.setContentText("Please Enter a valid number.");
            alert.showAndWait();
        }
        if(customer.getAccount().getLevel().toString().equals("Silver")){
        fee.setText("There is a fee of $20 applied to your purchase amount");
        }else if(customer.getAccount().getLevel().toString().equals("Gold")){
            fee.setText("There is a fee of $10 applied to your purchase amount");
        }
    }
    @FXML
    private void logoutAction(ActionEvent event) throws Exception{
      makeScene.changeScene(getClass(),event,"LoginPage.fxml");
    }

}
