package com.inventorymanagementsystem.hkunzler_software1_pa;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ProductFormController {
    @FXML
    public Label productFormTitle;
    @FXML
    TableViewController partsTableController;

    public void setHeader(String partFormTitle) {
        this.productFormTitle.setText(partFormTitle + " Product");
    }
}
