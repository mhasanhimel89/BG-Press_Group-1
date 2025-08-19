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

public class SecurityProtocols
{
    @javafx.fxml.FXML
    private CheckBox hasAlertYesCB;
    @javafx.fxml.FXML
    private CheckBox hasAlertNoCB;
    @javafx.fxml.FXML
    private TextField enforcementTeamField;
    @javafx.fxml.FXML
    private TextField startDateField;
    @javafx.fxml.FXML
    private TextField protocolTitleField;
    @javafx.fxml.FXML
    private Label resultLabel;

    private String protocolTitle;
    private String startDate;
    private String enforcementTeam;
    private boolean hasAlertMechanism;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void reviewMitigationStrategyOnButton(ActionEvent actionEvent) {
        String summary = reviewMitigationStrategy();
        resultLabel.setText(summary);
    }

    private String reviewMitigationStrategy() {
        return "Review strategy for: " + protocolTitle +
                "\nStartDate: " + startDate +
                "\nTeam: " + enforcementTeam +
                "\nHas Alert: " + (hasAlertMechanism ? "Yes" : "No");
    }

    public boolean createProtocol() {
        return true;
    }

    @javafx.fxml.FXML
    public void createProtocolOnButton(ActionEvent actionEvent) {
        protocolTitle = protocolTitleField.getText();
        startDate = startDateField.getText();
        enforcementTeam = enforcementTeamField.getText();
        hasAlertMechanism = hasAlertYesCB.isSelected();

        if (protocolTitle.isEmpty() || startDate.isEmpty() || enforcementTeam.isEmpty()) {
            resultLabel.setText("Please fill in all fields");
        } else {
            boolean created = createProtocol();
            resultLabel.setText(created ?  "Protocol created successfully " : "Failed to create protocol");

        }
    }

    @javafx.fxml.FXML
    public void nextOnButton(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("ProtectSensitiveDocuments.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }
}