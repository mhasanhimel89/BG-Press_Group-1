package your.package;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LegalOfficerController {

    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblStatus;

    @FXML
    private boolean login() {
        String username = txtUsername.getText().trim();
        String password = txtPassword.getText().trim();

        if (username.equals("admin") && password.equals("admin123")) {
            lblStatus.setText("Login successful!");
            lblStatus.setStyle("-fx-text-fill:green; -fx-font-weight:bold;");
            return true;
        } else {
            lblStatus.setText("Invalid credentials!");
            lblStatus.setStyle("-fx-text-fill:red; -fx-font-weight:bold;");
            return false;
        }
    }

    @FXML
    private void accessDashboard() {
        if (login()) {
            lblStatus.setText("Accessing Legal Officer Dashboard...");
        } else {
            lblStatus.setText("Cannot access dashboard without login.");
            lblStatus.setStyle("-fx-text-fill:red; -fx-font-weight:bold;");
        }
    }
}
