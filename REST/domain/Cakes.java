package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cakes {
    private String id;
    private String name;
    private String description;
    private List<BakeryInventory> cakeInventoryList = new ArrayList<>();
    private Date lastModifiedDate;
    private Date createdDate;
    private boolean active;

}
