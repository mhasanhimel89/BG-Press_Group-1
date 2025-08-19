package com.oop.groupone.bgpress_group1.Hemel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class ExportReportsController
{
    @javafx.fxml.FXML
    private TextArea statusTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> formatComboBox;
    @javafx.fxml.FXML
    private Button downloadButton;


    private boolean exportStatus = false;

    @javafx.fxml.FXML
    public void initialize() {
        ObservableList<String> formats = FXCollections.observableArrayList(
                "PDF", "CSV", "Excel", "HTML"
        );
        formatComboBox.setItems(formats);
        formatComboBox.getSelectionModel().selectFirst();
    }

    @javafx.fxml.FXML
    public void downloadExportOnButton(ActionEvent actionEvent) {
        if (exportStatus) {
            downloadExport();
            statusTextArea.appendText("Download initiated successfully!");
            downloadButton.setDisable(true);
        } else {
            statusTextArea.appendText("\nCannot download - export not completed successfully!");
        }
    }

    @javafx.fxml.FXML
    public void exportToFormatOnButton(ActionEvent actionEvent) {
        String format = formatComboBox.getValue();
        exportStatus = exportToFormat(format);

        ;
        if (exportStatus) {
            statusTextArea.setText("Export to " + format + " completed successfully!\n");
            downloadButton.setDisable(false);
        } else {
            statusTextArea.setText("Export to " + format + " failed!\n");
            downloadButton.setDisable(true);
        }
    }

    private boolean exportToFormat(String format) {
        return true; // Placeholder - replace with actual implementation
    }

    private void downloadExport() {

    }

    @javafx.fxml.FXML
    public void nextOnButton(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MonitorAccessLogs.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }
}