package com.inventorymanagementsystem.hkunzler_software1_pa;

import com.inventorymanagementsystem.hkunzler_software1_pa.models.EachPart;
import com.inventorymanagementsystem.hkunzler_software1_pa.models.Part;
import com.inventorymanagementsystem.hkunzler_software1_pa.models.PartInventory;
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
        PartInventory.addPart(new EachPart(2, "Wallaby", 1, 2, 4, 5, new Pair<>(true, "test")));
        PartInventory.addPart(new EachPart(4, "Way", 1, 2, 4, 5, new Pair<>(true, "test")));
        if (partTable != null) {
            partTable.setItems(PartInventory.getParts());
        }
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
            FXMLLoader fxmlLoader = new FXMLLoader(InventoryManagementApplication.class.getResource(formType));
            Parent root = (fxmlLoader.load());
            stage.setScene(new Scene(root));
            stage.show();
            stage.setTitle(form);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onDelete(ActionEvent actionEvent) {
    }
}
