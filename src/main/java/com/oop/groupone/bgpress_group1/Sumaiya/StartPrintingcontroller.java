package com.oop.groupone.bgpress_group1.Sumaiya;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StartPrintingcontroller
{

    @javafx.fxml.FXML
    private TableColumn<assignjobClass, String> jobnamecolumn;
    @javafx.fxml.FXML
    private TableView<assignjobClass> tableview;
    @javafx.fxml.FXML
    private TableColumn<assignjobClass, String> assignstaffcolumn;
    @javafx.fxml.FXML
    private TableColumn<assignjobClass , String> duedatecolumn;
    @javafx.fxml.FXML
    private Label alertlabel;
    @javafx.fxml.FXML
    private TextField staffidtf;


    private String startprinting="startPrinting.bin";

    @javafx.fxml.FXML
    public void initialize() {
        jobnamecolumn.setCellValueFactory(new PropertyValueFactory<>("jobname"));
        assignstaffcolumn.setCellValueFactory(new PropertyValueFactory<>("assignstaff"));
        duedatecolumn.setCellValueFactory(new PropertyValueFactory<>("duedate"));
    }
    //ArrayList<assignjobClass> startprintingList = new ArrayList<>();
    ObservableList<assignjobClass> startprintingList = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void loadbutton(ActionEvent actionEvent) {
        try(ObjectInputStream stream = new ObjectInputStream(new FileInputStream("printdata.bin"))){
            while(true){
                assignjobClass view=(assignjobClass) stream.readObject();
                //tableview.getItems().add(view);
                startprintingList.add(view);
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
        tableview.setItems(startprintingList);
    }

    @javafx.fxml.FXML
    public void startbutton(ActionEvent actionEvent) throws IOException {
        assignjobClass selectedJob = tableview.getSelectionModel().getSelectedItem();
        if (selectedJob == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Please select a job to start.");
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Job Started");
        alert.setHeaderText(null);
        alert.setContentText("Job '"  + "' marked as started and saved.");
        alert.showAndWait();
        alertlabel.setText("Saved to binary file");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateProgress.fxml"));
        Parent root = loader.load();

        UpdateProgresscontroller controller = loader.getController();
        controller.setJob(selectedJob);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

    }


    @javafx.fxml.FXML
    public void signoutbutton(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root= FXMLLoader.load(getClass().getResource("loginpage.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("new Scene");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void homebutton(ActionEvent actionEvent) throws IOException {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("BGStaff.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("new Scene");
            stage.setScene(scene);
            stage.show();
    }

    @javafx.fxml.FXML
    public void searchbutton(ActionEvent actionEvent) {
            ArrayList<assignjobClass> searchlist = new ArrayList<>();
            String jobid = staffidtf.getText();


            if (jobid.trim().isEmpty()) {
                alertlabel.setText("Enter a valid job id!");
                return;
            }
            for (assignjobClass search : startprintingList) {
                if (jobid.equals(search.getAssignstaff())) {
                    searchlist.add(search);
                }
            }
            tableview.getItems().clear();
            tableview.getItems().addAll(searchlist);

        }
    }