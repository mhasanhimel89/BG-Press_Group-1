package com.oop.groupone.bgpress_group1.Sumaiya;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class Assignjobcontroller
{
    @javafx.fxml.FXML
    private TableView<User> tableview;
    @javafx.fxml.FXML
    private TableColumn< assignjobClass , String> assignedstaffcolumn;
    @javafx.fxml.FXML
    private ComboBox< String> Jobnamecombobox;
    @javafx.fxml.FXML
    private TableColumn< assignjobClass , String> jobnamecolumn;
    @javafx.fxml.FXML
    private TableColumn<assignjobClass , LocalDate> duedatecolumn;
    @javafx.fxml.FXML
    private DatePicker datepicker;
    @javafx.fxml.FXML
    private TextField assignedstafftf;
    @javafx.fxml.FXML
    private ComboBox<String> jobtypecombobox;

    private String filename="printdata.bin";
    private String assignjob="assignjob.bin";
    @javafx.fxml.FXML
    private Label alertlabel;

    @javafx.fxml.FXML
    public void initialize() {
        Jobnamecombobox.getItems().addAll("Print","Edit","Design","Varify Error");
        jobtypecombobox.getItems().addAll("Print");
        jobnamecolumn.setCellValueFactory(new PropertyValueFactory<>("Jobname"));
        assignedstaffcolumn.setCellValueFactory(new PropertyValueFactory<>("assignstaff"));

        duedatecolumn.setCellValueFactory(new PropertyValueFactory<>("duedate"));

    }
    ArrayList<assignjobClass> assignjobList = new ArrayList<>();

    @javafx.fxml.FXML
    public void assignjob(ActionEvent actionEvent) {
        try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(assignjob))){
            for(User assign:tableview.getItems()) {
                stream.writeObject(assign);
            }
            alertlabel.setText(" Assigned job successfully & saved to binary file");
        } catch (IOException e) {
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
        Parent root= FXMLLoader.load(getClass().getResource("hmdashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void savebutton(ActionEvent actionEvent) {
        ArrayList<assignjobClass>savelist=new ArrayList<>();
        String jobtype=jobtypecombobox.getValue();
        if (jobtype == null) {
            alertlabel.setText("No job type selected!");
            return;
        }
        for(assignjobClass save: assignjobList){
            if(jobtype.equals(save.getJobname())){
                savelist.add(save);
            }
        }
        tableview.getItems().clear();
        tableview.getItems().addAll(savelist);


    }

    @javafx.fxml.FXML
    public void Add(ActionEvent actionEvent) {
        try{
            String jobname=Jobnamecombobox.getValue();
            String assignstaff= assignedstafftf.getText();
            String jobtype=jobtypecombobox.getValue();
            LocalDate duedate= datepicker.getValue();
            assignjobClass assignjobclass = new assignjobClass(jobname,assignstaff,jobtype,"Set Progress",duedate);
            assignjobList.add(assignjobclass);

            if (assignedstafftf.getText().trim().isEmpty()) {
                assignjobclass.ShowAlert("enter a valid Name", "error");
                return;
            }

            if (Jobnamecombobox.getValue().isEmpty()) {
                assignjobclass.ShowAlert("Choose a valid Job Namee", "error");
                return;
            }

            if (datepicker.getValue()==null) {
                assignjobclass.ShowAlert("enter a valid job name", "error");
            }

            assignjobclass.ShowAlert("Saved Successfully!","successfull");
            tableview.getItems().add(assignjobclass);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @javafx.fxml.FXML
    public void savebinary(ActionEvent actionEvent) {
        try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(filename))){
            for(User assign:tableview.getItems()) {
                stream.writeObject(assign);
            }
            alertlabel.setText("saved to binary file" + filename);
        } catch (IOException e) {
            alertlabel.setText("something went wrong");
        }

    }


}