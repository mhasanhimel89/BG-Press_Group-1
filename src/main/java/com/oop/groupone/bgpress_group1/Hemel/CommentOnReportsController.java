package com.oop.groupone.bgpress_group1.Hemel;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CommentOnReportsController
{
    @javafx.fxml.FXML
    private TextField reportIdField;
    @javafx.fxml.FXML
    private TextArea commentTextArea;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private Button saveButton;


    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void validateCommentOnButton(ActionEvent actionEvent) {
        try {
            int reportId = Integer.parseInt(reportIdField.getText());
            String comment = commentTextArea.getText();

            if (comment.isEmpty()) {
                statusLabel.setText("Comment cannot be empty!");
                saveButton.setDisable(true);
            } else {
                statusLabel.setText("Validation successful - ready to save");
                saveButton.setDisable(false);
            }
        } catch (NumberFormatException e) {
            statusLabel.setText("Report ID must be a number!");
            saveButton.setDisable(true);
        }

    }

    @javafx.fxml.FXML
    public void saveCommentOnButton(ActionEvent actionEvent) {
        statusLabel.setText("Comment saved successfully!");
        saveButton.setDisable(true);

    }

    @javafx.fxml.FXML
    public void nextOnButton(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("RVDashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }
}