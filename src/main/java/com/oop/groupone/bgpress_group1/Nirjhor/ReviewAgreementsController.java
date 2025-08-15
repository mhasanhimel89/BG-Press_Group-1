package your.package;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ReviewAgreementsController {

    @FXML private TextField txtAgreementId;
    @FXML private TextField txtSupplierName;
    @FXML private TextArea txtReviewComment;
    @FXML private CheckBox chkHasReviewed;
    @FXML private Label lblStatus;

    @FXML
    private boolean openAgreement() {
        if (txtAgreementId.getText().isEmpty()) {
            lblStatus.setText("Enter Agreement ID first!");
            lblStatus.setStyle("-fx-text-fill:red;");
            return false;
        }
        lblStatus.setText("Agreement " + txtAgreementId.getText() + " opened for " + txtSupplierName.getText());
        lblStatus.setStyle("-fx-text-fill:green;");
        return true;
    }

    @FXML
    private boolean addReviewNotes() {
        if (txtReviewComment.getText().isEmpty()) {
            lblStatus.setText("Add review comment before saving!");
            lblStatus.setStyle("-fx-text-fill:red;");
            return false;
        }
        chkHasReviewed.setSelected(true);
        lblStatus.setText("Review notes added successfully!");
        lblStatus.setStyle("-fx-text-fill:green;");
        return true;
    }
}
