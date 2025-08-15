package com.oop.groupone.bgpress_group1.Sumaiya;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Paragraph;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import com.itextpdf.layout.property.TextAlignment;
import javafx.stage.Stage;

import com.itextpdf.layout.Document;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class GenerateReportcontroller
{
    @javafx.fxml.FXML
    private TableColumn<generatereport,String> progresscolumn;
    @javafx.fxml.FXML
    private TextField staffidtf;
    @javafx.fxml.FXML
    private TableColumn<generatereport, String> staffidcolumn;
    @javafx.fxml.FXML
    private DatePicker datepickerrr;
    @javafx.fxml.FXML
    private ComboBox<String> progresscob;
    @javafx.fxml.FXML
    private TextField tasktf;
    @javafx.fxml.FXML
    private TextField weektf;
    @javafx.fxml.FXML
    private TextField notestf;
    @javafx.fxml.FXML
    private TableView<generatereport> tableview;
    @javafx.fxml.FXML
    private TableColumn<generatereport, String> weeknocolumn;
    @javafx.fxml.FXML
    private TextField titletf;
    @javafx.fxml.FXML
    private Label alertlabel;

    @javafx.fxml.FXML
    public void initialize() {
        progresscob.getItems().addAll("Completed","Not Started","In Progress");
        weeknocolumn.setCellValueFactory(new PropertyValueFactory<>("week"));
        staffidcolumn.setCellValueFactory(new PropertyValueFactory<>("staffid"));
        progresscolumn.setCellValueFactory(new PropertyValueFactory<>("progress"));

    }
    ArrayList<generatereport> reportlist=new ArrayList<>();

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
    public void pdf(ActionEvent actionEvent) {
        generatereport selectedReport = tableview.getSelectionModel().getSelectedItem();
        if (selectedReport == null) {
            alertlabel.setText("No Report Selected");
            return;
        }
        if (selectedReport == null) {
            alertlabel.setText("No Report Selected");
            return;
        }
        try {
            String fileName = "WeeklyReport_" + selectedReport.getStaffid() + "_" + LocalDate.now() + ".pdf";
            File destFile = new File(fileName);
            PdfWriter writer = new PdfWriter(destFile);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);
            document.add(new Paragraph("WEEKLY REPORT REVIEW")
                    .setBold()
                    .setFontSize(16)
                    .setTextAlignment(TextAlignment.CENTER));
            document.add(new Paragraph("Generated on: " + LocalDate.now())
                    .setTextAlignment(TextAlignment.CENTER));
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("Week No.: " + selectedReport.getWeek()));
            document.add(new Paragraph("Staff ID: " + selectedReport.getStaffid()));
            document.add(new Paragraph("Progress Status: " + selectedReport.getProgress()));
            document.close();
            alertlabel.setText("Export Successful ");

        } catch (Exception e) {
            e.printStackTrace();
            alertlabel.setText("Export Failed");
        }


    }

    @javafx.fxml.FXML
    public void approvereport(ActionEvent actionEvent) {
        if( staffidtf.getText().trim().isEmpty() || titletf.getText().trim().isEmpty() || weektf.getText().trim().isEmpty()) {
            alertlabel.setText("please fill all the information");
            return;
        }

        if( progresscob.getValue()==null|| datepickerrr.getValue()==null || tasktf.getText().trim().isEmpty()) {
            alertlabel.setText("please fill all the information");
            return;
        }
        try{
            String week=weektf.getText();
            String staffid=staffidcolumn.getText();
            String progress=progresscob.getValue();
            generatereport report= new generatereport(week,staffid,progress);
            reportlist.add(report);
            tableview.getItems().addAll(reportlist);
            alertlabel.setText("added successfully");
        } catch (Exception e) {
            alertlabel.setText("something went wrong");
        }
    }

    @javafx.fxml.FXML
    public void close(ActionEvent actionEvent) {
        staffidtf.clear();
        weektf.clear();
        progresscob.getSelectionModel().clearSelection();
        tableview.getItems().clear();

        staffidtf.setText("");
        weektf.setText("");
        alertlabel.setText("cleared all");


    }

}