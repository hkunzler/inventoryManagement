package com.inventorymanagementsystem.hkunzler_software1_pa;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ProductFormController {
    @FXML
    public Label productFormTitle;

    public void setProductFormTitle(String data) {
        productFormTitle.setText(data);
    }

    public void setHeader(String partFormTitle) {
        this.productFormTitle.setText(partFormTitle + " Part");
    }
}
