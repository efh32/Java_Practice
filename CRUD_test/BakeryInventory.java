package com.BakeryPackage;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "com.BakeryPackage.CakeList")
@Data
public class BakeryInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "stock")
    private int stock;

    @Column(name = "price")
    private float price;


    public BakeryInventory() {
    }

    public BakeryInventory(String id, String name, int stock, float price){
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
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

    public void setStock(int stock){ this.stock = stock; }

    public int getStock() {
        return this.stock;
    }

    public void setPrice(float price){ this.price = price; }

    public float getPrice() {
        return this.price;
    }


}