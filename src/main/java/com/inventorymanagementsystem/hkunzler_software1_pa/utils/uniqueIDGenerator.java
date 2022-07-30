package com.inventorymanagementsystem.hkunzler_software1_pa.utils;

import java.util.concurrent.atomic.AtomicInteger;

// Unique ID generator
public class uniqueIDGenerator {

    // Starting number
    private static final AtomicInteger id = new AtomicInteger();

    // newId() gets last number and adds one
    public static int newId() {
        return id.getAndIncrement();
    }
}
