package com.dmall.inventory.apis;

import org.junit.Test;

import java.text.ParseException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class InventoryControllerTest {

    @Test
    public void getInventories() throws ParseException {
        InventoryController inventoryController = new InventoryController();

        assertThat(inventoryController.getInventories().size(), is(4));
    }
}