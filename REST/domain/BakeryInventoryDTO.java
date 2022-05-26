package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BakeryInventoryDTO {

    private String bakeryInventoryId;
    private String dessertName;
    private int stock;
    private float price;
    private String dessertId;
    private String bakeryId;

    public BakeryInventoryDTO(BakeryInventory bakeryInventory){
        this.bakeryInventoryId = bakeryInventory.getBakeryInventoryId();
        this.dessertName = bakeryInventory.getDessertName();
        this.dessertId = bakeryInventory.getDessertId();
        this.bakeryId = bakeryInventory.getBakeryId();
        this.stock = bakeryInventory.getStock();
        this.price = bakeryInventory.getPrice();
    }
}
