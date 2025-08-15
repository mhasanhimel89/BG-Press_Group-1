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
import java.util.ArrayList;

public class ValidateBudgetResourcecontroller
{
    @javafx.fxml.FXML
    private TableColumn<validateBR,Double> budgetcolumn;
    @javafx.fxml.FXML
    private Label alertlabel;
    @javafx.fxml.FXML
    private TableColumn<validateBR, String> resourcecolumn;
    @javafx.fxml.FXML
    private TextField budgettf;
    @javafx.fxml.FXML
    private TableView<validateBR> tableview;
    @javafx.fxml.FXML
    private TextField quantitytf;
    @javafx.fxml.FXML
    private ComboBox<String> resourcecob;
    @javafx.fxml.FXML
    private TableColumn<validateBR, Integer> quantitycolumn;

    private String filename="validate.bin";

    @javafx.fxml.FXML
    public void initialize() {
        resourcecob.getItems().addAll("Ink","Paper","Printer","Toner", "Print tray","Computer","Maintenance Kit");

        resourcecolumn.setCellValueFactory(new PropertyValueFactory<>("resourcename"));
        quantitycolumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        budgetcolumn.setCellValueFactory(new PropertyValueFactory<>("budget"));
    }
    ArrayList<validateBR>validatelist=new ArrayList<>();

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
    public void updatereso(ActionEvent actionEvent) {
        try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(filename))){
            for(validateBR br:tableview.getItems()) {
                stream.writeObject(br);
            }
            alertlabel.setText(" saved successfully & saved to binary file");
        } catch (IOException e) {
            alertlabel.setText("something went wrong");
        }
    }

    @javafx.fxml.FXML
    public void save(ActionEvent actionEvent) {
        if(resourcecob.getItems()==null || quantitytf.getText().trim().isEmpty() || budgettf.getText().trim().isEmpty()){
            alertlabel.setText("please fill all the information");
            return;
        }
        try {
            String resource = resourcecob.getValue();
            int quantity = Integer.parseInt(quantitytf.getText());
            double budget = Double.parseDouble(budgettf.getText());
            validateBR validate = new validateBR(resource, quantity, budget);
            validatelist.add(validate);
            tableview.getItems().addAll(validatelist);
            alertlabel.setText("saved successfully");
        } catch (NumberFormatException e) {
            alertlabel.setText("somehting went wrong");
        }
    }
}