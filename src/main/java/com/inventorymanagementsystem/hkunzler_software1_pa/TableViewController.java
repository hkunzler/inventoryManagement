package com.inventorymanagementsystem.hkunzler_software1_pa;

import com.inventorymanagementsystem.hkunzler_software1_pa.models.Part;
import com.inventorymanagementsystem.hkunzler_software1_pa.models.PartInventory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.Objects;

public class TableViewController {
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

    public void addProductPart() {
        Part productPart = partTable.getSelectionModel().getSelectedItem();
        if (Objects.equals(addProductPartButton.getText(), "Add")) {
            PartInventory.addProductPart(productPart);
        }
        if (Objects.equals(addProductPartButton.getText(), "Remove Associate Part"))
            PartInventory.deleteProductPart(productPart);
    }

}
