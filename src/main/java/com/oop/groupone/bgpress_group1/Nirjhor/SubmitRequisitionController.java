package com.oop.groupone.bgpress_group1.Nirjhor;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SubmitRequisitionController {

    @FXML private TextField itemNameField;
    @FXML private TextField quantityField;
    @FXML private ChoiceBox<String> priorityChoiceBox;
    @FXML private TextField deliveryDateField;

    @FXML private Button enterButton;
    @FXML private Button submitButton;
    @FXML private Label statusLabel;


    @FXML
    private void handleEnterDetails() {
        boolean ok = enterDetails();
        if (ok) {
            statusLabel.setText("Details entered successfully. You can submit now.");
            submitButton.setDisable(false);
        } else {
            statusLabel.setText("Invalid input. Please check fields.");
            submitButton.setDisable(true);
        }
    }


    public boolean enterDetails() {
        try {
            String itemName = itemNameField.getText();
            float quantity = Float.parseFloat(quantityField.getText());
            String priority = priorityChoiceBox.getValue();
            String deliveryDate = deliveryDateField.getText();

            if (itemName.isEmpty() || priority == null || deliveryDate.isEmpty() || quantity <= 0) {
                return false;
            }

            System.out.println("Entered Requisition: " + itemName + ", qty=" + quantity + ", priority=" + priority + ", delivery=" + deliveryDate);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @FXML
    private void handleSubmit() {
        boolean ok = submit();
        if (ok) {
            statusLabel.setText("Requisition submitted successfully!");
            clearFields();
            submitButton.setDisable(true);
        } else {
            statusLabel.setText("Submission failed.");
        }
    }


    public boolean submit() {
        // TODO: Save to database or send to backend
        System.out.println("Submitting requisition...");
        return true;
    }

    private void clearFields() {
        itemNameField.clear();
        quantityField.clear();
        priorityChoiceBox.getSelectionModel().clearSelection();
        deliveryDateField.clear();
    }
}
