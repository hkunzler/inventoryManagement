package com.inventorymanagementsystem.hkunzler_software1_pa;

import com.inventorymanagementsystem.hkunzler_software1_pa.models.Part;
import com.inventorymanagementsystem.hkunzler_software1_pa.models.PartInventory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class TableViewController implements Initializable {
    @FXML
    public TableView<Part> partTable;
    public Button addProductPartButton;
    @FXML
    private TableColumn<Part, Integer> itemStock;
    @FXML
    private TableColumn<Part, Integer> itemPrice;
    @FXML
    private TableColumn<Part, Integer> itemID;
    @FXML
    private TableColumn<Part, String> itemName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void addProductPart() {
        Part productPart = partTable.getSelectionModel().getSelectedItem();
        if (Objects.equals(addProductPartButton.getText(), "Add"))
            PartInventory.addAddedProducts(productPart, PartInventory.getAddedProducts());
        if (Objects.equals(addProductPartButton.getText(), "Remove Associate Part"))
            PartInventory.deleteAddedProduct(productPart, PartInventory.getAddedProducts());
    }

}
