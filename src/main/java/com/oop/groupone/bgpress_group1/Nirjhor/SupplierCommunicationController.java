package your.package;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SupplierCommunicationController {

    @FXML private TextField txtRecipientName;
    @FXML private TextArea txtMessageContent;
    @FXML private CheckBox chkMessageSent;
    @FXML private Label lblStatus;

    @FXML
    private void composeMessage() {
        txtMessageContent.setText("Dear " + txtRecipientName.getText() + ",\n\n");
    }

    @FXML
    private boolean send() {
        if (txtRecipientName.getText().isEmpty() || txtMessageContent.getText().isEmpty()) {
            lblStatus.setText("Recipient or message cannot be empty!");
            lblStatus.setStyle("-fx-text-fill:red; -fx-font-weight:bold;");
            return false;
        }
        chkMessageSent.setSelected(true);
        lblStatus.setText("Message sent successfully!");
        lblStatus.setStyle("-fx-text-fill:green; -fx-font-weight:bold;");
        return true;
    }
}
