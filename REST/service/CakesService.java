package service;

import domain.Cakes;
import domain.CakesDTO;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CakesService {
    CakesDTO getCakesById(String id);
    List<CakesDTO> getAllCakes();
}
