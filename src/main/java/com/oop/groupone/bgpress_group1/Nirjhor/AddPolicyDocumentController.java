package your.package;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AddPolicyDocumentController {

    @FXML private TextField txtPolicyId;
    @FXML private TextField txtDocumentTitle;
    @FXML private CheckBox chkIsUploaded;
    @FXML private Label lblStatus;

    @FXML
    private boolean uploadPolicy() {
        if (txtPolicyId.getText().isEmpty() || txtDocumentTitle.getText().isEmpty()) {
            lblStatus.setText("Policy ID and title must be filled.");
            lblStatus.setStyle("-fx-text-fill:red;");
            return false;
        }
        chkIsUploaded.setSelected(true);
        lblStatus.setText("Policy uploaded successfully.");
        lblStatus.setStyle("-fx-text-fill:green;");
        return true;
    }

    @FXML
    private String confirmUpload() {
        if (chkIsUploaded.isSelected()) {
            lblStatus.setText("Upload confirmed for policy: " + txtDocumentTitle.getText());
            lblStatus.setStyle("-fx-text-fill:green;");
            return "Upload confirmed";
        } else {
            lblStatus.setText("No upload to confirm.");
            lblStatus.setStyle("-fx-text-fill:red;");
            return "No upload";
        }
    }
}
