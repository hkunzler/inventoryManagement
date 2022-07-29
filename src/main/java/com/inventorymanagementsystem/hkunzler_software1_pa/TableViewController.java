package com.inventorymanagementsystem.hkunzler_software1_pa;

import com.inventorymanagementsystem.hkunzler_software1_pa.models.Part;
import com.inventorymanagementsystem.hkunzler_software1_pa.models.PartInventory;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
            if(Objects.equals(productPart, null)){
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Add");
                error.setContentText("Must select item to add");
                error.showAndWait();
            }else {
                PartInventory.addProductPart(productPart);
            }
        }
        if (Objects.equals(addProductPartButton.getText(), "Remove Associate Part"))
            if(Objects.equals(productPart, null)){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Delete");
            error.setContentText("Must select item to delete");
            error.showAndWait();
        }else {
                PartInventory.deleteProductPart(productPart);
            }
    }

}
