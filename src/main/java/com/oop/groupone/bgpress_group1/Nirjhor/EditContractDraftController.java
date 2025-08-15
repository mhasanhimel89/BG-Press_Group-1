package your.package;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EditContractDraftController {

    @FXML private TextField txtDraftId;
    @FXML private TextArea txtChangedSections;
    @FXML private CheckBox chkHasHighlightedChanges;
    @FXML private Label lblStatus;

    @FXML
    private boolean editDraft() {
        if (txtDraftId.getText().isEmpty() || txtChangedSections.getText().isEmpty()) {
            lblStatus.setText("Draft ID and changed sections must be filled.");
            lblStatus.setStyle("-fx-text-fill:red;");
            return false;
        }
        chkHasHighlightedChanges.setSelected(true);
        lblStatus.setText("Draft edited successfully.");
        lblStatus.setStyle("-fx-text-fill:green;");
        return true;
    }

    @FXML
    private void saveDraft() {
        if (chkHasHighlightedChanges.isSelected()) {
            lblStatus.setText("Draft saved successfully with highlighted changes.");
            lblStatus.setStyle("-fx-text-fill:green;");
        } else {
            lblStatus.setText("Draft saved without highlighted changes.");
            lblStatus.setStyle("-fx-text-fill:orange;");
        }
    }
}
