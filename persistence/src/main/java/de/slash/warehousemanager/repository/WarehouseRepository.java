package de.slash.warehousemanager.repository;

import de.slash.warehousemanager.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends  JpaRepository<Warehouse, Integer>
{
}