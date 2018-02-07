package com.dmall.inventory.services;

import com.dmall.inventory.model.Inventory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class InventoryServiceImpl implements InventoryService {

    private List<Inventory> inventories = Arrays.asList(
            new Inventory("p001", "坚果手机pro3", 10),
            new Inventory("p002", "坚果手机pro", 10),
            new Inventory("p004", "坚果手机", 8),
            new Inventory("p003", "Oppo R12", 10));

    @Override
    public List<Inventory> getInventories() {
        return inventories;
    }

    @Override
    public Inventory getInventoriesById(String id) {
        Inventory result = null;
        for(Inventory inventory : inventories) {
            if(inventory.getInventoryId().equals(id)) {
                result = inventory;
                break;
            }
        }

        return  result;
    }
}
