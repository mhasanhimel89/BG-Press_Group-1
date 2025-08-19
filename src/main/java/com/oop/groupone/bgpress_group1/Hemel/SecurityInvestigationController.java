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

public class SecurityInvestigationController
{
    @javafx.fxml.FXML
    private TextField caseIDField;
    @javafx.fxml.FXML
    private TextField evidenceTypeField;
    @javafx.fxml.FXML
    private TextField investigatorField;
    @javafx.fxml.FXML
    private Label resultLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void collectEvidenceOnButton(ActionEvent actionEvent) {
        String evidenceType = evidenceTypeField.getText();

        if (evidenceType.isEmpty()) {
            resultLabel.setText("Result: Evidence type is required.");
            return;
        }

        String evidenceResult = collectEvidence(evidenceType);
        resultLabel.setText("Result: " + evidenceResult);
    }

    private String collectEvidence(String evidenceType) {
        return "Collected evidence of type: " + evidenceType;
    }

    @javafx.fxml.FXML
    public void startInvestigationOnButton(ActionEvent actionEvent) {
        try {
            int caseId = Integer.parseInt(caseIDField.getText());
            String investigator = investigatorField.getText();

            if (investigator.isEmpty()) {
                resultLabel.setText("Result: Investigator name is required");
                return;
            }

            boolean success = startInvestigation(caseId, investigator);
            if (success) {
                resultLabel.setText("Result: Investigation started for Case ID " + caseId + " by " + investigator + ".");
            } else {
                resultLabel.setText("Result: Failed to start investigation");
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid Case ID.");
        }
    }

    private boolean startInvestigation(int caseId, String investigator) {
        return true;
    }

    @javafx.fxml.FXML
    public void nextOnButton(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("EnsureStaffSafety.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }
}