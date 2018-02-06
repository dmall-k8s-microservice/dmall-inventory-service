package com.dmall.inventory.apis;

import com.dmall.inventory.model.Inventory;
import com.dmall.inventory.services.InventoryService;
import com.dmall.inventory.services.InventoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/inventories")
public class InventoryController {

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    private List<Inventory> inventories = null;

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public List<Inventory> getInventories() {

        return inventoryService.getInventories();
    }
}
