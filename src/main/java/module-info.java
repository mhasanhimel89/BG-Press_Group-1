module com.oop.groupone.bgpress_group1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.oop.groupone.bgpress_group1 to javafx.fxml;
    exports com.oop.groupone.bgpress_group1;
}