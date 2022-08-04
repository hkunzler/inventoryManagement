package com.inventorymanagementsystem.hkunzler_software1_pa;

import com.inventorymanagementsystem.hkunzler_software1_pa.models.EachPart;
import com.inventorymanagementsystem.hkunzler_software1_pa.models.Part;
import com.inventorymanagementsystem.hkunzler_software1_pa.models.PartInventory;
import com.inventorymanagementsystem.hkunzler_software1_pa.models.Product;
import com.inventorymanagementsystem.hkunzler_software1_pa.utils.errorHandling;
import com.inventorymanagementsystem.hkunzler_software1_pa.utils.uniqueIDGenerator;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class InventoryFormController implements Initializable {
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
    private TextField id;
    private boolean isModifyForm = false;
    private boolean isPartForm = true;
    private Pair<Boolean, String> inHouseOrOutsourced;
    private Part modify;

    int newId = uniqueIDGenerator.newId();

    // Action for save button
    public void onSavePart(ActionEvent actionEvent) {

        // Continue if no errors
        if (!errorHandling.hasErrors(stock, min, max, price, name)) {
            if (isPartForm) {

                // Is modify part form
                if (isModifyForm) {
                    PartInventory.getParts().set(PartInventory.getParts().indexOf(modify),
                            formValues("part", "modify"));

                    // Is add part form
                } else {
                    PartInventory.addPart(formValues("part", "add"));
                }

                // Is product form
            } else {

                // Is modify product form
                if (isModifyForm) {
//                    PartInventory.getProducts().set(PartInventory.getProducts().indexOf(modify),
//                            formValues("product", "modify"));

                    // Is add product form
                } else {

                    // Saving it with Part model
                    PartInventory.addProduct(formValues("product", "add"));

                    // Trying to add it with Product model
                    PartInventory.addProductsTest(new Product(newId, name.getText(),
                            Double.parseDouble(price.getText()),
                            Integer.parseInt(stock.getText()),
                            Integer.parseInt(min.getText()),
                            Integer.parseInt(max.getText()), PartInventory.getProductParts()));
                }
            }

            // Exits window on save
            onExit(actionEvent);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {

            // If Part form
            if (!(PartInventory.getModifiedParts()).isEmpty()) {
                setModifyFormContent((PartInventory.getModifiedParts()).get(0));

                // If Product form
            } else if (!(PartInventory.getModifiedProducts()).isEmpty()) {
                setModifyFormContent((PartInventory.getModifiedProducts()).get(0));
            }

            // If is Modify form
            if (isModifyForm) {
                id.setText(Integer.toString(modify.getId()));
                name.setText(modify.getName());
                price.setText(Double.toString(modify.getPrice()));
                stock.setText(Integer.toString(modify.getStock()));
                min.setText(Integer.toString(modify.getMin()));
                max.setText(Integer.toString(modify.getMax()));
            }
        });
    }

    public Part formValues(String form, String modify) {
        // Generates unique id or uses stored id
        int formId = Objects.equals(modify, "modify") ? Integer.parseInt(id.getText()) : newId;

        // Checks if adding/modifying product/part
        return Objects.equals(form, "product") ? new Product(formId, name.getText(),
                Double.parseDouble(price.getText()),
                Integer.parseInt(stock.getText()),
                Integer.parseInt(min.getText()),
                Integer.parseInt(max.getText()), PartInventory.getProductParts()) : new EachPart(formId, name.getText(),
                Double.parseDouble(price.getText()),
                Integer.parseInt(stock.getText()),
                Integer.parseInt(min.getText()),
                Integer.parseInt(max.getText()), inHouseOrOutsourced);
    }

    public void setModifyFormContent(Part modify) {
        this.modify = modify;
    }

    public void setIsModifyForm(boolean isModifyForm) {
        this.isModifyForm = isModifyForm;
    }

    public void setIsPartForm(boolean isPartForm) {
        this.isPartForm = isPartForm;
    }

    public void setInHouseOrOutsourced(Pair<Boolean, String> inHouseOrOutsourced) {
        this.inHouseOrOutsourced = inHouseOrOutsourced;
    }

    @FXML
    private void onExit(ActionEvent actionEvent) {
        ((Stage) (((Button) actionEvent.getSource()).getScene().getWindow())).close();
    }
}
