package com.oop.groupone.bgpress_group1.Hemel;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class GenerateSummaryReportsController
{
    @javafx.fxml.FXML
    private TextField TimeFrameField;
    @javafx.fxml.FXML
    private TextField reportParametersField;
    @javafx.fxml.FXML
    private TextArea summaryOutputArea;
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void validateParametersOnButton(ActionEvent actionEvent) {
        String timeFrame = TimeFrameField.getText();
        String reportParameters = reportParametersField.getText();

        if (timeFrame.isEmpty() || reportParameters.isEmpty()) {
            statusLabel.setText("Status: Please fill in all fields");
        } else {
            statusLabel.setText("Status: Parameters validated successfully");
        }
    }

    @javafx.fxml.FXML
    public void createSummaryOnButton(ActionEvent actionEvent) {
        if (statusLabel.getText().equals("Status: Parameters validated successfully")) {

            String timeFrame = TimeFrameField.getText();
            String reportParameters = reportParametersField.getText();

            String summary = "Summary Report for Time Frame: " + timeFrame + "\n" +
                             "Parameters: " + reportParameters + "\n" +
                             "Total Records Processed: 150\n" +
                             "Average Value: 42.7\n" +
                             "Highest Value: 98\n" +
                             "Lowest Value: 12";

            summaryOutputArea.setText(summary);
            statusLabel.setText("Status: Summary created successfully");
        } else {
            statusLabel.setText("Status: Please validate parameters first");
        }
    }

    @javafx.fxml.FXML
    public void nextOnButton(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("CommentOnReports.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }
}