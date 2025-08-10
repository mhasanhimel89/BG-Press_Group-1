package com.oop.groupone.bgpress_group1.Sumaiya;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Schedulecontroller
{
    @javafx.fxml.FXML
    private TableColumn<assignjobClass, String> assignedstaffcolumn;
    @javafx.fxml.FXML
    private MenuBar menubar;
    @javafx.fxml.FXML
    private TableColumn<assignjobClass, String> jobnamecolumn;
    @javafx.fxml.FXML
    private TableView<assignjobClass> tableview;
    @javafx.fxml.FXML
    private TableColumn<assignjobClass, LocalDate> duedatecolumn;
    @javafx.fxml.FXML
    private TableColumn<assignjobClass,String> progresscolumn;

    @javafx.fxml.FXML
    public void initialize() {
        jobnamecolumn.setCellValueFactory(new PropertyValueFactory<>("jobname"));
        assignedstaffcolumn.setCellValueFactory(new PropertyValueFactory<>("assignstaff"));
        duedatecolumn.setCellValueFactory(new PropertyValueFactory<>("duedate"));
        progresscolumn.setCellValueFactory(new PropertyValueFactory<>("progress"));

        loadTableData();
    }

    private void loadTableData() {
        List<assignjobClass> jobs = jobstorageclass.loadJobs();
        ObservableList<assignjobClass> observableJobs = FXCollections.observableArrayList(jobs);
        tableview.setItems(observableJobs);
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
    public void hmanagerdashboardoa(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root= FXMLLoader.load(getClass().getResource("hmdashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();

    }


    @javafx.fxml.FXML
    public void Loadoa(ActionEvent actionEvent) {
        //loadTableData();
    }
}