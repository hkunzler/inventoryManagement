package com.inventorymanagementsystem.hkunzler_software1_pa;

import com.inventorymanagementsystem.hkunzler_software1_pa.models.EachPart;
import com.inventorymanagementsystem.hkunzler_software1_pa.models.Part;
import com.inventorymanagementsystem.hkunzler_software1_pa.models.PartInventory;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.util.Pair;

import java.util.Objects;

public class PartFormController {
    @FXML
    public RadioButton inHouse;
    @FXML
    public RadioButton outsourced;
    @FXML
    public TextField partType;
    @FXML
    public Label partFormTitle;
    @FXML
    public Label sourceLabel;

    // Nested fxml
    @FXML
    InventoryFormController partFormController;

    // Radio button toggle
    public void setIsInHouse(Boolean isInHouse) {

        // isInHouse selected
        if (isInHouse) {
            inHouse.setSelected(true);
            outsourced.setSelected(false);
            sourceLabel.setText("Machine ID");

            // outsourced selected
        } else {
            inHouse.setSelected(false);
            outsourced.setSelected(true);
            sourceLabel.setText("Company ID");

        }

        // Pair value of selected option and text input
        partFormController.setInHouseOrOutsourced(new Pair<>(inHouse.isSelected(), partType.getText()));
    }

    public void onInHouseSelect() {
        setIsInHouse(true);
    }

    public void onOutsourceSelect() {
        setIsInHouse(false);
    }

    // Get inHouse/outsourced value
    public void getInHouseOrOutsourced(Part part) {

        // Check if value is found in eachpart
        if (part instanceof EachPart eachPart) {

            // If found -> get associated values
            setIsInHouse(eachPart.getInHouseOrOutsourced().getKey());

            // then set textfield value
            partType.setText(eachPart.getInHouseOrOutsourced().getValue());
        }
    }

    public void initialize() {

        // Default select to inHouse
        setIsInHouse(true);

        Platform.runLater(() -> {

            // If modify form and modify list has value
            if ((Objects.equals(partFormTitle.getText(), "Modify Part") && !PartInventory.getModifiedParts().isEmpty())) {

                // Set to stored values
                getInHouseOrOutsourced(PartInventory.getModifiedParts().get(0));
            }

            // Clear modify list
            PartInventory.getModifiedParts().clear();
        });
    }

    // Set modal header
    public void setHeader(String partFormTitle) {
        this.partFormTitle.setText(partFormTitle + " Part");
    }

    // Connected to textfield
    public void onPartType() {
        // Gets value as typed
        Platform.runLater(() -> partFormController.setInHouseOrOutsourced(new Pair<>(inHouse.isSelected(), partType.getText())));
    }
}
