package com.oop.groupone.bgpress_group1.Sumaiya;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Submitworkcontroller
{
    @javafx.fxml.FXML
    private ComboBox<String> jobCombobox;
    @javafx.fxml.FXML
    private TextArea remarksArea;
    @javafx.fxml.FXML
    private TextField filePathFied;
    @javafx.fxml.FXML
    private Label alertlabel;

    @javafx.fxml.FXML
    public void initialize() {
        jobCombobox.getItems().addAll("Print", "Edit","Writing","Compose","Design","Error Checker");
    }

    @javafx.fxml.FXML
    public void handleCancel(ActionEvent actionEvent) {
        filePathFied.clear();
        jobCombobox = null;
        alertlabel.setText("cancelled submit");

    }

    @javafx.fxml.FXML
    public void handleSubmit(ActionEvent actionEvent) {
        String selectedJob = jobCombobox.getValue();
        String filePath = filePathFied.getText();
        String remarks = remarksArea.getText();

        if (selectedJob == null || filePath.isEmpty()) {
            alertlabel.setText("Please select a job and a file.");
        }
         alertlabel.setText("your work submitted successfully, Please Update now!");

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
    public void handleBrowse(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            filePathFied.setText(file.getAbsolutePath());
        }
    }

    @javafx.fxml.FXML
    public void home(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root= FXMLLoader.load(getClass().getResource("BGStaff.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void updateprogres(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root= FXMLLoader.load(getClass().getResource("updateProgress.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }
}