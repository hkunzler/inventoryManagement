package com.inventorymanagementsystem.hkunzler_software1_pa;

import com.inventorymanagementsystem.hkunzler_software1_pa.models.Part;
import com.inventorymanagementsystem.hkunzler_software1_pa.utils.uniqueIDGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class InventoryFormController implements Initializable {
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

//    @FXML
//    private Boolean outsourced;
//    public void setOutsourced(String outsourced) {
//        this.outsourced.
//    }
    public void onSavePart(ActionEvent actionEvent) {
        String strID = Integer.toString(uniqueIDGenerator.newId());
        id.setText(strID);

        System.out.print(id.getText());

    }

    public void onCancelPart(ActionEvent actionEvent) {
        ((Stage)(((Button)actionEvent.getSource()).getScene().getWindow())).close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
