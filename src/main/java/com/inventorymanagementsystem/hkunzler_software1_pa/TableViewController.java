package com.inventorymanagementsystem.hkunzler_software1_pa;

import com.inventorymanagementsystem.hkunzler_software1_pa.models.Part;
import com.inventorymanagementsystem.hkunzler_software1_pa.models.PartInventory;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.Objects;

public class TableViewController {
    public Button addProductPartButton;
    @FXML
    public TableView<Part> partTable;
    @FXML
    private TableColumn<Part, Integer> itemStock;
    @FXML
    private TableColumn<Part, Integer> itemPrice;
    @FXML
    private TableColumn<Part, Integer> itemID;
    @FXML
    private TableColumn<Part, String> itemName;

    // In progress
    public void addProductPart() {

        // Get selected item from table
        Part productPart = partTable.getSelectionModel().getSelectedItem();

        // Add item
        if (Objects.equals(addProductPartButton.getText(), "Add")) {

            // Error alert if no item is selected to add
            if (Objects.equals(productPart, null)) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Add");
                error.setContentText("Must select item to add");
                error.showAndWait();

                // Add product to list
            } else {
                PartInventory.addProductPart(productPart);
            }
        }

        // Remove item
        if (Objects.equals(addProductPartButton.getText(), "Remove Associate Part"))

            // Error alert if no item is selected to remove
            if (Objects.equals(productPart, null)) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Delete");
                error.setContentText("Must select item to delete");
                error.showAndWait();

                // Remove product from list
            } else {
                PartInventory.deleteProductPart(productPart);
            }
    }

}
