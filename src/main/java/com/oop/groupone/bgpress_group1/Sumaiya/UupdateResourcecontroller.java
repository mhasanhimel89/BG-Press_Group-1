package com.oop.groupone.bgpress_group1.Sumaiya;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class UupdateResourcecontroller
{
    @javafx.fxml.FXML
    private MenuBar menubar;
    @javafx.fxml.FXML
    private ComboBox resourcecb;
    @javafx.fxml.FXML
    private TableColumn itemscolumn;
    @javafx.fxml.FXML
    private TableView tableview;
    @javafx.fxml.FXML
    private TextField quantitytf;
    @javafx.fxml.FXML
    private TextArea budgetta;
    @javafx.fxml.FXML
    private TableColumn quantitycolumn;
    @javafx.fxml.FXML
    private TextField upbudgettf;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void updatebutton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void save(ActionEvent actionEvent) {
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
}