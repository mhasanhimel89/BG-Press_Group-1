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

public class ProtectSensitiveDocumentsController {
    @javafx.fxml.FXML
    private TextField accessedByField;
    @javafx.fxml.FXML
    private CheckBox hasAnomaliesNoCB;
    @javafx.fxml.FXML
    private TextField viewsCountField;
    @javafx.fxml.FXML
    private CheckBox hasAnomaliesYesCB;
    @javafx.fxml.FXML
    private TextField documentCategoryField;
    @javafx.fxml.FXML
    private Label resultLabel;

    private String documentCategory;
    private int viewsCount;
    private String accessedBy;
    private boolean hasAnomalies;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void generateAccessSummaryOnButton(ActionEvent actionEvent) {
        documentCategory = documentCategoryField.getText();
        try {
            viewsCount = Integer.parseInt(viewsCountField.getText());
        } catch (NumberFormatException e) {
            resultLabel.setText("Error: Views Count must be a number!");
            return;
        }

        accessedBy = accessedByField.getText();
        hasAnomalies = hasAnomaliesYesCB.isSelected();

        String summary = generateAccessSummary();
        resultLabel.setText(summary);
    }

    private boolean loadDocumentDashboard() {
        return !documentCategory.isEmpty() && !accessedBy.isEmpty();
    }

    private String generateAccessSummary() {
        return String.format(
                "Document: %s\nViews: %d\nAccessed By: %s\nHas Anomalies: %s",
                documentCategory,
                viewsCount,
                accessedBy,
                hasAnomalies ? "Yes" : "No"

        );
    }

    @javafx.fxml.FXML
    public void loadDocumentDashboardOnButton(ActionEvent actionEvent) {
        documentCategory = documentCategoryField.getText();
        try {
            viewsCount = Integer.parseInt(viewsCountField.getText());
        } catch (NumberFormatException e) {
            resultLabel.setText("Error: Views Count must be a number!");
            return;
        }

        accessedBy = accessedByField.getText();
        hasAnomalies = hasAnomaliesYesCB.isSelected();

        boolean loaded = loadDocumentDashboard();
        resultLabel.setText(loaded ? "Document Dashboard Loaded Successfully!" : "Failed to Load Dashboard.");

    }

    @javafx.fxml.FXML
    public void nextOnButton(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("LawEnforcementCoordination.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }
}