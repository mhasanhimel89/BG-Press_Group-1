package com.oop.groupone.bgpress_group1.Sumaiya;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class UupdateResourcecontroller
{
    @javafx.fxml.FXML
    private MenuBar menubar;
    @javafx.fxml.FXML
    private TableView<validateBR> tableview;
    @javafx.fxml.FXML
    private TableColumn<validateBR,Integer> quantitycolumn;
    @javafx.fxml.FXML
    private TableColumn<validateBR,Double> budgetcolumn;
    @javafx.fxml.FXML
    private TableColumn<validateBR, String> resourcecolumn;
    @javafx.fxml.FXML
    private Label alertlabel;

    @javafx.fxml.FXML
    public void initialize() {
        resourcecolumn.setCellValueFactory(new PropertyValueFactory<>("resourcename"));
        quantitycolumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        budgetcolumn.setCellValueFactory(new PropertyValueFactory<>("budget"));
    }

    @javafx.fxml.FXML
    public void signut(ActionEvent actionEvent)  throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root= FXMLLoader.load(getClass().getResource("loginpage.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void home(ActionEvent actionEvent)  throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root= FXMLLoader.load(getClass().getResource("hmdashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void laod(ActionEvent actionEvent) {
        try(ObjectInputStream stream = new ObjectInputStream(new FileInputStream("validate.bin"))){
            while(true){

                validateBR load=(validateBR) stream.readObject();
                tableview.getItems().add(load);
            }

        }catch(EOFException e) {
            alertlabel.setText("Loaded");
        }catch (IOException e){
            alertlabel.setText("Couldn't Load");
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            alertlabel.setText("something went wrong");
            e.printStackTrace();
        }
    }
}