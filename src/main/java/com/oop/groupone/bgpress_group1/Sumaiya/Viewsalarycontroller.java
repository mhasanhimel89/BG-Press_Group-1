package com.oop.groupone.bgpress_group1.Sumaiya;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Paragraph;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.itextpdf.layout.property.TextAlignment;

import com.itextpdf.layout.Document;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Viewsalarycontroller
{
    @javafx.fxml.FXML
    private TextField jobnametf;
    @javafx.fxml.FXML
    private TextField nametf;
    @javafx.fxml.FXML
    private TextField staffidtf;
    @javafx.fxml.FXML
    private Label netsalarylabel;
    @javafx.fxml.FXML
    private Label deductionlabel;
    @javafx.fxml.FXML
    private Label bonuslabel;
    @javafx.fxml.FXML
    private ComboBox<String> monthcombobox;
    @javafx.fxml.FXML
    private Label alertlabel;
    @javafx.fxml.FXML
    private ComboBox<String> yearcombobox;
    @javafx.fxml.FXML
    private Label salarylabel;

    private List<salaryslip> salaryData = new ArrayList<>();
    private salaryslip selectedSlip = null;


    @javafx.fxml.FXML
    public void initialize() {
        monthcombobox.getItems().addAll("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");

        yearcombobox.getItems().addAll("2023", "2024", "2025");

        salaryData.add(new salaryslip(
                "BG001", "Hasan Ahmed", "Edit", "August",
                "2025", 30000.00,
                5000.00, 2000.00, 33000.00
        ));
        salaryData.add(new salaryslip(
                "BG002", "Rafiq Hossain", "Printing", "August",
                "2025", 25000.00,
                3000.00, 600.00, 27400.00
        ));

        salaryData.add(new salaryslip(
                "BG003", "Ekramul Haque", "Writing", "August",
                "2025", 30000.00,
                6000.00, 2000.00, 34000.00
        ));

        salaryData.add(new salaryslip(
                "BG004", "Shaek Ahmed", "Compose", "August",
                "2025", 30000.00,
                5000.00, 2000.00, 33000.00
        ));

    }

    @javafx.fxml.FXML
    public void viewsalary(ActionEvent actionEvent) {
        String selectedMonth = monthcombobox.getValue();
        String selectedYear = yearcombobox.getValue();
        String enteredStaffId = staffidtf.getText().trim(); // Use user input

        if (selectedMonth == null || selectedYear == null || enteredStaffId.isEmpty()) {
            alertlabel.setText("Please select month, year, and enter Staff ID.");
            return;
        }

        for (salaryslip slip : salaryData) {
            if (slip.getEmployeeId().equalsIgnoreCase(enteredStaffId)
                    && slip.getMonth().equalsIgnoreCase(selectedMonth)
                    && String.valueOf(slip.getYear()).equals(selectedYear)) {

                String currentEmployeeId = staffidtf.getText().trim();
                if (slip.getEmployeeId().equals(currentEmployeeId)) {
                    selectedSlip = slip;

                    nametf.setText(slip.getName());
                    jobnametf.setText(slip.getJobname()); // optional if you have this
                    salarylabel.setText(slip.getBasicSalary() + " BDT");
                    bonuslabel.setText(slip.getBonus() + " BDT");
                    deductionlabel.setText(slip.getDeduction() + " BDT");
                    netsalarylabel.setText(slip.getNetsalary() + " BDT");
                    alertlabel.setText(""); // Clear previous alerts
                    return;
                }
            }
        }

        alertlabel.setText("No data found for selected Staff ID, month, and year.");
    }



    @javafx.fxml.FXML
    public void exportpdf(ActionEvent actionEvent) {
        if (selectedSlip == null) {
            alertlabel.setText("Please view a slip first before exporting.");
            return;
        }

        try {
            String fileName = "SalarySlip_" + selectedSlip.getEmployeeId() + "_" +
                    selectedSlip.getMonth() + "_" + selectedSlip.getYear() + ".pdf";
            File destFile = new File(fileName);
            PdfWriter writer = new PdfWriter(destFile);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            document.add(new Paragraph("বাংলাদেশ গভর্নমেন্ট প্রেস")
                    .setBold().setFontSize(18).setTextAlignment(TextAlignment.CENTER));
            document.add(new Paragraph("Employee Salary Slip")
                    .setFontSize(14).setTextAlignment(TextAlignment.CENTER));
            document.add(new Paragraph("\n"));

            document.add(new Paragraph("Employee ID: " + selectedSlip.getEmployeeId()));
            document.add(new Paragraph("Name: " + selectedSlip.getName()));
            document.add(new Paragraph("Month: " + selectedSlip.getMonth() + " " + selectedSlip.getYear()));
            document.add(new Paragraph("\nSalary Breakdown:\n"));
            document.add(new Paragraph("Basic Pay: " + selectedSlip.getBasicSalary() + " BDT"));
            document.add(new Paragraph("Bonus: " + selectedSlip.getBonus() + " BDT"));
            document.add(new Paragraph("Deductions: " + selectedSlip.getDeduction() + " BDT"));
            document.add(new Paragraph("Net Pay: " + selectedSlip.getNetsalary() + " BDT")
                    .setBold().setTextAlignment(TextAlignment.RIGHT));

            document.close();
            alertlabel.setText("PDF exported successfully");

        } catch (Exception e) {
            e.printStackTrace();
            alertlabel.setText("Error while exporting PDF");
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
    public void close(ActionEvent actionEvent) {
        staffidtf.clear();
        nametf.clear();
        jobnametf.clear();
        monthcombobox.getSelectionModel().clearSelection();
        yearcombobox.getSelectionModel().clearSelection();

        salarylabel.setText("");
        bonuslabel.setText("");
        deductionlabel.setText("");
        netsalarylabel.setText("");
        alertlabel.setText("cleared all");

        selectedSlip = null;
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