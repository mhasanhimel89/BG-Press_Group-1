package com.oop.groupone.bgpress_group1.Sumaiya;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;

public class UpdateProgresscontroller
{
    private assignjobClass currentJob;
    @javafx.fxml.FXML
    private Label alertlabel;
    @javafx.fxml.FXML
    private ComboBox progresscombobox;
    @javafx.fxml.FXML
    private Label jobnamelabel;
    @javafx.fxml.FXML
    private Label assignstafflabel;
    private assignjobClass job;
    @javafx.fxml.FXML
    private DatePicker duedate;

    @javafx.fxml.FXML
    public void initialize() {
    }
    private String filename="update.bin";
    @javafx.fxml.FXML
    public void updatebutton(ActionEvent actionEvent) {
        job.setProgress(progresscombobox.getValue().toString());
        alertlabel.setText("updated successfully");

        //((Stage) progresscombobox.getScene().getWindow()).close();


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

    public void setJob(assignjobClass job) {
        this.job = job;
        // initialize UI fields
        jobnamelabel.setText(job.getJobname());
        assignstafflabel.setText(job.getAssignstaff());
        duedate.setValue(LocalDate.parse(job.getDuedate().toString()));

        progresscombobox.setItems(FXCollections.observableArrayList("Not Started", "In Progress", "Completed"));
        progresscombobox.setValue(job.getProgress() != null ? job.getProgress() : "Not Started");

    }

    @Deprecated
    public void loadbutton(ActionEvent actionEvent) {
        try(ObjectInputStream stream = new ObjectInputStream(new FileInputStream("startPrinting.bin"))){
            while(true){

                assignjobClass view=(assignjobClass) stream.readObject();
               // tableview.getItems().add(view);
            }

        }catch(EOFException e) {
            alertlabel.setText("Loaded");
        }catch (IOException e){
            alertlabel.setText("Couldn't Load");
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            alertlabel.setText("something went wrong");
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void saveupdateoa(ActionEvent actionEvent) {
        String jobName = jobnamelabel.getText();
        String assignStaff = assignstafflabel.getText();
        LocalDate dueDate = duedate.getValue();
        String progress = progresscombobox.getValue().toString();

        assignjobClass job = new assignjobClass(jobName, assignStaff,"Set Progress",progress,dueDate);

        jobstorageclass.saveJob(job);

        alertlabel.setText("Job saved to binary file successfully!");


    }
}