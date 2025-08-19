package com.oop.groupone.bgpress_group1.Hemel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class MonitorAccessLogsController
{
    @javafx.fxml.FXML
    private TextField startTimeField;
    @javafx.fxml.FXML
    private TableColumn<AccessLog, String> timeColumn;
    @javafx.fxml.FXML
    private TableColumn<AccessLog, String> actionColumn;
    @javafx.fxml.FXML
    private TextField endTimeField;
    @javafx.fxml.FXML
    private CheckBox isValidRangeCB;
    @javafx.fxml.FXML
    private TableColumn<AccessLog, String> userColumn;
    @javafx.fxml.FXML
    private TableView<AccessLog> logsTableView;

    private ObservableList<AccessLog> accessLogs = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        userColumn.setCellValueFactory(new PropertyValueFactory<>("user"));
        actionColumn.setCellValueFactory(new PropertyValueFactory<>("action"));

        logsTableView.setItems(accessLogs);

        accessLogs.add(new AccessLog("10:30:45", "user1", "Login"));
        accessLogs.add(new AccessLog("11:15:22", "admin", "System update"));
        accessLogs.add(new AccessLog("12:45:10", "user2", "File access"));
    }

    @javafx.fxml.FXML
    public void fetchLogsOnButton(ActionEvent actionEvent) {
        String startTime = startTimeField.getText();
        String endTime = endTimeField.getText();
        boolean isValidRange = isValidRangeCB.isSelected();

        if (isValidRange) {
            System.out.println("Fetching logs from " + startTime + " to " + endTime);
        } else {
            System.out.println("Invalid time range.");
        }
    }

    @javafx.fxml.FXML
    public void displayAccessLogsOnButton(ActionEvent actionEvent) {
        System.out.println("Displaying access logs...");
    }

    @javafx.fxml.FXML
    public void nextOnButton(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("FilterReports.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }

    public static class AccessLog {
        private final String time;
        private final String user;
        private final String action;

        public AccessLog(String time, String user, String action) {
            this.time = time;
            this.user = user;
            this.action = action;
        }

        public String getTime() {
            return time;
        }

        public String getUser() {
            return user;
        }

        public String getAction() {
            return action;
        }
    }

}