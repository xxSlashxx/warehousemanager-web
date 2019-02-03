package de.slash.warehousemanager.entity;

import javax.persistence.*;

@Entity
@Table(name = "WAREHOUSE")
public class Warehouse
{
    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    public Warehouse()
    {
    }

    public Warehouse(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return name;
    }
}