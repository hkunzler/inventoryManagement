module com.inventorymanagementsystem.hkunzler_software1_pa {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.inventorymanagementsystem.hkunzler_software1_pa to javafx.fxml, javafx.controls;
    exports com.inventorymanagementsystem.hkunzler_software1_pa;
    exports com.inventorymanagementsystem.hkunzler_software1_pa.models;
    exports com.inventorymanagementsystem.hkunzler_software1_pa.utils;
    opens com.inventorymanagementsystem.hkunzler_software1_pa.utils to javafx.controls, javafx.fxml;
}