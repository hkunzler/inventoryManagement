package com.inventorymanagementsystem.hkunzler_software1_pa;

import com.inventorymanagementsystem.hkunzler_software1_pa.models.EachPart;
import com.inventorymanagementsystem.hkunzler_software1_pa.models.PartInventory;
import com.inventorymanagementsystem.hkunzler_software1_pa.utils.uniqueIDGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.net.URL;
import java.util.ResourceBundle;

public class InventoryFormController implements Initializable {
    @FXML
    public TextField name;
    @FXML
    public TextField price;
    @FXML
    public TextField stock;
    @FXML
    public TextField min;
    @FXML
    public TextField max;
    PartInventory partInventory;
    EachPart eachPart;
    Pair<Boolean, String> inHouseOrOutsourced;
    @FXML
    private TextField id;

    public void setInHouseOrOutsourced(Pair<Boolean, String> inHouseOrOutsourced) {
        this.inHouseOrOutsourced = inHouseOrOutsourced;
    }

    public void onSavePart(ActionEvent actionEvent) {
        int id = uniqueIDGenerator.newId();
        PartInventory.addPart(new EachPart(id,
                name.getText(),
                Double.parseDouble(price.getText()),
                Integer.parseInt(stock.getText()),
                Integer.parseInt(min.getText()),
                Integer.parseInt(max.getText()), inHouseOrOutsourced));
    }

    public void onCancelPart(ActionEvent actionEvent) {
        ((Stage) (((Button) actionEvent.getSource()).getScene().getWindow())).close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
