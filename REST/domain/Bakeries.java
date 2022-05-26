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
public class Bakeries {

    private String id;
    private String name;
    private String city;
    private String state;
    private List<BakeryInventory> bakeryInventoryList = new ArrayList<>();
    private Date lastModifiedDate;
    private Date createdDate;
    private boolean active;

}
