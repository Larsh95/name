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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import name.be.People;
import name.gui.model.MainViewModel;

/**
 * FXML Controller class
 *
 * @author Captain
 */
public class MainViewController implements Initializable {

    @FXML
    private TableView<People> nList;
    @FXML
    private TableColumn<People, String> name;
    @FXML
    private TableColumn<People, String> lname;
    @FXML
    private Button addbtn;
    @FXML
    private Button delbtn;
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
                
        name.setCellValueFactory(new PropertyValueFactory("name"));
        lname.setCellValueFactory(new PropertyValueFactory("lastName"));
        nList.setItems(mvm.getAllPeople());
    }    

    @FXML
    private void addbtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/name/gui/view/AddNameView.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        Stage stage = new Stage();

        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void delbtn(ActionEvent event) {
       People people = nList.getSelectionModel().getSelectedItem();
       mvm.getAllPeople().remove(people);
    }
    
}
