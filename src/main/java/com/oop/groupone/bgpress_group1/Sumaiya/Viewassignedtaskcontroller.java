package com.oop.groupone.bgpress_group1.Sumaiya;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Viewassignedtaskcontroller
{
    @javafx.fxml.FXML
    private TableView<assignjobClass> tableview;
    @javafx.fxml.FXML
    private TableColumn<assignjobClass, LocalDate> duedatecolumn;
    @javafx.fxml.FXML
    private TableColumn<assignjobClass, String> Assignedstaffcolumn;
    @javafx.fxml.FXML
    private TableColumn<assignjobClass, String>Jobnamecolumn;

//    private String load="ViewAssignTask.bin";
    @javafx.fxml.FXML
    private Label alertlabel;

    @javafx.fxml.FXML
    public void initialize() {
        Jobnamecolumn.setCellValueFactory(new PropertyValueFactory<>("Jobname"));
        Assignedstaffcolumn.setCellValueFactory(new PropertyValueFactory<>("assignstaff"));
        duedatecolumn.setCellValueFactory(new PropertyValueFactory<>("duedate"));
    }
    ArrayList<assignjobClass> ViewtaskList = new ArrayList<>();

    @javafx.fxml.FXML
    public void load(ActionEvent actionEvent) {
        try(ObjectInputStream stream = new ObjectInputStream(new FileInputStream("assignjob.bin"))){
            while(true){

               assignjobClass view=(assignjobClass) stream.readObject();
               tableview.getItems().add(view);
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
}