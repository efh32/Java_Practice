package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CakesDTO {
    private String id;
    private String name;
    private String description;
    private List<BakeryInventory> cakeInventoryList = new ArrayList<>();

    public CakesDTO(Cakes cake){
        this.id = cake.getId();
        this.name = cake.getName();
        this.description = cake.getDescription();
        this.cakeInventoryList = cake.getCakeInventoryList();
    }

}
