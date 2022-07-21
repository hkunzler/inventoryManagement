package com.inventorymanagementsystem.hkunzler_software1_pa;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.util.Pair;

public class PartFormController {
    @FXML
    public RadioButton inHouse;
    @FXML
    public RadioButton outsourced;
    @FXML
    public TextField partType;
    @FXML
    public Label partFormTitle;
    @FXML
    public Label sourceLabel;
    Pair<Boolean, String> inHouseOrOutsourced;
    @FXML
    private InventoryFormController partFormController;

    public void initialize() {
        inHouse.setSelected(true);
        outsourced.setSelected(false);
        sourceLabel.setText("Machine ID");
        setInHouseOrOutsourced(new Pair<>(inHouse.isSelected(), partType.getText()));
    }

    public void setInHouseOrOutsourced(Pair<Boolean, String> inHouseOrOutsourced) {
        this.inHouseOrOutsourced = inHouseOrOutsourced;
        partFormController.setInHouseOrOutsourced(inHouseOrOutsourced);
    }

    @FXML
    public void onInHouseSelect() {
        inHouse.setSelected(true);
        outsourced.setSelected(false);
        sourceLabel.setText("Machine ID");
        setInHouseOrOutsourced(new Pair<>(inHouse.isSelected(), partType.getText()));
    }

    @FXML
    public void onOutsourceSelect() {
        inHouse.setSelected(false);
        outsourced.setSelected(true);
        sourceLabel.setText("Company ID");
        setInHouseOrOutsourced(new Pair<>(inHouse.isSelected(), partType.getText()));
    }
}
