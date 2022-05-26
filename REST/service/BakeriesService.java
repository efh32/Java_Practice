package service;

import domain.Bakeries;
import domain.BakeriesDTO;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BakeriesService {
    BakeriesDTO getBakeriesById(String id);
    List<BakeriesDTO> getAllBakeries();
}


