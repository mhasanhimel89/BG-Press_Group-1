package com.oop.groupone.bgpress_group1.Sumaiya;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class Stafffeedbackcontroller
{
    @javafx.fxml.FXML
    private TextField staffidtf;
    @javafx.fxml.FXML
    private DatePicker datepickerr;
    @javafx.fxml.FXML
    private TextField staffnametf;
    @javafx.fxml.FXML
    private TextArea feedbackta;
    @javafx.fxml.FXML
    private TableColumn<stafffedback, String> staffnamecolumn;
    @javafx.fxml.FXML
    private TableColumn<stafffedback, String> staffifcolumn;
    @javafx.fxml.FXML
    private TableColumn<stafffedback,String> feedbackcolumn;
    @javafx.fxml.FXML
    private TableColumn<stafffedback, LocalDate> datecolumn;
    @javafx.fxml.FXML
    private TableView<stafffedback> tavleview;
    @javafx.fxml.FXML
    private Label alertlabel;


    private String filename= "feedback.bin";

    @javafx.fxml.FXML
    public void initialize() {
        staffnamecolumn.setCellValueFactory(new PropertyValueFactory<>("staffname"));
        staffifcolumn.setCellValueFactory(new PropertyValueFactory<>("staffid"));
        feedbackcolumn.setCellValueFactory(new PropertyValueFactory<>("feedback"));
        datecolumn.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    ArrayList<stafffedback> feedbacklist=new ArrayList<>();

    @javafx.fxml.FXML
    public void add(ActionEvent actionEvent) {
        if( staffnametf.getText().trim().isEmpty() || staffidtf.getText().trim().isEmpty() || feedbackta.getText().trim().isEmpty()){
            alertlabel.setText("please fill all the information");
            return;
        }
        try{
            String staffname= staffnametf.getText();
            String staffid=staffidtf.getText();
            String feedback=feedbackta.getText();
            LocalDate date =  datepickerr.getValue();
            stafffedback fb= new stafffedback(staffname,staffid,feedback,date);
            feedbacklist.add(fb);
            tavleview.getItems().addAll(feedbacklist);
            alertlabel.setText("added successfully");

        } catch (Exception e) {
            alertlabel.setText("something went wrong");
        }
    }

    @javafx.fxml.FXML
    public void signout(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root= FXMLLoader.load(getClass().getResource("loginpage.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void home(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root= FXMLLoader.load(getClass().getResource("BGStaff.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void save(ActionEvent actionEvent) {
        try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(filename))){
            for(stafffedback fbb:tavleview.getItems()) {
                stream.writeObject(fbb);
            }
            alertlabel.setText(" feedback submitted successfully & saved to binary file");
        } catch (IOException e) {
            alertlabel.setText("something went wrong");
        }
    }
}