package service;

import domain.BakeryInventory;
import domain.BakeryInventoryDTO;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BakeryInventoryService {

    BakeryInventoryDTO getBakeryInventoryById(String id);
    List<BakeryInventoryDTO> getAllBakeryInventory();

}
