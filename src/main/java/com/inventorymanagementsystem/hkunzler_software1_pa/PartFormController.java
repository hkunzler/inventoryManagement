package com.inventorymanagementsystem.hkunzler_software1_pa;
import com.inventorymanagementsystem.hkunzler_software1_pa.models.Part;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class PartFormController implements Initializable {
    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField price;
    @FXML
    private TextField stock;
    @FXML
    private TextField min;
    @FXML
    private TextField max;

    @FXML
    private RadioButton inHouse;
    @FXML
    private RadioButton outsourced;

    @FXML
    public Label partFormTitle;

    public void setPartFormTitle(String data) {
        partFormTitle.setText(data);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void onInHouseSelect() {
        inHouse.setSelected(true);
        outsourced.setSelected(false);
    }

    @FXML
    public void onOutsourceSelect() {
        inHouse.setSelected(false);
        outsourced.setSelected(true);
    }
}
