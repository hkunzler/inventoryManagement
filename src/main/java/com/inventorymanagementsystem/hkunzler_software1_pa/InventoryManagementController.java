package com.inventorymanagementsystem.hkunzler_software1_pa;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class InventoryManagementController implements Initializable {
    @FXML
    private Label inventoryManagementLabel;
    @FXML
    private InventoryTableController partsTableController;
    @FXML
    private InventoryTableController productsTableController;

    public void inventoryManagementExitButton(ActionEvent actionEvent) {
        Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION);
        exitAlert.setTitle("Exit Warning");
        exitAlert.setContentText("Are you sure you want to exit?");
        exitAlert.showAndWait();

        Platform.exit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        partsTableController.setFormType("part-form.fxml");

        productsTableController.setTableTitle("Products");
        productsTableController.setItemID("Product ID");
        productsTableController.setItemName("Product Name");
        productsTableController.setFormType("product-form.fxml");
    }
}
