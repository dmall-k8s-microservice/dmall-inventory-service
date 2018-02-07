package com.dmall.inventory.apis;

import com.dmall.inventory.model.Inventory;
import com.dmall.inventory.services.InventoryService;
import com.dmall.inventory.services.InventoryServiceImpl;
import org.junit.Test;

import java.text.ParseException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class InventoryControllerTest {
    @Test
    public void getInventoryById() throws ParseException {
        InventoryService service = new InventoryServiceImpl();

        Inventory result = service.getInventoriesById("p003");
        assertThat(result.getName(), is("Oppo R12"));
    }
}