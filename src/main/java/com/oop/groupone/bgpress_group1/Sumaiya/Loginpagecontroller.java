package com.oop.groupone.bgpress_group1.Sumaiya;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Loginpagecontroller
{
    @javafx.fxml.FXML
    private PasswordField passwordtextfield;
    @javafx.fxml.FXML
    private Label alertlabel;
    @javafx.fxml.FXML
    private ComboBox<String> accountypecb;
    @javafx.fxml.FXML
    private TextField useridTextfield;
    @javafx.fxml.FXML
    private Button createaccbuttononaction;
    @javafx.fxml.FXML
    private Button loginbuttononaction;

    @javafx.fxml.FXML
    public void initialize() {
        accountypecb.getItems().addAll("Head Manager","BG Staff");
    }

    @javafx.fxml.FXML
    public void createaccbuttononaction(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root= FXMLLoader.load(getClass().getResource("createAccPage.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();


    }

    @javafx.fxml.FXML
    public void loginbuttononaction(ActionEvent actionEvent) throws Exception {

            String userId = useridTextfield.getText();
            String password = passwordtextfield.getText();
            String accountype= accountypecb.getValue().toString();

            try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 7) {
                        String storedUserId = parts[0];
                        String storedPassword = parts[5];
                        String role = parts[6];

                        if (userId.equals(storedUserId) && password.equals(storedPassword)) {

                            System.out.println("Read user: " + storedUserId + ", role: " + role);

                            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                            Parent root = null;

                            if (role.equalsIgnoreCase("Head Manager") && accountype.equals(role)) {

                                URL fxmlUrl = getClass().getResource("hmdashboard.fxml");
                                if (fxmlUrl == null) {
                                    alertlabel.setText("Head Manager FXML not found!");
                                    return;
                                }
                                root = FXMLLoader.load(fxmlUrl);
                                stage.setTitle("Head Manager Dashboard");


                            } else if (role.equalsIgnoreCase("Bg Staff") && accountype.equals(role) ) {
                                URL fxmlUrl = getClass().getResource("BGStaff.fxml");
                                if (fxmlUrl == null) {

                                    alertlabel.setText("Bg Staff FXML not found.");
                                    return;
                                }
                                root = FXMLLoader.load(fxmlUrl);
                                stage.setTitle("BG Staff");
                            }



                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();
                            return;
                        }
                    }
                }

                alertlabel.setText("Login failed: Invalid user ID or password.");
            } catch (IOException e) {
                e.printStackTrace();
                alertlabel.setText("Error reading user file.");
            }
        }


}


