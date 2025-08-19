package com.oop.groupone.bgpress_group1.Hemel;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RVLoginPageController
{
    @javafx.fxml.FXML
    private TextField userIdField;
    @javafx.fxml.FXML
    private ComboBox<String> accountTypeCB;
    @javafx.fxml.FXML
    private Button loginOnAction;
    @javafx.fxml.FXML
    private Button createAccountOnAction;
    @javafx.fxml.FXML
    private PasswordField passwordField;

    @javafx.fxml.FXML
    public void initialize() {
        accountTypeCB.getItems().addAll("Admin", "Doctor", "Patient", "Staff");
    }

    @javafx.fxml.FXML
    public void createAccountOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("RVDashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();


        System.out.println("Create Account button clicked");
    }

    @javafx.fxml.FXML
    public void loginOnAction(ActionEvent actionEvent) throws IOException {

        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("ReportViewer.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();

        String accountType = accountTypeCB.getValue();
        String userId = userIdField.getText();
        String password = passwordField.getText();

        System.out.println("Login attempted with:");
        System.out.println("Account Type: " + accountType);
        System.out.println("User ID: " + userId);
        System.out.println("Password: " + password);
    }

    @javafx.fxml.FXML
    public void accessLoginDashboardOnButton(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AccessLoginDashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }
}