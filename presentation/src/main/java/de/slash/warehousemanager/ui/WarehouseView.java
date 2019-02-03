package de.slash.warehousemanager.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import de.slash.warehousemanager.entity.Warehouse;
import de.slash.warehousemanager.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


@Theme("valo")
@SpringUI(path = "")
public class WarehouseView extends UI
{
    @Autowired
    private WarehouseService warehouseService;

    private Grid<Warehouse> grid;

    @Override
    protected void init(VaadinRequest vaadinRequest)
    {
        initializeVariables();
        addComponents();
    }

    private void initializeVariables()
    {
        grid = new Grid<>();
        grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        grid.setItems(warehouseService.findAll());
        grid.addColumn(Warehouse::getId).setCaption("ID");
        grid.addColumn(Warehouse::getName).setCaption("Name");
        grid.addColumn(Warehouse::getDescription).setCaption("Description");
    }

    private void addComponents()
    {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(grid);
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addComponent(new Button("Add", e -> addWarehouse()));
        horizontalLayout.addComponent(new Button("Delete", e -> deleteWarehouse()));
        horizontalLayout.addComponent(new Button("Refresh", e -> refreshView()));
        verticalLayout.addComponent(horizontalLayout);
        setContent(verticalLayout);
    }

    private void addWarehouse()
    {
        Warehouse warehouse = new Warehouse("warehouse", "description");
        warehouseService.createWarehouse(warehouse);
        refreshView();
    }

    private void deleteWarehouse()
    {
        Optional<Warehouse> selectedWarehouse = grid.getSelectionModel().getFirstSelectedItem();

        if (selectedWarehouse.isPresent())
        {
            warehouseService.deleteWarehouse(selectedWarehouse.get());
            refreshView();
        }
    }

    private void refreshView()
    {
        grid.setItems(warehouseService.findAll());
    }
}