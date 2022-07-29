package com.inventorymanagementsystem.hkunzler_software1_pa;

import com.inventorymanagementsystem.hkunzler_software1_pa.models.EachPart;
import com.inventorymanagementsystem.hkunzler_software1_pa.models.Part;
import com.inventorymanagementsystem.hkunzler_software1_pa.models.PartInventory;
import com.inventorymanagementsystem.hkunzler_software1_pa.models.Product;
import com.inventorymanagementsystem.hkunzler_software1_pa.utils.uniqueIDGenerator;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.net.URL;
import java.util.Objects;
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

    private Pair<Boolean, String> inHouseOrOutsourced;
    @FXML
    private TextField id;

    private String addEditItem;
    private Part modify;
    private String partInventoryForm;
    private String tableTitle;
    private ObservableList<Integer> productParts;

    public void setAddEditItem(String addEditItem) {
        this.addEditItem = addEditItem;
    }

    public void setInHouseOrOutsourced(Pair<Boolean, String> inHouseOrOutsourced) {
        this.inHouseOrOutsourced = inHouseOrOutsourced;
    }

    public void onCancelPart(ActionEvent actionEvent) {
        ((Stage) (((Button) actionEvent.getSource()).getScene().getWindow())).close();
    }

    private void modifiedPart(Part modify) {
        this.modify = modify;
    }

    public void setTableTitle(Label tableTitle) {
        this.tableTitle = tableTitle.getText();
    }

    public void setProductParts(ObservableList<Integer> productParts) {
        this.productParts = productParts;
    }

    public void onSavePart(ActionEvent actionEvent) {
        int newId = uniqueIDGenerator.newId();
        if (Objects.equals(tableTitle, "Parts")) {
            if ((Objects.equals(partInventoryForm, "Modify"))) {
                PartInventory.getParts().set(PartInventory.getParts().indexOf(modify),
                        new EachPart(Integer.parseInt(id.getText()), name.getText(),
                                Double.parseDouble(price.getText()),
                                Integer.parseInt(stock.getText()),
                                Integer.parseInt(min.getText()),
                                Integer.parseInt(max.getText()), inHouseOrOutsourced));
            } else if (Objects.equals(partInventoryForm, "Add")) {
                PartInventory.addPart(new EachPart(newId,
                        name.getText(),
                        Double.parseDouble(price.getText()),
                        Integer.parseInt(stock.getText()),
                        Integer.parseInt(min.getText()),
                        Integer.parseInt(max.getText()), inHouseOrOutsourced));
            }
        } else if (Objects.equals(tableTitle, "Products")) {

            if ((Objects.equals(partInventoryForm, "Modify"))) {
                PartInventory.getProducts().set(PartInventory.getProducts().indexOf(modify),
                        new Product(Integer.parseInt(id.getText()), name.getText(),
                                Double.parseDouble(price.getText()),
                                Integer.parseInt(stock.getText()),
                                Integer.parseInt(min.getText()),
                                Integer.parseInt(max.getText()), productParts));
            } else if (Objects.equals(partInventoryForm, "Add")) {
                PartInventory.addProduct(new Product(newId,
                        name.getText(),
                        Double.parseDouble(price.getText()),
                        Integer.parseInt(stock.getText()),
                        Integer.parseInt(min.getText()),
                        Integer.parseInt(max.getText()), productParts));
            }
        }
        onCancelPart(actionEvent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            partInventoryForm = (addEditItem);
            if ((PartInventory.getModifiedParts()).toArray().length >= 1 && Objects.equals(tableTitle, "Parts")) {
                modifiedPart((PartInventory.getModifiedParts()).get(0));
            } else if ((PartInventory.getModifiedProducts()).toArray().length >= 1 && Objects.equals(tableTitle, "Products")) {
                modifiedPart((PartInventory.getModifiedProducts()).get(0));
            }
            if ((Objects.equals(partInventoryForm, "Modify")) && (modify != null)) {
                id.setText(Integer.toString(modify.getId()));
                name.setText(modify.getName());
                price.setText(Double.toString(modify.getPrice()));
                stock.setText(Integer.toString(modify.getStock()));
                min.setText(Integer.toString(modify.getMin()));
                max.setText(Integer.toString(modify.getMax()));
            }
            Platform.runLater(() -> {
                PartInventory.getModifiedParts().clear();
                PartInventory.getModifiedProducts().clear();
            });
        });
    }
}
