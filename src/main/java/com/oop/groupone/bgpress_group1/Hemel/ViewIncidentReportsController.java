package com.oop.groupone.bgpress_group1.Hemel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class ViewIncidentReportsController
{
    @javafx.fxml.FXML
    private TableView<IncidentReport> reportsTableView;
    @javafx.fxml.FXML
    private TableColumn<IncidentReport, String> locationCol;
    @javafx.fxml.FXML
    private TableColumn<IncidentReport, String> typeCol;
    @javafx.fxml.FXML
    private TableColumn<IncidentReport, String> dateCol;
    @javafx.fxml.FXML
    private ComboBox<String> filterTypeComboBox;
    @javafx.fxml.FXML
    private TableColumn<IncidentReport, String> detailsCol;
    @javafx.fxml.FXML
    private DatePicker filterDatePicker;
    @javafx.fxml.FXML
    private TextField filterLocationField;

    private ObservableList<IncidentReport> incidentReports = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        detailsCol.setCellValueFactory(new PropertyValueFactory<>("details"));

        reportsTableView.setItems(incidentReports);

        filterTypeComboBox.getItems().addAll(
                "All Types",
                "Security",
                "Medical",
                "Fire",
                "Equipment Failure",
                "Other"
        );

        filterTypeComboBox.getSelectionModel().selectFirst();

        incidentReports.add(new IncidentReport("2023-05-15", "Building A", "Security", "Unauthorized access detected"));
        incidentReports.add(new IncidentReport("2023-05-16", "Building B", "Medical", "Employee fainted in hallway"));
        incidentReports.add(new IncidentReport("2023-05-17", "Parking Lot", "Security", "Vehicle break-in reported"));
    }

    @javafx.fxml.FXML
    public void filterReportsOnButton(ActionEvent actionEvent) {
        LocalDate selectedDate = filterDatePicker.getValue();
        String locationFilter = filterLocationField.getText().toLowerCase();
        String typeFilter = filterTypeComboBox.getValue();

        ObservableList<IncidentReport> filteredReports = FXCollections.observableArrayList();

        for (IncidentReport report : incidentReports) {
            boolean matchesDate = selectedDate == null ||
                    report.getDate().equals(selectedDate.toString());
            boolean matchesLocation = locationFilter.isEmpty() ||
                    report.getLocation().toLowerCase().contains(locationFilter);

            boolean matchesType = typeFilter.equals("All Types") ||
                    report.getType().equals(typeFilter);

            if (matchesDate && matchesLocation && matchesType) {
                filteredReports.add(report);
            }
        }

        reportsTableView.setItems(filteredReports);
    }

    @javafx.fxml.FXML
    public void displayReportsOnButton(ActionEvent actionEvent) {
        reportsTableView.setItems(incidentReports);

        filterDatePicker.setValue(null);
        filterLocationField.clear();
        filterTypeComboBox.getSelectionModel().selectFirst();
    }

    @javafx.fxml.FXML
    public void nextOnButton(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("ReviewAuditReports.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }

    public static class IncidentReport {
        private final String date;
        private final String location;
        private final String type;
        private final String details;

        public IncidentReport(String date, String location, String type, String details) {
            this.date = date;
            this.location = location;
            this.type = type;
            this.details = details;
        }

        public String getDate() {
            return date;
        }

        public String getLocation() {
            return location;
        }

        public String getType() {
            return type;
        }

        public String getDetails() {
            return details;
        }
    }
}