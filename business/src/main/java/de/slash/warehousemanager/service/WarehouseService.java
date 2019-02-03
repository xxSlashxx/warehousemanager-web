package de.slash.warehousemanager.service;

import de.slash.warehousemanager.entity.Warehouse;
import de.slash.warehousemanager.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService
{
    @Autowired
    private WarehouseRepository warehouseRepository;

    public Warehouse createWarehouse(Warehouse warehouse)
    {
        return warehouseRepository.saveAndFlush(warehouse);
    }

    public void deleteWarehouse(Warehouse warehouse)
    {
        warehouseRepository.delete(warehouse);
    }

    public List<Warehouse> findAll()
    {
        return warehouseRepository.findAll();
    }
}