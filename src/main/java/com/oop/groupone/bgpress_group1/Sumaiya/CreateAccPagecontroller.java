package com.oop.groupone.bgpress_group1.Sumaiya;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InterruptedIOException;

public class CreateAccPagecontroller
{
    @javafx.fxml.FXML
    private TextField phonetextfield;
    @javafx.fxml.FXML
    private RadioButton femaleradiobutton;
    @javafx.fxml.FXML
    private TextField addresstextfield;
    @javafx.fxml.FXML
    private PasswordField passwordtextfield;
    @javafx.fxml.FXML
    private RadioButton otherradiobutton;
    @javafx.fxml.FXML
    private TextField nametextfield;
    @javafx.fxml.FXML
    private TextField emailtextfield;
    @javafx.fxml.FXML
    private Label alertlabel;
    @javafx.fxml.FXML
    private RadioButton maleradiobutton;
    @javafx.fxml.FXML
    private DatePicker datepicker;
    @javafx.fxml.FXML
    private Button createaccountbutton;
    @javafx.fxml.FXML
    private ComboBox accountytpecombobox;


    @javafx.fxml.FXML
    public void initialize() {
        accountytpecombobox.getItems().addAll("Head Manager","BG Staff");

    }


    @javafx.fxml.FXML
    public void createaccountbuttononaction(ActionEvent actionEvent) {

        String userId=nametextfield.getText();
        String email=emailtextfield.getText();
        String phone=phonetextfield.getText();
        String address=addresstextfield.getText();
        String dob= String.valueOf(datepicker.getValue());
        String password=passwordtextfield.getText();
        String accounttype= accountytpecombobox.getValue().toString();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt",true))) {
            writer.write(userId +"," +email+","+ phone+","+address+","+dob+","+password+","+accounttype);
            writer.newLine();
            alertlabel.setText("successfully created");

        }catch(IOException e) {
            e.printStackTrace();
            alertlabel.setText("error");
        }
    }

    @javafx.fxml.FXML
    public void nextbuttononaction(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root= FXMLLoader.load(getClass().getResource("loginpage.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }
}