package com.inventorymanagementsystem.hkunzler_software1_pa.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class uniqueIDGenerator {
    private static final AtomicInteger id = new AtomicInteger();

    public static int newId() {
        return id.getAndIncrement();
    }
}
