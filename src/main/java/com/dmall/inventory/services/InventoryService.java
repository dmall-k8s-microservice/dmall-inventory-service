package com.dmall.inventory.services;

import com.dmall.inventory.model.Inventory;

import java.util.List;

public interface InventoryService {
    List<Inventory> getInventories();

    Inventory getInventoriesById(String id);
}
