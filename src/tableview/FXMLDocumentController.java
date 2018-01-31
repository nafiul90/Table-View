/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableview;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author nafiul
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TableView<Person> tableView;
    @FXML
    private TableColumn<Person, String> name;
    @FXML
    private TableColumn<Person, Integer> id;
    @FXML
    private TableColumn<Person, Double> salary;
    
    
    ObservableList<Person>list=FXCollections.observableArrayList(
    
            new Person("Abul",1,50000),
            new Person("Babul",2,50000),
            new Person("Ratul",3,50000),
            new Person("Butul",4,50000),
            new Person("Putul",5,50000)
    
    );
    @FXML
    private TextField nameField;
    @FXML
    private TextField idField;
    @FXML
    private TextField salaryField;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        name.setCellValueFactory(new PropertyValueFactory<Person,String>("name"));
        id.setCellValueFactory(new PropertyValueFactory<Person,Integer>("id"));
        salary.setCellValueFactory(new PropertyValueFactory<Person,Double>("salary"));
        
        tableView.setItems(list);
        
    }    

    @FXML
    private void addPersonButtonAction(ActionEvent event) {
        
        String name=nameField.getText();
        int id=Integer.parseInt(idField.getText());
        double salary=Double.parseDouble(salaryField.getText());
        
        //Person person=new Person(name,id,salary);
        list.add(new Person(name,id,salary));
        
        nameField.clear();
        idField.clear();
        salaryField.clear();
        
        
        
    }

    @FXML
    private void deleteButttonAction(ActionEvent event) {
        
        //Person person=tableView.getSelectionModel().getSelectedItem();
        //list.remove(person);
        
        ObservableList<Person>selectedItems=FXCollections.observableArrayList();
        selectedItems=tableView.getSelectionModel().getSelectedItems();
        list.removeAll(selectedItems);
        
    }
    
}
