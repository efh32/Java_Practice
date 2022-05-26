package repository;

import domain.BakeryInventory;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class BakeryInventoryRepositoryImpl implements BakeryInventoryRepository{

    private Map<String, BakeryInventory> bakeryInventoryMap = new HashMap<>();


    @PostConstruct
    public void init() {
        BakeryInventory bakeryInventory1 = new BakeryInventory("BIN-00001", "Raspberry CheeseCake",
                12, (float) 29.99, "CID-00020", "BID-09203", new Date(), new Date(), true);

        BakeryInventory bakeryInventory2 = new BakeryInventory("BIN-00002", "Ice Cream cake",
                5, (float) 18.99, "CID-00022", "BID-09203", new Date(), new Date(), true);

        bakeryInventoryMap.put(bakeryInventory1.getBakeryInventoryId(), bakeryInventory1);
        bakeryInventoryMap.put(bakeryInventory2.getBakeryInventoryId(), bakeryInventory2);
    }

    @Override
    public BakeryInventory getBakeryInventoryById(String id) {
        return bakeryInventoryMap.get(id);
    }

    @Override
    public List<BakeryInventory> getAllBakeryInventory() {
        return bakeryInventoryMap.values().stream().collect(Collectors.toList());
    }

}


