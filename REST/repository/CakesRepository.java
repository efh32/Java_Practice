package repository;

import domain.Cakes;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CakesRepository {
    Cakes getCakesByID(String id);
    List<Cakes> getAllCakes();
}
