package com.oop.groupone.bgpress_group1.Hemel;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class EnsureStaffSafetyController
{
    @javafx.fxml.FXML
    private Button monitorStaffSafetyOnButton;
    @javafx.fxml.FXML
    private CheckBox emergencySuppliesAvailableYesCB;
    @javafx.fxml.FXML
    private CheckBox highRishZoneAccessedYesCB;
    @javafx.fxml.FXML
    private CheckBox emergencySuppliesAvailableNoCB;
    @javafx.fxml.FXML
    private TextArea safetyAlertArea;
    @javafx.fxml.FXML
    private TextField safetyZoneField;
    @javafx.fxml.FXML
    private CheckBox fireExtinguisherValidYesCB;
    @javafx.fxml.FXML
    private CheckBox highRiskZoneAccessedNoCB;
    @javafx.fxml.FXML
    private Button GenerateSafetyAlertOnButton;
    @javafx.fxml.FXML
    private CheckBox fireExtinguisherValidNoCB;


    private TextArea getSafetyAlertArea;

    private String safetyZone;
    private boolean emergencySuppliesAvailable;
    private boolean fireExtinguisherValid;
    private boolean highRiskZoneAccessed;

    @javafx.fxml.FXML
    public void initialize() {
        setupExclusiveCheckbox(emergencySuppliesAvailableYesCB, emergencySuppliesAvailableNoCB);
        setupExclusiveCheckbox(fireExtinguisherValidYesCB, fireExtinguisherValidNoCB);
        setupExclusiveCheckbox(highRishZoneAccessedYesCB, highRiskZoneAccessedNoCB);

        monitorStaffSafetyOnButton.setOnAction(e -> {
            boolean safe = monitorStaffSafety();
            safetyAlertArea.setText(safe ? "Staff safety is within acceptable parameters."
                                         : "Potential safety hazards detected! Please take action.");


                }

        );

        GenerateSafetyAlertOnButton.setOnAction(e -> {
            String alert = generateSafetyAlert();
            safetyAlertArea.setText(alert);
        });
    };

    private void setupExclusiveCheckbox(CheckBox yes, CheckBox no) {
        yes.setOnAction(e -> {
            if (yes.isSelected()) no.setSelected(false);
        });
        no.setOnAction(e -> {
            if (no.isSelected()) yes.setSelected(false);;
        });
    }

    public boolean monitorStaffSafety() {
        safetyZone = safetyZoneField.getText();
        emergencySuppliesAvailable = emergencySuppliesAvailableYesCB.isSelected();
        fireExtinguisherValid = fireExtinguisherValidYesCB.isSelected();
        highRiskZoneAccessed = highRishZoneAccessedYesCB.isSelected();

        return emergencySuppliesAvailable && fireExtinguisherValid && !highRiskZoneAccessed;
    }

    public String generateSafetyAlert() {
        monitorStaffSafety();

        StringBuilder alert = new StringBuilder("Safety Status for zone: " + safetyZone + "\n");

        if (!emergencySuppliesAvailable) {
            alert.append("- Emergency supplies NOT available.\n");
        }
        if (!fireExtinguisherValid) {
            alert.append("- Fire extinguisher is NOT valid.\n");
        }
        if (highRiskZoneAccessed) {
            alert.append("- High risk zone has been accessed.\n");
        }

        if (alert.toString().equals("Safety Status for zone: " + safetyZone + "\n")) {
            alert.append("All safety measures are met. Staff safety ensured.");
        } else {
            alert.append("Action required to ensure staff safety.");
        }

        return alert.toString();

    }


    @javafx.fxml.FXML
    public void nextOnButton(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("SecureWorkingEnvironment.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }
}