package com.oop.groupone.bgpress_group1.Sumaiya;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Requestnewjobcontroller
{
    @javafx.fxml.FXML
    private TextField jobnametf;
    @javafx.fxml.FXML
    private TextField staffidtf;
    @javafx.fxml.FXML
    private DatePicker datepick;
    @javafx.fxml.FXML
    private Label datepicker;
    @javafx.fxml.FXML
    private Label alertlabel;

    @javafx.fxml.FXML
    public void initialize() {
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
    public void requestbutton(ActionEvent actionEvent) {

        String jobName = jobnametf.getText();
        String staffId = staffidtf.getText();
        LocalDate date = datepick.getValue();

        if (jobName.isEmpty() || staffId.isEmpty() || date == null) {
            alertlabel.setText("Fill all fields!");
            return;
        }
        assignjobClass newRequest = new assignjobClass(jobName, staffId,"n","n" ,date);
        List<assignjobClass> requests = jobstorageclass.loadRequests();
        requests.add(newRequest);
        jobstorageclass.saveRequests(requests);

        alertlabel.setText("Request sent!");
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