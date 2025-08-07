package com.oop.groupone.bgpress_group1.Sumaiya;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Reportmachineissuescontroller
{
    @javafx.fxml.FXML
    private TextField jobnametf;
    @javafx.fxml.FXML
    private TableColumn issuetypecolumn;
    @javafx.fxml.FXML
    private ComboBox issuetypecob;
    @javafx.fxml.FXML
    private TextArea problemta;
    @javafx.fxml.FXML
    private TableColumn jobnamecolumn;
    @javafx.fxml.FXML
    private TableView tableview;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void submit(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void signout(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root= FXMLLoader.load(getClass().getResource("loginpage.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void home(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("BGStaff.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }
}