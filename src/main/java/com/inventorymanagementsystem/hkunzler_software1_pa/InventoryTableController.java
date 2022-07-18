package com.inventorymanagementsystem.hkunzler_software1_pa;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

public class InventoryTableController {
    @FXML
    private Label tableTitle;
    @FXML
    public TableColumn<String, Integer> itemStock;
    @FXML
    public TableColumn<String, Integer> itemPrice;

    @FXML
    private TableColumn<String, Integer> itemID;
    @FXML
    private TableColumn<String, Integer> itemName;
    @FXML
    private Button onAdd;
    @FXML
    private Button onModify;
    private String formType;
    private ModuleLayer.Controller formController;

    public void setTableTitle(String tableTitle) {
        this.tableTitle.setText(tableTitle);
    }

    public void setItemID(String itemID) {
        this.itemID.setText(itemID);
    }

    public void setItemName(String itemName) {
        this.itemName.setText(itemName);
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public void onOpenForm(ActionEvent actionEvent) {
        String form = ((Button) actionEvent.getSource()).getText();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formType));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            if (formType.contains("part")) {
                PartFormController partController = fxmlLoader.getController();
                partController.setPartFormTitle(form.concat(" Part"));
            } else {
                ProductFormController productController = fxmlLoader.getController();
                productController.setProductFormTitle(form.concat(" Product"));
            }
            stage.setTitle(form);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onDelete(ActionEvent actionEvent) {
    }

}
