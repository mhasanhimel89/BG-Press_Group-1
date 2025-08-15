package your.package;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ApproveLegalDocumentController {

    @FXML private TextField txtDocumentId;
    @FXML private CheckBox chkIsApproved;
    @FXML private Label lblStatus;

    @FXML
    private void openDocument() {
        if (txtDocumentId.getText().isEmpty()) {
            lblStatus.setText("Enter Document ID to open.");
            lblStatus.setStyle("-fx-text-fill:red;");
            return;
        }
        lblStatus.setText("Document " + txtDocumentId.getText() + " opened.");
        lblStatus.setStyle("-fx-text-fill:green;");
    }

    @FXML
    private boolean approve() {
        if (txtDocumentId.getText().isEmpty()) {
            lblStatus.setText("Enter Document ID before approving.");
            lblStatus.setStyle("-fx-text-fill:red;");
            return false;
        }
        chkIsApproved.setSelected(true);
        lblStatus.setText("Document " + txtDocumentId.getText() + " approved successfully.");
        lblStatus.setStyle("-fx-text-fill:green;");
        return true;
    }
}
