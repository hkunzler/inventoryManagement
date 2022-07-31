package com.inventorymanagementsystem.hkunzler_software1_pa;

import com.inventorymanagementsystem.hkunzler_software1_pa.utils.errorHandling;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class InventoryManagementController implements Initializable {
    // Nested fxml
    @FXML
    InventoryTableController partsTableController;
    @FXML
    InventoryTableController productsTableController;
    @FXML
    private Label inventoryManagementLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initial values for part form
        partsTableController.setFormLoader("part-form.fxml");

        // Initial values for product form
        productsTableController.setTableTitle("Products");
        productsTableController.setItemID("Product ID");
        productsTableController.setItemName("Product Name");
        productsTableController.setFormLoader("product-form.fxml");
    }

    // Exit confirmation - will exit project
    public void inventoryManagementExitButton() {
        errorHandling.exitAlert();

        Platform.exit();
    }
}
