package com.oop.groupone.bgpress_group1.Nirjhor;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class UpdateRequisitionController {

    @FXML private TextField requisitionIdField;
    @FXML private TextField updatedQuantityField;
    @FXML private TextField newDeliveryDateField;
    @FXML private CheckBox updateConfirmedCheckBox;

    @FXML private Button modifyButton;
    @FXML private Button confirmButton;
    @FXML private Label statusLabel;


    @FXML
    private void handleModifyRequisition() {
        boolean ok = modifyRequisition();
        if (ok) {
            statusLabel.setText("Requisition modified successfully. You can confirm now.");
            confirmButton.setDisable(false);
        } else {
            statusLabel.setText("Modification failed. Check input values.");
            confirmButton.setDisable(true);
        }
    }

    // Logic to modify requisition
    public boolean modifyRequisition() {
        try {
            int id = Integer.parseInt(requisitionIdField.getText());
            float qty = Float.parseFloat(updatedQuantityField.getText());
            String newDate = newDeliveryDateField.getText();

            // TODO: Validation & DB update logic
            System.out.println("Modify Requisition: id=" + id + ", qty=" + qty + ", date=" + newDate);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @FXML
    private void handleConfirmUpdate() {
        confirmUpdate();
    }


    public void confirmUpdate() {
        updateConfirmedCheckBox.setSelected(true);
        statusLabel.setText("Update confirmed.");
        System.out.println("Requisition update confirmed.");
    }
}
