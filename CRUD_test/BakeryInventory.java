package com.BakeryPackage;

import lombok.Data;
import javax.persistence.*;
import java.util.Objects;

/*
CREATE TABLE BakeryInventory (
	bakery_inventory_id varchar(45) PRIMARY KEY NOT NULL,
	dessert_name varchar(45) NOT NULL,
    dessert_id varchar(45) REFERENCES Cakes(cake_id) NOT NULL,
    price float NOT NULL,
    stock int NOT NULL,
	bakery_id varchar(45) REFERENCES Bakeries(bakery_id) NOT NULL
);
 */

@Entity
@Table(name = "BakeryInventory")
@Data
public class BakeryInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String bakeryInventoryId;

    @Column(name = "name")
    private String dessertName;

    @Column(name = "stock")
    private int stock;

    @Column(name = "price")
    private float price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dessertId")
    private String dessertId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bakeryId")
    private String bakeryId;


    public BakeryInventory() {
    }

    public BakeryInventory(String bakeryInventoryId, String dessertName, int stock, float price, String dessertId, String bakeryId){
        this.bakeryInventoryId = bakeryInventoryId;
        this.dessertName = dessertName;
        this.stock = stock;
        this.price = price;
        this.dessertId = dessertId;
        this.bakeryId = bakeryId;
    }

    public String getBakeryInventoryId() {
        return bakeryInventoryId;
    }

    public void setBakeryInventoryId(String bakeryInventoryId) {
        this.bakeryInventoryId = bakeryInventoryId;
    }

    public String getDessertName() {
        return dessertName;
    }

    public void setDessertName(String dessertName) {
        this.dessertName = dessertName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDessertId() {
        return dessertId;
    }

    public void setDessertId(String dessertId) {
        this.dessertId = dessertId;
    }

    public String getBakeryId() {
        return bakeryId;
    }

    public void setBakeryId(String bakeryId) {
        this.bakeryId = bakeryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BakeryInventory that = (BakeryInventory) o;
        return Objects.equals(bakeryInventoryId, that.bakeryInventoryId) && Objects.equals(dessertName, that.dessertName) && Objects.equals(dessertId, that.dessertId) && Objects.equals(bakeryId, that.bakeryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bakeryInventoryId, dessertName, dessertId, bakeryId);
    }
}