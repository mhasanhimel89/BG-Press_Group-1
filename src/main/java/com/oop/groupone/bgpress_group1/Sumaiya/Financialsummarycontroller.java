package com.oop.groupone.bgpress_group1.Sumaiya;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Financialsummarycontroller
{
    @javafx.fxml.FXML
    private MenuBar menubar;
    @javafx.fxml.FXML
    private PieChart piechart;

    @javafx.fxml.FXML
    public void initialize() {
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
    public void Loadoa(ActionEvent actionEvent) {
        List<PieChart.Data> dataList = getData();
         piechart.getData().addAll(dataList);
    }

    private List<PieChart.Data> getData() {
//        List<PieChart.Data> dataList = new ArrayList<>();
//        dataList.add(new PieChart.Data("Total Revenue", 7));
//        dataList.add(new PieChart.Data("Total Expenses", 4));
//        dataList.add(new PieChart.Data("Total Profit", 5));
//        return dataList;
        List<PieChart.Data> dataList = new ArrayList<>();
        double total = 7 + 4 + 5;

        dataList.add(new PieChart.Data("Total Revenue " + String.format("%.1f%%", (7 / total) * 100), 7));
        dataList.add(new PieChart.Data("Total Expenses " + String.format("%.1f%%", (4 / total) * 100), 4));
        dataList.add(new PieChart.Data("Total Profit " + String.format("%.1f%%", (5 / total) * 100), 5));

        return dataList;

    }
}