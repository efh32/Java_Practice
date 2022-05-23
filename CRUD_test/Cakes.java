package com.BakeryPackage;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
CREATE TABLE Cakes (
	cake_id varchar(45) Primary Key NOT NULL,
  	cake_name varchar(45) NOT NULL,
  	description varchar(90) NOT NULL
);
 */

@Entity
@Table(name = "Cakes")
@Data
public class Cakes{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "dessertId", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    private List<BakeryInventory> cakeInventoryList = new ArrayList<>();

    public Cakes() {
    }

    public Cakes(String id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<BakeryInventory> getCakeInventoryList() {
        return cakeInventoryList;
    }

    public void setCakeInventoryList(List<BakeryInventory> cakeInventoryList) {
        this.cakeInventoryList = cakeInventoryList;
    }


}
