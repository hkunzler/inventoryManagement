package com.inventorymanagementsystem.hkunzler_software1_pa.models;

import javafx.util.Pair;

public class EachPart extends Part {
    private Pair<Boolean, String> inHouseOrOutsourced;

    public EachPart(int id, String name, double price, int stock, int min, int max, Pair<Boolean, String> inHouseOrOutsourced) {
        super(id, name, price, stock, min, max);
        this.inHouseOrOutsourced = inHouseOrOutsourced;

    }

    public Pair<Boolean, String> getInHouseOrOutsourced() {
        return inHouseOrOutsourced;
    }

    public void setInHouseOrOutsourced(Pair<Boolean, String> inHouseOrOutsourced) {
        this.inHouseOrOutsourced = inHouseOrOutsourced;
    }
}
