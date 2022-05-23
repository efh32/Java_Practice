package com.BakeryPackage;

import lombok.Data;
import javax.persistence.*;
import java.util.*;

/*
CREATE TABLE Bakeries (
	bakery_id varchar(45) PRIMARY KEY NOT NULL,
	bakery_name varchar(45) NOT NULL,
	city varchar(45) NOT NULL,
	state varchar(45) NOT NULL
);
 */

@Entity
@Table(name = "Bakeries")
@Data
public class Bakeries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @OneToMany(mappedBy = "bakeryId", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    private List<BakeryInventory> bakeryInventoryList = new ArrayList<>();

    public Bakeries() {
    }

    public Bakeries(String id, String name, String city, String state){
        this.id = id;
        this.name = name;
        this.city = city;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<BakeryInventory> getBakeryInventoryList() {
        return bakeryInventoryList;
    }

    public void setBakeryInventoryList(List<BakeryInventory> bakeryInventoryList) {
        this.bakeryInventoryList = bakeryInventoryList;
    }

    @Override
    public String toString() {
        return "Bakeries{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bakeries bakeries = (Bakeries) o;
        return Objects.equals(id, bakeries.id) && Objects.equals(name, bakeries.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
