package service;


import domain.Cakes;
import domain.CakesDTO;
import repository.CakesRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CakesServiceImpl implements CakesService{
    private final Log logger = LogFactory.getLog(CakesServiceImpl.class);
    private final CakesRepository cakesRepository;
    private final RestTemplate restTemplate;


    @Autowired
    public CakesServiceImpl(CakesRepository cakesRepository, RestTemplate restTemplate) {
        this.cakesRepository = cakesRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public CakesDTO getCakesById(String id) {
        Cakes cake = cakesRepository.getCakesByID(id);
        if(cake == null) {
            throw new RuntimeException(id + ": cake is null");
        }
        return new CakesDTO(cake);
    }

    @Override
    public List<CakesDTO> getAllCakes() {
        return cakesRepository
                .getAllCakes()
                .stream()
                .map(e -> new CakesDTO(e))
                .collect(Collectors.toList());
    }
}
