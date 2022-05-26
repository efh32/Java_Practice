package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BakeriesDTO {

    private String id;
    private String name;
    private String city;
    private String state;
    private List<BakeryInventory> bakeryInventoryList = new ArrayList<>();

    public BakeriesDTO(Bakeries bakery){
        this.id = bakery.getId();
        this.name = bakery.getName();
        this.city = bakery.getCity();
        this.state = bakery.getState();
        this.bakeryInventoryList = bakery.getBakeryInventoryList();
    }
}
