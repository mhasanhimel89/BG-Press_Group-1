package your.package;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TrackLegalCaseController {

    @FXML private TextField txtCaseId;
    @FXML private TextField txtLastHearingDate;
    @FXML private TextArea txtUpdateNote;
    @FXML private CheckBox chkHasNewUpdate;
    @FXML private TextArea txtCaseDetails;

    @FXML
    private String viewCaseTimeline() {
        String caseId = txtCaseId.getText().trim();
        String date = txtLastHearingDate.getText().trim();

        String timeline = "Case ID: " + caseId + "\nLast Hearing Date: " + date +
                "\nTimeline:\n- Case filed\n- Initial hearing\n- Next hearing scheduled on " + date;
        txtCaseDetails.setText(timeline);
        return timeline;
    }

    @FXML
    private void addInternalNote() {
        String note = txtUpdateNote.getText().trim();
        if (!note.isEmpty()) {
            chkHasNewUpdate.setSelected(true);
            txtCaseDetails.appendText("\nInternal Note Added: " + note);
        }
    }
}
