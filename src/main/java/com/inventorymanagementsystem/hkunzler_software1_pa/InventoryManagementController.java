package com.inventorymanagementsystem.hkunzler_software1_pa;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class InventoryManagementController {
    @FXML
    private Label inventoryManagementLabel;
    @FXML
    private InventoryTableController partsTableController ;
    @FXML
    private InventoryTableController productsTableController ;

    @FXML
    public void initialize() {
        partsTableController.setFormType("part-form.fxml");

        productsTableController.setTableTitle("Products");
        productsTableController.setItemID("Product ID");
        productsTableController.setItemName("Product Name");
        productsTableController.setFormType("product-form.fxml");
    }


    public void inventoryManagementExitButton(ActionEvent actionEvent) {
    }
}
