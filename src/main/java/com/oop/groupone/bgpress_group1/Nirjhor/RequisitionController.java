package your.package;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RequisitionController {

    @FXML private TextField txtRequisitionId;
    @FXML private TextArea txtRequisitionList;
    @FXML private CheckBox chkIsPending;

    @FXML
    private void fetchRequisitions() {

        txtRequisitionList.setText("Fetched requisitions...");
    }

    @FXML
    private void displayDetails() {
        int id = Integer.parseInt(txtRequisitionId.getText());

        txtRequisitionList.setText("Details of Requisition ID: " + id);
        chkIsPending.setSelected(true);
    }
}
