package com.oop.groupone.bgpress_group1.Hemel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReviewAuditReportsController
{
    @javafx.fxml.FXML
    private TableColumn<AuditReport, String> detailsColumn;
    @javafx.fxml.FXML
    private TableView<AuditReport> auditTableView;
    @javafx.fxml.FXML
    private TextField sessionIdField;
    @javafx.fxml.FXML
    private TableColumn<AuditReport, String> dateColumn;
    @javafx.fxml.FXML
    private DatePicker sessionDatePicker;
    @javafx.fxml.FXML
    private TableColumn<AuditReport, String> idColumn;

    private ObservableList<AuditReport> auditReports = FXCollections.observableArrayList();
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @javafx.fxml.FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        detailsColumn.setCellValueFactory(new PropertyValueFactory<>("details"));

        auditTableView.setItems(auditReports);

        auditReports.add(new AuditReport("AUD-001", "2023-05-10", "System login audit"));
        auditReports.add(new AuditReport("AUD-002", "2023-05-11", "User permission changes"));
        auditReports.add(new AuditReport("AUD-003", "2023-05-12", "Database backup verification"));

        sessionDatePicker.setValue(LocalDate.now());
    }

    @javafx.fxml.FXML
    public void displayAuditContentOnButton(ActionEvent actionEvent) {
        AuditReport selectedReport = auditTableView.getSelectionModel().getSelectedItem();

        if (selectedReport == null) {
            showAlert("Selection Error", "Please select an audit report from the table");
            return;
        }

        showAlert("Audit Content",
                "ID: " + selectedReport.getId() + "\n" +
                        "Date: " + selectedReport.getDate() + "\n" +
                        "Details: " + selectedReport.getDetails());

    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void fetchAuditReportOnButton(ActionEvent actionEvent) {
        String sessionId = sessionIdField.getText().trim();
        LocalDate selectedDate = sessionDatePicker.getValue();

        if (sessionId.isEmpty() && selectedDate == null) {
            showAlert("Input Error", "Please enter a Session ID or select a date");
            return;
        }

        auditTableView.getSelectionModel().clearSelection();

        ObservableList<AuditReport> filteredReports = FXCollections.observableArrayList();

        for (AuditReport report : auditReports) {
            boolean matchesId = sessionId.isEmpty() ||
                    report.getId().toLowerCase().contains(sessionId.toLowerCase());
            boolean matchesDate = selectedDate == null ||
                    report.getDate().equals(selectedDate.format(dateFormatter));

            if (matchesId && matchesDate) {
                filteredReports.add(report);
            }
        }
        if(selectedDate.getMonthValue()==0){
            showAlert("error","please select a date");
            return;
        }

        if (filteredReports.isEmpty()) {
            showAlert("No Results", "No audit reports found matching the criteria");
        } else {
            auditTableView.setItems(filteredReports);
        }
    }

    public ObservableList<AuditReport> getAuditReports() {
        return auditReports;
    }

    public void setAuditReports(ObservableList<AuditReport> auditReports) {
        this.auditReports = auditReports;
    }

    @FXML
    public void nextOnButton(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("ExportReports.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }

    public static class AuditReport {
        private final String id;
        private final String date;
        private final String details;

        public AuditReport(String id, String date, String details) {
            this.id = id;
            this.date = date;
            this.details = details;
        }

        public String getId() {
            return id;
        }

        public String getDate() {
            return date;
        }

        public String getDetails() {
            return details;
        }
    }

}