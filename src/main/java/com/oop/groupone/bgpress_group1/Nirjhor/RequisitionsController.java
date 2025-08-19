package com.example.requisitions;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class RequisitionsController {

    @FXML
    private ListView<String> requisitionListView;

    @FXML
    private Label requisitionDetailsLabel;

    @FXML
    public void initialize() {

        requisitionListView.getItems().addAll(
                "Requisition #1001 - Cement",
                "Requisition #1002 - Steel",
                "Requisition #1003 - Sand"
        );


        requisitionListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                requisitionDetailsLabel.setText("Details for " + newVal);
            }
        });
    }
}
