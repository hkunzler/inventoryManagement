package com.inventorymanagementsystem.hkunzler_software1_pa;

import com.inventorymanagementsystem.hkunzler_software1_pa.models.Part;
import com.inventorymanagementsystem.hkunzler_software1_pa.models.PartInventory;
import com.inventorymanagementsystem.hkunzler_software1_pa.models.Product;
import com.inventorymanagementsystem.hkunzler_software1_pa.utils.buttons;
import com.inventorymanagementsystem.hkunzler_software1_pa.utils.errorHandling;
import com.inventorymanagementsystem.hkunzler_software1_pa.utils.searchResults;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class InventoryTableController implements Initializable {
    public TextField searchField;
    @FXML
    private Label tableTitle;
    @FXML
    private TableView<Part> partTable;
    @FXML
    private TableColumn<Part, Integer> itemStock;
    @FXML
    private TableColumn<Part, Integer> itemPrice;
    @FXML
    private TableColumn<Part, Integer> itemID;
    @FXML
    private TableColumn<Part, String> itemName;
    private String formLoader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {

            // Sets part table values
            if (getIsPartForm(tableTitle)) {

                // Uses searchResults.java to filter items if needed
                partTable.setItems(searchResults.getTableItems(PartInventory.getParts(), searchField, partTable));
            }

            // Sets product table value
            else {

                // Uses searchResults.java to filter items if needed
                partTable.setItems(searchResults.getTableItems(PartInventory.getProducts(), searchField, partTable));
            }
        });

    }


    // Triggered by the button for adding/modifying both part/product forms
    public void onOpenForm(ActionEvent actionEvent) throws IOException {

        // Uses button text to determine Modify form vs Add form
        String form = ((Button) actionEvent.getSource()).getText();
        boolean isModifyingForm = Objects.equals(form, "Modify");

        // Error alert shown if no item selected to modify
        if (Objects.equals(getSelectedItem(partTable), null) && isModifyingForm) {
            errorHandling.selectItemAlert("modify");


            // Loads the form
        } else {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formLoader));
            Parent root = (fxmlLoader.load());

            // Product form
            if (!getIsPartForm(tableTitle)) {

                // Gets controller for product form
                ProductFormController controller = fxmlLoader.getController();

                // Modify Product form
                if (isModifyingForm) {

                    // In progress
                    if (PartInventory.getProductsTest().size() > 0) {
                        for (Product part1 : PartInventory.getProductsTest()
                        ) {
//                            controller.addedPartsController.partTable.setItems(PartInventory.getProductPartsTest(part1));
                            if (part1 != null) {
                                ObservableList<Part> temp = PartInventory.getProductPartsTest(part1);
                                if (temp != null) {
                                    PartInventory.getProductPartsTest(part1);
                                    PartInventory.addProductPart(getSelectedItem(controller.addedPartsController.partTable));
                                }
                            }
                        }
                    }

                    // Adds product item to separate list for modifying
                    onModify();
                }

                // Sets header to form selected (Add / Modify)
                controller.setHeader(form);

                // Sets items in the Products Selected Items table
                controller.addedPartsController.partTable.setItems(PartInventory.getProductParts());

                // Sets items in the Products Inventory table
                // Uses searchResults.java to filter items if needed
                controller.partsTableController.partTable.setItems(searchResults.getTableItems(PartInventory.getParts(), controller.searchField, controller.partsTableController.partTable));

                // Sets button text for removing selected item
                controller.addedPartsController.addProductPartButton.setText("Remove Associate Part");

                // Lets the InventoryFormController know to edit the product form
                controller.productFormController.setIsPartForm(getIsPartForm(tableTitle));

                // Lets the InventoryFormController know if in Modify form
                controller.productFormController.setIsModifyForm(isModifyingForm);

                // Part form
            } else {

                // Gets controller for part form
                PartFormController controller = fxmlLoader.getController();

                // Shows alert if no item selected to modify
                if (Objects.equals(getSelectedItem(partTable), null) && isModifyingForm) {
                    errorHandling.selectItemAlert("modify");

                    // Closes form
                    onCancelPart(actionEvent);

                    // Gets Modify Part screen
                } else if (getSelectedItem(partTable) != null && isModifyingForm) {

                    // Lets the InventoryFormController know in Modify form
                    controller.partFormController.setIsModifyForm(true);

                    // Adds part item to separate list for modifying
                    onModify();
                }

                // Sets header to form selected (Add / Modify)
                controller.setHeader(form);

                // Lets the InventoryFormController know to edit the part form
                controller.partFormController.setIsPartForm(getIsPartForm(tableTitle));
            }

            // Shows scene
            stage.setScene(new Scene(root));
            stage.show();

            // Sets window title to form selected name
            stage.setTitle(form);
        }
    }

    //Modify table item
    public void onModify() {

        // Adds Part item to separate list to modify
        if (getIsPartForm(tableTitle)) PartInventory.addModifiedPart(getSelectedItem(partTable));

            // Adds Product item to separate list to modify
        else PartInventory.addModifiedProducts(getSelectedItem(partTable));
    }

    // Removes selected item from table
    public void onDelete() {

        // Error Alert shown if no item selected to delete
        if (Objects.equals(getSelectedItem(partTable), null)) {
            errorHandling.selectItemAlert("delete");
        }

        // Removes item from part table
        else if (getIsPartForm(tableTitle)) PartInventory.deletePart(getSelectedItem(partTable));

            // Removes item from product table
        else PartInventory.deleteProduct(getSelectedItem(partTable));
    }

    // Returns selected table item
    private Part getSelectedItem(TableView<Part> selectedItem) {
        return (selectedItem).getSelectionModel().getSelectedItem();
    }

    // Returns true if == "Parts"
    private boolean getIsPartForm(Label formTitle) {
        return Objects.equals(((formTitle).getText()), "Parts");
    }

    // Used by InventoryManagementController to set title of Part/Product table
    public void setTableTitle(String tableTitle) {
        this.tableTitle.setText(tableTitle);
    }

    // Used by InventoryManagementController to set ID column name of Part/Product table
    public void setItemID(String itemID) {
        this.itemID.setText(itemID);
    }

    // Used by InventoryManagementController to set item name column of Part/Product table
    public void setItemName(String itemName) {
        this.itemName.setText(itemName);
    }

    // Used by InventoryManagementController to set FXML file for Part/Product table
    public void setFormLoader(String formLoader) {
        this.formLoader = formLoader;
    }

    // Closes form
    private void onCancelPart(ActionEvent actionEvent) {
        buttons.onExit(actionEvent);
    }
}
