package com.oop.groupone.bgpress_group1.Hemel;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SecureWorkingEnvironmentController
{
    @javafx.fxml.FXML
    private CheckBox emergencySystemReadyYesCB;
    @javafx.fxml.FXML
    private CheckBox emergencySystemReadyNoCB;
    @javafx.fxml.FXML
    private TextField securedZoneField;
    @javafx.fxml.FXML
    private TextArea incidentLogsArea;

    private String securedZone;
    private boolean emergencySystemReady;
    private String incidentLogs;

    @javafx.fxml.FXML
    public void initialize() {
        setupExclusiveCheckBox(emergencySystemReadyYesCB, emergencySystemReadyNoCB);
    }

    private void setupExclusiveCheckBox(CheckBox yes, CheckBox no) {
        yes.setOnAction(e -> {
            if (yes.isSelected()) no.setSelected(false);
        });
        no.setOnAction(e -> {
            if (no.isSelected()) yes.setSelected(false);
        });

    }


    @javafx.fxml.FXML
    public boolean loadWorkplaceSecurityOnButton(ActionEvent actionEvent) {
        securedZone = securedZoneField.getText().trim();
        emergencySystemReady = emergencySystemReadyYesCB.isSelected();
        incidentLogs = incidentLogsArea.getText().trim();

        if (!securedZone.isEmpty()) {
            incidentLogsArea.appendText("\\n[INFO] Workplace security data loaded for zone: \" + securedZone");
            return true;
        } else {
            incidentLogsArea.appendText("\\n[ERROR] Please enter a secured zone.");
            return false;
        }
    }

    @javafx.fxml.FXML
    public boolean validateEmergencySystemsOnButton(ActionEvent actionEvent) {
        emergencySystemReady = emergencySystemReadyYesCB.isSelected();

        if (emergencySystemReady) {
            incidentLogsArea.appendText("\n Emergency systems are ready and operational.");
            return true;
        } else {
            incidentLogsArea.appendText("\n Emergency systems are NOT ready. Please take immediate action!");
            return false;
        }
    }


    @javafx.fxml.FXML
    public void backOnButton(Event event) {
    }

    @javafx.fxml.FXML
    public void nextOnButton(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("SODashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }
}