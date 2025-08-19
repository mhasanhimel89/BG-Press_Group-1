package com.oop.groupone.bgpress_group1.Hemel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SOLoginPageController
{
    @javafx.fxml.FXML
    private TextField userIdField;
    @javafx.fxml.FXML
    private ComboBox<String> accountTypeCB;
    @javafx.fxml.FXML
    private TextField passwordField;
    @javafx.fxml.FXML
    private Button loginbuttononaction;
    @javafx.fxml.FXML
    private Button createaccountbuttononaction;

    @javafx.fxml.FXML
    public void initialize() {
        accountTypeCB.getItems().addAll("Admin", "Staff", "Customer");
    }

    @javafx.fxml.FXML
    public void createaccountbuttononaction(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("SODashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();

        System.out.println("Create Account button clicked");
    }

    @FXML
    public void loginbuttononaction(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("SecurityOfficer.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();

        String accountType = accountTypeCB.getValue();
        String userId = userIdField.getText();
        String password = passwordField.getText();

        System.out.println("Login Attempt:");
        System.out.println("Account Type: " + accountType);
        System.out.println("User ID: " + userId);
        System.out.println("Password: " + password);
    }
}