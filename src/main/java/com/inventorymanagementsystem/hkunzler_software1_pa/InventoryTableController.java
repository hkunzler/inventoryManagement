package com.inventorymanagementsystem.hkunzler_software1_pa;

import com.inventorymanagementsystem.hkunzler_software1_pa.models.Part;
import com.inventorymanagementsystem.hkunzler_software1_pa.models.PartInventory;
import com.inventorymanagementsystem.hkunzler_software1_pa.models.Product;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

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
            if (partTable != null && Objects.equals(tableTitle.getText(), "Products")) {
                partTable.setItems(PartInventory.getProducts());
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
        if(Objects.equals(partTable.getSelectionModel().getSelectedItem(), null) && Objects.equals(form, "Modify")){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Modify");
            error.setContentText("Must select item to modify");
            error.showAndWait();
        }else try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formType));
            Parent root = (fxmlLoader.load());
            if (Objects.equals(tableTitle.getText(), "Products")) {
                ProductFormController controller = fxmlLoader.getController();
                if ( Objects.equals(form, "Modify")) {
                    onModify();
                    Part temp = PartInventory.getModifiedProducts().get(0);
                    if (temp instanceof Product product) {
                        for (int i = 0; i < PartInventory.getParts().toArray().length; i++) {
                            controller.addedPartsController.partTable.getItems().add(PartInventory.getParts().get(i));
                        }
                    }
                }
                controller.setHeader(form);

                PartInventory.getProductParts().clear();
                controller.addedPartsController.partTable.setItems(PartInventory.getProductParts());

                controller.partsTableController.partTable.setItems(PartInventory.getParts());
                controller.addedPartsController.addProductPartButton.setText("Remove Associate Part");

                controller.productFormController.setAddEditItem(form);
                controller.productFormController.setTableTitle(tableTitle);

            } else {
                PartFormController controller = fxmlLoader.getController();
                controller.setHeader(form);
                if(Objects.equals(partTable.getSelectionModel().getSelectedItem(), null) && Objects.equals(form, "Modify")){
                    Alert error = new Alert(Alert.AlertType.ERROR);
                    error.setTitle("Modify Part");
                    error.setContentText("Must select part to modify");
                    error.showAndWait();
                    onCancelPart(actionEvent);
                }
                else if (partTable.getSelectionModel().getSelectedItem() != null && Objects.equals(form, "Modify")) {
                    onModify();
                }
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

    public void onAddProductPart() {
        Part productPart = partTable.getSelectionModel().getSelectedItem();
        PartInventory.addProductPart(productPart);
    }

    public void onModify() {
        Part modifyItem = partTable.getSelectionModel().getSelectedItem();
        if (Objects.equals(tableTitle.getText(), "Parts")) PartInventory.addModifiedPart(modifyItem);
        else if (Objects.equals(tableTitle.getText(), "Products")) PartInventory.addModifiedProducts(modifyItem);

    }

    public void onDelete() {
        Part deleteItem = partTable.getSelectionModel().getSelectedItem();
        if(Objects.equals(deleteItem, null)){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Delete");
            error.setContentText("Must select item to delete");
            error.showAndWait();
        }else if (Objects.equals(tableTitle.getText(), "Parts")) PartInventory.deletePart(deleteItem);
        else if (Objects.equals(tableTitle.getText(), "Products")) PartInventory.deleteProduct(deleteItem);
    }
    public void onCancelPart(ActionEvent actionEvent) {
        ((Stage) (((Button) actionEvent.getSource()).getScene().getWindow())).close();
    }
}
