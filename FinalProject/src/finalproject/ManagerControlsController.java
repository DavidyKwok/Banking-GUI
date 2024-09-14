/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package finalproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author David
 */
public class ManagerControlsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     deleteBox.getItems().addAll(manager.customerList);
    }
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private ComboBox<Customer> deleteBox= new ComboBox<>();
    private String usernames;
    private String passwords;
    
    Manager manager = FinalProject.manager;
    @FXML
    private void createAction(ActionEvent event) throws IOException{
        deleteBox.getItems().clear();
        String usernames = username.getText();
        String passwords = password.getText();
        manager.createCustomer(usernames,passwords,new BankAccount(100));
        manager.getCustomerList();
        deleteBox.getItems().addAll(manager.customerList);
     
    }
    @FXML
    private void deleteAction(ActionEvent event){
        Customer delete = deleteBox.getValue();
        for (Customer i : manager.customerList) {
            if (delete == i) {
                manager.customerList.remove(i);
                deleteBox.getItems().remove(delete);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Confirmation");
                alert.setContentText("The Account with "+delete.toString()+" has been deleted.");
                alert.showAndWait();
                break;
            }
        }
        manager.deleteCustomer(delete.getUsername());
    }
    @FXML
    private void logoutAction(ActionEvent event) throws Exception{
      FinalProject.manager = manager;
      makeScene.changeScene(getClass(),event,"LoginPage.fxml");
    }

}
