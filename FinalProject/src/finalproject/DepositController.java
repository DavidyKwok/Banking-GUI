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
public class DepositController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Customer customer = FinalProject.customer;
    @FXML
    private Label accountLevel;
    @FXML
    private Label accountBalance;
    @FXML
    private TextField depositText;
    
    @FXML
    private Text name;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        accountLevel.setText(customer.getAccount().getLevel().toString());
        accountBalance.setText(customer.getAccount().toString());
        name.setText("Welcome, "+customer.getUsername());
    }    
     @FXML
    public void widthdrawSceneAction(ActionEvent event)throws Exception{
        makeScene.changeScene(getClass(),event,"Withdraw.fxml"); 
    }

    @FXML
    public void makePurchaseSceneAction(ActionEvent event)throws Exception{
        makeScene.changeScene(getClass(),event,"MakePurchase.fxml");
    }
    
    @FXML
    public void depositAction(ActionEvent event){
        try{
            double amount = Double.parseDouble(depositText.getText());
            customer.getAccount().getLevel().deposit(amount);
            accountLevel.setText(customer.getAccount().getLevel().toString());
            accountBalance.setText(customer.getAccount().toString());
            depositText.clear();
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Deposit Error");
            alert.setContentText("Please Enter a valid number.");
            alert.showAndWait();
        }
    }
    @FXML
    private void logoutAction(ActionEvent event) throws Exception{
      makeScene.changeScene(getClass(),event,"LoginPage.fxml");
    }
}
