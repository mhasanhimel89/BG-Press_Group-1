package com.oop.groupone.bgpress_group1.Nirjhor;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CancelRequisitionController {

    @FXML private TextField requisitionIdField;
    @FXML private TextField cancellationReasonField;
    @FXML private CheckBox isCancelledCheckBox;

    @FXML private Button cancelButton;
    @FXML private Button showConfirmationButton;
    @FXML private Label statusLabel;


    @FXML
    private void handleCancel() {
        boolean ok = cancel();
        if (ok) {
            statusLabel.setText("Requisition cancelled successfully.");
            isCancelledCheckBox.setSelected(true);
            showConfirmationButton.setDisable(false);
        } else {
            statusLabel.setText("Cancellation failed. Check inputs.");
            isCancelledCheckBox.setSelected(false);
            showConfirmationButton.setDisable(true);
        }
    }


    public boolean cancel() {
        try {
            int id = Integer.parseInt(requisitionIdField.getText());
            String reason = cancellationReasonField.getText();

            if (reason.isEmpty() || id <= 0) {
                return false;
            }

            // TODO: Actual cancellation logic (DB/API)
            System.out.println("Cancelling requisition ID=" + id + " for reason: " + reason);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @FXML
    private void handleShowConfirmation() {
        String message = showConfirmation();
        statusLabel.setText(message);
    }


    public String showConfirmation() {
        int id;
        try {
            id = Integer.parseInt(requisitionIdField.getText());
        } catch (Exception e) {
            return "Invalid Requisition ID.";
        }
        return "Requisition ID " + id + " has been cancelled successfully.";
    }
}
