package your.package;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FeedbackSubmissionController {

    @FXML private TextArea txtFeedbackText;
    @FXML private Slider sliderRating;
    @FXML private Label lblRatingValue;
    @FXML private CheckBox chkIsSubmitted;
    @FXML private Label lblThanks;

    @FXML
    private void initialize() {
        sliderRating.valueProperty().addListener((obs, oldVal, newVal) ->
                lblRatingValue.setText(String.format("%.1f", newVal))
        );
    }

    @FXML
    private boolean submitFeedback() {
        chkIsSubmitted.setSelected(true);
        return chkIsSubmitted.isSelected();
    }

    @FXML
    private void showThanks() {
        lblThanks.setText("Thank you for your feedback!");
    }
}
