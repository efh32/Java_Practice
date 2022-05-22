package com.BakeryPackage;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "com.BakeryPackage.CakeList")
@Data
public class PieList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "primaryIngredient")
    private String primaryIngredient;


    public PieList() {
    }

    public PieList(String id, String name, String primaryIngredient){
        this.id = id;
        this.name = name;
        this.primaryIngredient = primaryIngredient;
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

    public String getPrimaryIngredient() {
        return primaryIngredient;
    }

    public void setDescription(String primaryIngredient) {
        this.primaryIngredient = primaryIngredient;
    }


}


