package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BakeryInventory {

    private String bakeryInventoryId;
    private String dessertName;
    private int stock;
    private float price;
    private String dessertId;
    private String bakeryId;
    private Date lastModifiedDate;
    private Date createdDate;
    private boolean active;
}
