/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package name.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import name.be.People;
import name.gui.model.MainViewModel;

/**
 * FXML Controller class
 *
 * @author Captain
 */
public class AddNameViewController implements Initializable {

    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private Button saveBtn;
    @FXML
    private Button cancelBtn;
    private MainViewModel mvm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            mvm = MainViewModel.getInstance();
                    } catch (IOException ex) {
            Logger.getLogger(AddNameViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void saveName(ActionEvent event) {
        People people = new People();
        people.setName(txtFirstName.getText());
        people.setLastName(txtLastName.getText());
        mvm.pList.add(people);
        
        Stage stage = (Stage) saveBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void cancelBtn(ActionEvent event) {
        
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }
    
}
