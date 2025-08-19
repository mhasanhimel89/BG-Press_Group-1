package com.oop.groupone.bgpress_group1.Hemel;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SecurityOfficerController
{
    @javafx.fxml.FXML
    private TextField userIDField;
    @javafx.fxml.FXML
    private TextField roleField;
    @javafx.fxml.FXML
    private TextField nameField;
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loginButton(ActionEvent actionEvent) {
        try {
            String userIDText = userIDField.getText();
            String name = nameField.getText();
            String role = roleField.getText();

            if (userIDText.isEmpty() || name.isEmpty() || role.isEmpty()) {
                statusLabel.setText("Please fill in all fields.");
                return;
            }

            int userId;
            try {
                userId = Integer.parseInt(userIDText);
            } catch (NumberFormatException e) {
                statusLabel.setText("User ID must be a number");
                return;
            }

            if (validateLogin(userId, name, role)) {
                statusLabel.setText("Login successful! Welcome, " + name + ".");
            } else {
                statusLabel.setText("Login failed. Invalid credentials.");
            }


        } catch (Exception e) {
            statusLabel.setText("An error occurred during login.");
            e.printStackTrace();
        }
    }

    private boolean validateLogin(int userId, String name, String role) {
        return userId  == 101 && name.equalsIgnoreCase("Admin") && role.equalsIgnoreCase("Security");
    }


    @javafx.fxml.FXML
    public void nextOnButton(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("SOLoginPage.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void MaintainPhysicalEnvironmentOnButton(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MaintainPhysicalEnvironment.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }
}