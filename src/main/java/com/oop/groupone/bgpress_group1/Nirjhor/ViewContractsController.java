package your.package;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ViewContractsController {

    @FXML private TextField txtContractId;
    @FXML private TextField txtContractName;
    @FXML private TextField txtDocumentType;
    @FXML private CheckBox chkIsViewed;
    @FXML private TextArea txtContractDetails;

    @FXML
    private String viewContractList() {
        String contracts = "Contract 1: NDA.pdf\nContract 2: Agreement.docx\nContract 3: Lease.txt";
        txtContractDetails.setText(contracts);
        return contracts;
    }

    @FXML
    private void openContract() {
        String idText = txtContractId.getText().trim();
        if (idText.isEmpty()) {
            txtContractDetails.setText("Please enter a Contract ID to open.");
            return;
        }
        txtContractDetails.setText("Opening contract ID: " + idText + "\nContract Name: " + txtContractName.getText() +
                "\nDocument Type: " + txtDocumentType.getText());
        chkIsViewed.setSelected(true);
    }
}
