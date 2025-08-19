package com.oop.groupone.bgpress_group1.Hemel;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ReportViewerController
{
    @javafx.fxml.FXML
    private TextField userIDField;
    @javafx.fxml.FXML
    private TextField roleField;
    @javafx.fxml.FXML
    private TextField nameField;
    @javafx.fxml.FXML
    private PasswordField passwordField;
    @javafx.fxml.FXML
    private Label statusLabel;

    private int userId;
    private String name;
    private String role = "ReportViewer";

    public boolean login(String username, String password) {
        return username != null && !username.isEmpty()
                && password != null && !password.isEmpty();
    }

    public void loadDasboard() {
        statusLabel.setText("Dashboard loaded successfully for " + name + "!");
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loginButton(ActionEvent actionEvent) {
        try {
            this.userId = Integer.parseInt(userIDField.getText());
        } catch (NumberFormatException e) {
            statusLabel.setText("Invalid User ID!");
            return;
        }

        this.name = nameField.getText();
        this.role = roleField.getText().isEmpty() ? "ReportViewer" : roleField.getText();

        String username = nameField.getText();
        String password = passwordField.getText();

        if (login(username, password)) {
            statusLabel.setText("Login successful! Welcome " + username);
        } else {
            statusLabel.setText("Login failed. Please try again.");
        }
    }

    @javafx.fxml.FXML
    public void loadDashBoardButton(ActionEvent actionEvent) {
        loadDasboard();
    }

    @javafx.fxml.FXML
    public void nextOnButton(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("RVLoginPage.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }
}