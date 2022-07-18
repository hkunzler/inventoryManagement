package com.inventorymanagementsystem.hkunzler_software1_pa;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PartFormController {
    @FXML
    public Label partFormTitle;

    public void setPartFormTitle(String data) {
        partFormTitle.setText(data);
    }
    public void onCancelPart(ActionEvent actionEvent) {
    }

    public void onSavePart(ActionEvent actionEvent) {
    }
}
