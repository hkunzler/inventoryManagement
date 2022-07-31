package com.inventorymanagementsystem.hkunzler_software1_pa.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.Objects;

public class errorHandling {
    private static boolean hasErrors = false;

    public static boolean hasErrors(TextField stock, TextField min, TextField max, TextField price, TextField name) {
        final TextField[] allFields = {stock, min, max, price, name};
        for (TextField allField : allFields) {
            errorCheck(allField);
            if (hasErrors) return true;
        }
        return false;
    }

    // Labels of error fields
    public static String getFieldErrorLabel(TextField fieldLabel) {
        if (Objects.equals(fieldLabel.getText(), "name")) {
            return "Label";
        }
        return formatting.capitalizeWord(fieldLabel.getId());
    }

    public static void errorCheck(TextField fieldCheck) {

        // Check if null or empty
        if (fieldCheck == null || fieldCheck.getText().isEmpty()) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Empty Field");
            error.setContentText("Complete all fields");
            error.showAndWait();
            hasErrors = true;

            // Check if stock, max, or min fields only contain numbers
        } else if ((fieldCheck.getId().equals("stock") || fieldCheck.getId().equals("max") || fieldCheck.getId().equals("min")) && !fieldCheck.getText().matches("\\d*")) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Number Field");
            error.setContentText(getFieldErrorLabel(fieldCheck) + " value must be an integer");
            error.showAndWait();
            hasErrors = true;
        } else {
            hasErrors = false;
        }
    }

    // ALERTS
    public static void selectItemAlert(String itemAction) {
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setTitle(formatting.capitalizeWord(itemAction));
        error.setContentText("Must select item to " + itemAction);
        error.showAndWait();
    }

    public static void exitAlert() {
        Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION);
        exitAlert.setTitle("Exit Warning");
        exitAlert.setContentText("Are you sure you want to exit?");
        exitAlert.showAndWait();
    }
}
