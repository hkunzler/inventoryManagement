package com.inventorymanagementsystem.hkunzler_software1_pa;

import com.inventorymanagementsystem.hkunzler_software1_pa.models.EachPart;
import com.inventorymanagementsystem.hkunzler_software1_pa.models.Part;
import com.inventorymanagementsystem.hkunzler_software1_pa.models.PartInventory;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class InventoryTableController implements Initializable {

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
    @FXML
    private Button onAdd;
    @FXML
    private Button onModify;
    private String formType;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            if (partTable != null && Objects.equals(tableTitle.getText(), "Parts")) {
                partTable.setItems(PartInventory.getParts());
            }
        });
    }

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
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formType));
            Parent root = (fxmlLoader.load());
            if (Objects.equals(tableTitle.getText(), "Products")) {
                ProductFormController controller = fxmlLoader.getController();
                controller.setHeader(form);
            } else {
                PartFormController controller = fxmlLoader.getController();
                controller.setHeader(form);
                 if(Objects.equals(form, "Modify")) onModify();

                controller.partFormController.setAddEditItem(form);
                controller.partFormController.setTableTitle(tableTitle);
            }
            stage.setScene(new Scene(root));
            stage.show();
            stage.setTitle(form);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void onModify() {
        Part modifyItem = partTable.getSelectionModel().getSelectedItem();
        PartInventory.addModifiedPart(modifyItem, PartInventory.getModifiedParts());
    }
    public void onDelete() {
        Part deleteItem = partTable.getSelectionModel().getSelectedItem();
        PartInventory.deletePart(deleteItem, PartInventory.getParts());
    }
}
