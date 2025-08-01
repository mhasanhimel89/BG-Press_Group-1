module com.oop.groupone.bgpress_group1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.oop.groupone.bgpress_group1 to javafx.fxml;
    opens com.oop.groupone.bgpress_group1.Sumaiya to javafx.fxml, javafx.base;
    opens com.oop.groupone.bgpress_group1.Sumaiya.headmanager to javafx.fxml, javafx.base;
    exports com.oop.groupone.bgpress_group1;
}