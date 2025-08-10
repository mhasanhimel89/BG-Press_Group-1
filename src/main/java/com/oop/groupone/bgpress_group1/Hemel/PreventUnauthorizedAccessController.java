package com.oop.groupone.bgpress_group1.Hemel;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.format.DateTimeFormatter;

public class PreventUnauthorizedAccessController
{
    @javafx.fxml.FXML
    private DatePicker timestampDP;
    @javafx.fxml.FXML
    private TextField clearanceLevelField;
    @javafx.fxml.FXML
    private CheckBox isUnauthorizedCB;
    @javafx.fxml.FXML
    private TextField monitoringZoneField;
    @javafx.fxml.FXML
    private Label resultLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void monitorAccessOnButton(ActionEvent actionEvent) {
        boolean unauthorizedDetected = monitorAccess();
        resultLabel.setText(unauthorizedDetected ? "Unauthorized Access Detected  " : "Access Authorized  ");
    }

    private boolean monitorAccess() {
        return isUnauthorizedCB.isSelected();
    }

    @javafx.fxml.FXML
    public void generateIncidentReportOnButton(ActionEvent actionEvent) {
        String report = generateIncidentReport();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Incident Report");
        alert.setHeaderText("Generate Incident Report");
        alert.setContentText(report);
        alert.showAndWait();
    }

    private String generateIncidentReport() {
        String timestamp = timestampDP.getValue() != null
                ? timestampDP.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                : "Not set";

        return String.format(
                "Clearance Level: %s%nMonitoring Zone: %s%nTimestamp: %s%nIs Unauthorized: %s",
                clearanceLevelField.getText(),
                monitoringZoneField.getText(),
                timestamp,
                isUnauthorizedCB.isSelected() ? "Yes" : "No"


        );

    }
}


