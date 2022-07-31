package com.inventorymanagementsystem.hkunzler_software1_pa.utils;

import com.inventorymanagementsystem.hkunzler_software1_pa.models.Part;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class searchResults {

    // Checks for search results
    // Returns entire list if no search
    // Error message searched and no result
    public static ObservableList<Part> getTableItems(ObservableList<Part> tableItems, TextField searchField, TableView<Part> partTable) {
        FilteredList<Part> searchResult = new FilteredList<>(tableItems, item -> true);
        searchField.textProperty().addListener(obs -> {
            String search = searchField.getText();
            if (search == null || search.length() == 0) searchResult.setPredicate(item -> true);
            else {
                searchResult.setPredicate(item -> item.getName().contains(search) || Integer.toString(item.getId()).contains(search));
                if (searchResult.isEmpty()) {
                    final Label placeholderLabel = new Label("No matching results");
                    placeholderLabel.setTextFill(Color.RED);
                    partTable.setPlaceholder(placeholderLabel);
                }
            }
        });
        return searchResult;
    }
}