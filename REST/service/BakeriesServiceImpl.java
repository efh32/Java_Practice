package service;
import domain.Bakeries;
import domain.BakeriesDTO;

import repository.BakeriesRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import repository.CakesRepository;


import java.util.List;
import java.util.stream.Collectors;

public class BakeriesServiceImpl implements BakeriesService {
    private final Log logger = LogFactory.getLog(BakeriesServiceImpl.class);
    private final BakeriesRepository bakeriesRepository;
    private final RestTemplate restTemplate;



    @Autowired
    public BakeriesServiceImpl(BakeriesRepository bakeriesRepository, RestTemplate restTemplate) {
        this.bakeriesRepository = bakeriesRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public BakeriesDTO getBakeriesById(String id) {
        Bakeries bakery = bakeriesRepository.getBakeriesByID(id);
        if(bakery == null) {
            throw new RuntimeException(id + ": cake is null");
        }
        return new BakeriesDTO(bakery);
    }

    @Override
    public List<BakeriesDTO> getAllBakeries() {
        return bakeriesRepository
                .getAllBakeries()
                .stream()
                .map(e -> new BakeriesDTO(e))
                .collect(Collectors.toList());
    }

}
