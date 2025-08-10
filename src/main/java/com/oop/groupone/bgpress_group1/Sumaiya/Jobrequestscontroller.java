package com.oop.groupone.bgpress_group1.Sumaiya;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Jobrequestscontroller
{
    @javafx.fxml.FXML
    private MenuBar menubar;


    private static ObservableList<assignjobClass> staticJobRequestList;
    @javafx.fxml.FXML
    private TableColumn<assignjobClass, String> staffidcolumn;
    @javafx.fxml.FXML
    private TableColumn<assignjobClass, String> jobnamecolumn;
    @javafx.fxml.FXML
    private TableView<assignjobClass> tableview;
    @javafx.fxml.FXML
    private TableColumn<assignjobClass, LocalDate> datecolumn;

    private ObservableList<assignjobClass> jobRequestList;
    @javafx.fxml.FXML
    private Label alertlabel;


    public static void addJobRequestStatic(assignjobClass newRequest) {
        if (staticJobRequestList != null) {
            staticJobRequestList.add(newRequest);
            jobstorageclass.saveRequests(new ArrayList<>(staticJobRequestList));
        }
        System.out.println("Saving job request: " + newRequest.getJobname());

    }

    @javafx.fxml.FXML
    public void initialize() {
        jobnamecolumn.setCellValueFactory(new PropertyValueFactory<>("jobtype"));
        staffidcolumn.setCellValueFactory(new PropertyValueFactory<>("assignstaff"));
        datecolumn.setCellValueFactory(new PropertyValueFactory<>("duedate"));
        List<assignjobClass> loadedRequests = jobstorageclass.loadRequests();
        jobRequestList= FXCollections.observableArrayList(loadedRequests);
        staticJobRequestList = jobRequestList;
        tableview.setItems(jobRequestList);
    }

    public void addJobRequest(assignjobClass newRequest) {
        jobRequestList.add(newRequest);
        jobstorageclass.saveRequests(jobRequestList);

    }

    @javafx.fxml.FXML
    public void reject(ActionEvent actionEvent) {
        assignjobClass selected = tableview.getSelectionModel().getSelectedItem();
        if (selected != null) {
            jobRequestList.remove(selected);
            jobstorageclass.saveRequests(new ArrayList<>(jobRequestList));
            alertlabel.setText("Request rejected and removed.");
        } else {
            alertlabel.setText("Please select a request to reject.");
        }
    }

    @javafx.fxml.FXML
    public void approve(ActionEvent actionEvent) {

        assignjobClass selected = tableview.getSelectionModel().getSelectedItem();
        if (selected != null) {
            jobRequestList.remove(selected);
            jobstorageclass.saveRequests(new ArrayList<>(jobRequestList));
            alertlabel.setText("Request approved and removed.");
        } else {
            alertlabel.setText("Please select a request to approve.");
        }
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
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root= FXMLLoader.load(getClass().getResource("hmdashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }
}