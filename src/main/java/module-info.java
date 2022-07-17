module com.inventorymanagementsystem.hkunzler_software1_pa {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.inventorymanagementsystem.hkunzler_software1_pa to javafx.fxml, javafx.controls;
    exports com.inventorymanagementsystem.hkunzler_software1_pa;

}