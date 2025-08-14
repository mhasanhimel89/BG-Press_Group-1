package your.package;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LegalObjectionController {

    @FXML private TextField txtObjectionId;
    @FXML private TextArea txtIssueDetails;
    @FXML private CheckBox chkIsSubmitted;
    @FXML private Label lblStatus;

    @FXML
    private void createObjection() {
        txtIssueDetails.setText("Describe your legal objection here...");
        chkIsSubmitted.setSelected(false);
        lblStatus.setText("Objection created.");
        lblStatus.setStyle("-fx-text-fill:blue;");
    }

    @FXML
    private boolean submitObjection() {
        if (txtObjectionId.getText().isEmpty() || txtIssueDetails.getText().isEmpty()) {
            lblStatus.setText("Objection ID and details must be filled.");
            lblStatus.setStyle("-fx-text-fill:red;");
            return false;
        }
        chkIsSubmitted.setSelected(true);
        lblStatus.setText("Objection submitted successfully.");
        lblStatus.setStyle("-fx-text-fill:green;");
        return true;
    }
}
