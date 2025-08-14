package your.package;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TrackRequisitionStatusController {

    @FXML private TextField txtRequisitionId;
    @FXML private TextField txtCurrentStatus;
    @FXML private Spinner<Integer> spnExpectedDays;
    @FXML private TextField txtProgressPercent;
    @FXML private ProgressBar progressBar;
    @FXML private ListView<String> lstTimeline;
    @FXML private TextArea txtDetails;

    @FXML
    private void initialize() {

        SpinnerValueFactory.IntegerSpinnerValueFactory factory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 365, 0);
        spnExpectedDays.setValueFactory(factory);


        lstTimeline.getItems().addAll(
                "Created → Pending",
                "Approved by Manager",
                "Dispatched from Warehouse"
        );
    }

    @FXML
    private void getStatus() {
        String idText = txtRequisitionId.getText().trim();
        String status = txtCurrentStatus.getText().trim();
        int days = spnExpectedDays.getValue() == null ? 0 : spnExpectedDays.getValue();

        // Simple demo behavior
        if (status.isEmpty()) status = "Pending";

        txtDetails.setText(
                "Requisition ID: " + idText +
                        "\nCurrent Status: " + status +
                        "\nExpected Delivery (days): " + days
        );


        double p = switch (status.toLowerCase()) {
            case "pending" -> 0.1;
            case "approved" -> 0.3;
            case "in transit", "in-transit" -> 0.6;
            case "delivered" -> 1.0;
            default -> parseProgressOrDefault();
        };
        progressBar.setProgress(p);
        txtProgressPercent.setText(String.valueOf(Math.round(p * 100.0)));
    }

    @FXML
    private void displayTimeline() {
        String idText = txtRequisitionId.getText().trim();
        lstTimeline.getItems().setAll(
                "Requisition " + idText + " created",
                "Reviewed by Procurement",
                "Approved by Manager",
                "Assigned to Vendor",
                "In Transit",
                "Out for Delivery",
                "Delivered"
        );
        txtDetails.appendText("\n\nTimeline refreshed for ID: " + idText);
    }

    @FXML
    private void resetForm() {
        txtRequisitionId.clear();
        txtCurrentStatus.clear();
        spnExpectedDays.getValueFactory().setValue(0);
        txtProgressPercent.clear();
        progressBar.setProgress(0.0);
        lstTimeline.getItems().clear();
        txtDetails.clear();
    }


    private double parseProgressOrDefault() {
        try {
            double percent = Double.parseDouble(txtProgressPercent.getText().trim());
            // Convert 0..100 → 0..1
            double p = percent / 100.0;
            if (p < 0.0) p = 0.0;
            if (p > 1.0) p = 1.0;
            return p;
        } catch (Exception e) {
            return 0.0;
        }
    }
}
