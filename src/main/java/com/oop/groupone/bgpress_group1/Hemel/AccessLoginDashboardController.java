package com.oop.groupone.bgpress_group1.Hemel;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class AccessLoginDashboardController
{
    @javafx.fxml.FXML
    private TextField usernameField;
    @javafx.fxml.FXML
    private Button validateCredentialsButton;
    @javafx.fxml.FXML
    private Button loadReportViewerDashboardButton;
    @javafx.fxml.FXML
    private PasswordField passwordField;
    @javafx.fxml.FXML
    private CheckBox isValidNoCB;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private CheckBox isValidYesCB;

    private String username;
    private String password;
    private boolean isValid;

    @javafx.fxml.FXML
    public void initialize() {
        isValidYesCB.setOnAction(e -> {
            if (isValidYesCB.isSelected()) {
                isValidNoCB.setSelected(false);
                isValid = true;
            }
        });

        isValidNoCB.setOnAction(e -> {
            if (isValidNoCB.isSelected()) {
                isValidYesCB.setSelected(false);
                isValid = false;
            }
        });

        validateCredentialsButton.setOnAction(e -> validateCredentials());
        loadReportViewerDashboardButton.setOnAction(e -> loadReportViewerDashboard());
    }

    public boolean validateCredentials() {
        username = usernameField.getText();
        password = passwordField.getText();

        if (username.equals("admin") && password.equals("1234")) {
            isValidYesCB.setSelected(true);
            isValidNoCB.setSelected(false);
            isValid = true;
            statusLabel.setText("Login Successful!");
            return true;
        } else {
            isValidYesCB.setSelected(false);
            isValidNoCB.setSelected(true);
            isValid = false;
            statusLabel.setText("Invalid username or password.");
            return false;
        }
    }


    public void loadReportViewerDashboard() {
        if (isValid) {
            statusLabel.setText("Loading Report Viewer Dashboard...");
        } else {
            statusLabel.setText("Access denied. Please log in first");
        }
    }


    @javafx.fxml.FXML
    public void nextOnButton(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("ViewIncidentReports.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void backOnButton(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("RVDashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }
}