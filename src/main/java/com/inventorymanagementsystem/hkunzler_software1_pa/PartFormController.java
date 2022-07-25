package com.inventorymanagementsystem.hkunzler_software1_pa;

import com.inventorymanagementsystem.hkunzler_software1_pa.models.EachPart;
import com.inventorymanagementsystem.hkunzler_software1_pa.models.Part;
import com.inventorymanagementsystem.hkunzler_software1_pa.models.PartInventory;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
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

    @FXML
    public InventoryFormController partFormController;
    Pair<Boolean, String> inHouseOrOutsourced;

    public void setIsInHouse(Boolean isInHouse) {
        if (isInHouse) {
            inHouse.setSelected(true);
            outsourced.setSelected(false);
            sourceLabel.setText("Machine ID");
        } else {
            inHouse.setSelected(false);
            outsourced.setSelected(true);
            sourceLabel.setText("Company ID");

        }
        partFormController.setInHouseOrOutsourced(new Pair<>(inHouse.isSelected(), partType.getText()));
    }

    public void getInHouseOrOutsourced(Part part) {
        if (part instanceof EachPart eachPart) {
            setIsInHouse(eachPart.getInHouseOrOutsourced().getKey());
            partType.setText(eachPart.getInHouseOrOutsourced().getValue());
        }
    }

    @FXML
    public void setHeader(String partFormTitle) {
        this.partFormTitle.setText(partFormTitle + " Part");
    }

    public void initialize() {
        setIsInHouse(true);

        Platform.runLater(() -> {

            if (Objects.equals(partFormTitle.getText(), "Modify Part")) {
                getInHouseOrOutsourced(PartInventory.getModifiedParts().get(0));

            }
        });

    }


    @FXML
    public void onInHouseSelect() {
        setIsInHouse(true);
    }

    @FXML
    public void onOutsourceSelect() {
        setIsInHouse(false);

    }


    public void onPartType(KeyEvent actionEvent) {
        Platform.runLater(() -> partFormController.setInHouseOrOutsourced(new Pair<>(inHouse.isSelected(), partType.getText())));

    }
}
