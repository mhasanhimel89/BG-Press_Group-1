package com.oop.groupone.bgpress_group1.Hemel;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;


public class FilterReportsController
{
    @javafx.fxml.FXML
    private TableView<Report> reportsTableView;
    @javafx.fxml.FXML
    private ComboBox<String> filterFieldComboBox;
    @javafx.fxml.FXML
    private TextField filterValueField;
    @javafx.fxml.FXML
    private TableColumn<Report, String> reportIdColumn;
    @javafx.fxml.FXML
    private TableColumn<Report, String> reportDateColumn;
    @javafx.fxml.FXML
    private TableColumn<Report, String> reportDetailsColumn;

    private ObservableList<Report> allReports = FXCollections.observableArrayList();
    private ObservableList<Report> filteredReports = FXCollections.observableArrayList();
    private String currentFilterField;
    private String currentFilterValue;

    @javafx.fxml.FXML
    public void initialize() {
        filterFieldComboBox.getItems().addAll("ID", "Date", "Details");
        filterFieldComboBox.getSelectionModel().selectFirst();

        reportIdColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        reportDateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        reportDetailsColumn.setCellValueFactory(cellData -> cellData.getValue().detailsProperty());

        loadSampleData();
    }

    @javafx.fxml.FXML
    public void showFilteredReportsOnButton(ActionEvent actionEvent) {
        if (currentFilterField == null || currentFilterValue == null) {
            showAlert("No Filter", "Please apply a filter first");
            return;
        }

        filteredReports.clear();

        for (Report report : allReports) {
            if (matchesFilter(report)) {
                filteredReports.add(report);
            }
        }

        reportsTableView.setItems(filteredReports);
    }

    private boolean matchesFilter(Report report) {
        switch(currentFilterField) {
            case "ID":
                return report.getId().contains(currentFilterValue);
            case "Date":
                return report.getDate().contains(currentFilterValue);
            case "Details":
                return report.getDetails().toLowerCase().contains(currentFilterValue.toLowerCase());

            default:
                return false;
        }
    }

    private void loadSampleData() {
        allReports.add(new Report("R001", "2023-05-10", "System maintenance report"));
        allReports.add(new Report("R002", "2023-05-11", "Security audit findings"));
        allReports.add(new Report("R003", "2023-05-12", "User activity log analysis"));
        allReports.add(new Report("R004", "2023-05-13", "Database performance report"));

        reportsTableView.setItems(allReports);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void applyFilterOnButton(ActionEvent actionEvent) {
        currentFilterField = filterFieldComboBox.getValue();
        currentFilterValue = filterValueField.getText();

        System.out.println("Filter applied - Field: " + currentFilterField + ", Value: " + currentFilterValue);

    }

    @javafx.fxml.FXML
    public void nextOnButton(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("GenerateSummaryReports.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }

    public static class Report {
        private final SimpleStringProperty id;
        private final SimpleStringProperty date;
        private final SimpleStringProperty details;

        public Report(String id, String date, String details) {
            this.id = new SimpleStringProperty(id);
            this.date = new SimpleStringProperty(date);
            this.details = new SimpleStringProperty(details);

        }

        public String getId() {
            return id.get();
        }

        public String getDate() {
            return date.get();
        }

        public String getDetails() {
            return details.get();
        }

        public SimpleStringProperty idProperty() {
            return id;
        }

        public SimpleStringProperty dateProperty() {
            return date;
        }

        public SimpleStringProperty detailsProperty() {
            return details;
        }
    }
}