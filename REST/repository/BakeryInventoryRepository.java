package repository;

import domain.BakeryInventory;
import org.springframework.stereotype.Repository;


import java.util.List;


import java.util.List;

@Repository
public interface BakeryInventoryRepository {

    BakeryInventory getBakeryInventoryById(String id);
    List<BakeryInventory> getAllBakeryInventory();

}

