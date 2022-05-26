package service;

import domain.BakeryInventory;
import domain.BakeryInventoryDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import repository.BakeryInventoryRepository;

import java.util.List;
import java.util.stream.Collectors;

public class BakeryInventoryServiceImpl implements BakeryInventoryService{
    private final Log logger = LogFactory.getLog(BakeryInventoryServiceImpl.class);
    private final BakeryInventoryRepository bakeryInventoryRepository;
    private final RestTemplate restTemplate;


    @Autowired
    public BakeryInventoryServiceImpl(BakeryInventoryRepository bakeryInventoryRepository, RestTemplate restTemplate) {
        this.bakeryInventoryRepository = bakeryInventoryRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public BakeryInventoryDTO getBakeryInventoryById(String id) {

        BakeryInventory bakeryInventory = bakeryInventoryRepository.getBakeryInventoryById(id);

        if(bakeryInventory == null) {
            throw new RuntimeException(id + ": bakery inventory is null");
        }
        return new BakeryInventoryDTO(bakeryInventory);
    }

    @Override
    public List<BakeryInventoryDTO> getAllBakeryInventory() {
        return bakeryInventoryRepository
                .getAllBakeryInventory()
                .stream()
                .map(e -> new BakeryInventoryDTO(e))
                .collect(Collectors.toList());
    }
}
