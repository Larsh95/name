/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package name.gui.model;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import name.be.People;

/**
 *
 * @author Captain
 */
public class MainViewModel {
    public ObservableList<People> pList;
    private static MainViewModel instance;

    public MainViewModel() {
        pList = FXCollections.observableArrayList();
        
        }
    public void addPerson(People people){
     pList.add(people);
    }
    
        public static MainViewModel getInstance() throws IOException
    {
        if (instance == null)
        {
            instance = new MainViewModel();
        }
        return instance;
    }
    public ObservableList<People> getAllPeople() {
        return pList;
    
    }
    
}
