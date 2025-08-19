package com.oop.groupone.bgpress_group1.Hemel;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LawEnforcementCoordinationController
{
    @javafx.fxml.FXML
    private TextField incidentTypeField;
    @javafx.fxml.FXML
    private CheckBox isCriticalYesCB;
    @javafx.fxml.FXML
    private CheckBox isCriticalNoCB;
    @javafx.fxml.FXML
    private Label resultLabel;
    @javafx.fxml.FXML
    private TextField agencyNameField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void sendIncidentReportOnButton(ActionEvent actionEvent) {
        boolean success = sendIncidentReport();
        if (success) {
            resultLabel.setText("Sent incident report successfully");
        } else {
            resultLabel.setText("Failed to send incident report");
        }
    }

    private boolean sendIncidentReport() {
        return true;
    }

    @javafx.fxml.FXML
    public void generateDigitalRequestOnButton(ActionEvent actionEvent) {
        String incidentType = incidentTypeField.getText();
        String agencyName = agencyNameField.getText();
        boolean isCritical = isCriticalYesCB.isSelected();
        boolean isCriticalNoCBSelected = isCriticalNoCB.isSelected();

        String request = generateDigitalRequest(incidentType, isCritical, agencyName);
        resultLabel.setText(request);
    }

    private String generateDigitalRequest(String incidentType, boolean isCritical, String agencyName) {
        return "Request: Incident Type - " + incidentType +
                ", Critical - " + (isCritical ? "Yes" : "No") +
                ", Agency - " + agencyName;
    }


    @javafx.fxml.FXML
    public void nextOnButton(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("SecurityInvestigation.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }
}