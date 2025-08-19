package com.oop.groupone.bgpress_group1.Hemel;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
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

    @javafx.fxml.FXML
    public void nextOnButton(ActionEvent actionEvent) throws IOException  {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("SecurityProtocols.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }

}


