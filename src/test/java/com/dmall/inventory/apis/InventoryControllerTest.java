package com.dmall.inventory.apis;

import com.dmall.inventory.services.InventoryService;
import com.dmall.inventory.services.InventoryServiceImpl;
import org.junit.Test;

import java.text.ParseException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class InventoryControllerTest {

    @Test
    public void getInventories() throws ParseException {
        InventoryService service = new InventoryServiceImpl();
        assertThat(service.getInventories().size(), is(4));
    }
}