package com.oop.groupone.bgpress_group1.Sumaiya;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Reportmachineissuescontroller
{
    @javafx.fxml.FXML
    private ComboBox issuetypecob;
    @javafx.fxml.FXML
    private TextArea problemta;
    @javafx.fxml.FXML
    private TextField machineidtf;

    private static final String FILE_NAME = "issues.bin";
    @javafx.fxml.FXML
    private Label alertlabel;

    @javafx.fxml.FXML
    public void initialize() {
        issuetypecob.getItems().addAll("Paper Jam", "Low Ink / Toner" ,"Printing Misalignment", "Overheating",
                "Strange Noise", "Software Error", "Network Connection Issue", "Power Failure", "Slow Performance",
                "Other");
    }

    @javafx.fxml.FXML
    public void submit(ActionEvent actionEvent) {
        String machineId = machineidtf.getText();
        String issueType = issuetypecob.getValue().toString();
        String description = problemta.getText();

        if (machineId.isEmpty() || issueType==null) {
            alertlabel.setText("Please fill all fields.");
            return;
        }

        MachineIssue issue = new MachineIssue(machineId, issueType, description);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME, true))) {
            oos.writeObject(issue);
            alertlabel.setText("Issue saved successfully!");
        } catch (IOException e) {
          alertlabel.setText("Something went wrong");
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
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("BGStaff.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }
}