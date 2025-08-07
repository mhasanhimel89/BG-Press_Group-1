package com.oop.groupone.bgpress_group1.Sumaiya;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Schedulecontroller
{
    @javafx.fxml.FXML
    private TableColumn assignedstaffcolumn;
    @javafx.fxml.FXML
    private DatePicker choosedate;
    @javafx.fxml.FXML
    private TableColumn statuscolumn;
    @javafx.fxml.FXML
    private MenuBar menubar;
    @javafx.fxml.FXML
    private DatePicker duedate;
    @javafx.fxml.FXML
    private TableColumn jobnamecolumn;
    @javafx.fxml.FXML
    private TableView tableview;
    @javafx.fxml.FXML
    private TableColumn duedatecolumn;
    @javafx.fxml.FXML
    private TextField statustf;
    @javafx.fxml.FXML
    private TextField jobnametextfield;
    @javafx.fxml.FXML
    private TextField assignedstafftf;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void signoutoa(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root= FXMLLoader.load(getClass().getResource("loginpage.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();

    }

    @javafx.fxml.FXML
    public void saveoa(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void hmanagerdashboardoa(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root= FXMLLoader.load(getClass().getResource("hmdashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();

    }

    @javafx.fxml.FXML
    public void duedateoa(ActionEvent actionEvent) {
    }
}