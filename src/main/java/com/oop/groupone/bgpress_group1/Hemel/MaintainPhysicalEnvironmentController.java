package com.oop.groupone.bgpress_group1.Hemel;


import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.format.DateTimeFormatter;

public class MaintainPhysicalEnvironmentController
{
    @javafx.fxml.FXML
    private TextField issueSeverityField;
    @javafx.fxml.FXML
    private TextField areaAssignmentField;
    @javafx.fxml.FXML
    private DatePicker inspectionScheduleDP;
    @javafx.fxml.FXML
    private ComboBox<String> shiftCB;
    @javafx.fxml.FXML
    private TextField recommendedActionField;
    @javafx.fxml.FXML
    private Label resultLabel;

    @javafx.fxml.FXML
    public void initialize() {
        shiftCB.getItems().addAll("Morning", "Day", "Night");
    }

    @javafx.fxml.FXML
    public void inspectAreaOnButton(ActionEvent actionEvent) {
        boolean inspectionPassed = inspectArea();
        resultLabel.setText(inspectionPassed ? "Inspection Passed"  :  "Inspection Failed  ");
    }

    @javafx.fxml.FXML
    public void generateReportOnAction(ActionEvent actionEvent) {
        String report = generateIssueReport();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Inspection Report");
        alert.setHeaderText("Generated Report");
        alert.setContentText(report);
        alert.showAndWait();
    }

    public boolean inspectArea() {
        return issueSeverityField.getText() == null || issueSeverityField.getText().trim().isEmpty();
    }

    public String generateIssueReport() {
        String schedule = (inspectionScheduleDP.getValue() != null)
                ? inspectionScheduleDP.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                : "Not set";

        return String.format(
                "Area Assignment: %s%nShift: %s%nInspection Schedule: %s%nIssue Severity: %s%nRecommended Action: %s",
                areaAssignmentField.getText(),
                shiftCB.getValue(),
                schedule,
                issueSeverityField.getText(),
                recommendedActionField.getText()
        );
    }

}