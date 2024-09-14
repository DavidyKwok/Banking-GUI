/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package finalproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author David
 */
public class LoginPageController implements Initializable {
    @FXML
    private Label label;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private ComboBox<String> roleBox= new ComboBox<>();
    private String roles[] = {"Manager","Customer"};
    private Manager manager = FinalProject.manager;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        roleBox.getItems().addAll(roles);
        
    }
    @FXML
    private void signInAction(ActionEvent event) throws Exception {
   
    String usernameField = username.getText();
    String passwordField = password.getText();
    String role =  roleBox.getValue();
    try{
    if(role == null){
        throw new Exception();
    }
    }catch(Exception e){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Error");
        alert.setContentText("Please select a role");
        alert.showAndWait();
    }
  
    if(role != null){
    if(role.equals( "Manager")){
         if (usernameField.equals("admin") && passwordField.equals("admin")) {
      
        makeScene.changeScene(getClass(), event, "ManagerControls.fxml");
    } else {
        error();
    }
    }else{
      try{
        if (usernameField.equals(manager.getCustomer(usernameField).getUsername()) && passwordField.equals(manager.getCustomer(usernameField).getPassword())) {
        FinalProject.customer= manager.getCustomer(usernameField);
        
        makeScene.changeScene(getClass(), event, "Withdraw.fxml");
       }else {
        error();
       }
      }catch(Exception e){
       error();
       }
  }
    
    }
    
    
 
    
}
    private void error(){
         Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Error");
        alert.setHeaderText(null);
        alert.setContentText("Incorrect username or password!");
        alert.showAndWait();
    }
}
