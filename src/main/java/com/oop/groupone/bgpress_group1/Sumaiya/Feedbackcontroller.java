package com.oop.groupone.bgpress_group1.Sumaiya;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;

public class Feedbackcontroller
{
    @javafx.fxml.FXML
    private MenuBar menubar;
    @javafx.fxml.FXML
    private TableView<stafffedback> tableview;
    @javafx.fxml.FXML
    private TableColumn<stafffedback, String> feedbackcolumn;
    @javafx.fxml.FXML
    private TableColumn<stafffedback, LocalDate> datecolumn;
    @javafx.fxml.FXML
    private Label alertlabel;
    @javafx.fxml.FXML
    private TableColumn<stafffedback, String> staffidcolumn;
    @javafx.fxml.FXML
    private TableColumn<stafffedback, String> staffnamecolumn;

    @javafx.fxml.FXML
    public void initialize() {
        staffnamecolumn.setCellValueFactory(new PropertyValueFactory<>("staffname"));
        staffidcolumn.setCellValueFactory(new PropertyValueFactory<>("staffid"));
        feedbackcolumn.setCellValueFactory(new PropertyValueFactory<>("feedback"));
        datecolumn.setCellValueFactory(new PropertyValueFactory<>("date"));
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
    public void load(ActionEvent actionEvent) {
        try(ObjectInputStream stream = new ObjectInputStream(new FileInputStream("feedback.bin"))){
            while(true){

                stafffedback view=(stafffedback) stream.readObject();
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
}