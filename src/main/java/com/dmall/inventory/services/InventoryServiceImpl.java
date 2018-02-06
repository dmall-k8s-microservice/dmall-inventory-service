package com.dmall.inventory.services;

import com.dmall.inventory.model.Inventory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class InventoryServiceImpl implements InventoryService {

    @Override
    public List<Inventory> getInventories() {
        List<Inventory> inventories = Arrays.asList(
                new Inventory("p001", "坚果手机pro2", 10),
                new Inventory("p002", "坚果手机pro", 10),
                new Inventory("p004", "坚果手机", 8),
                new Inventory("p003", "Oppo R11", 10));

        return inventories;
    }
}
