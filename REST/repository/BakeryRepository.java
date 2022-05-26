package repository;

import domain.BakeryInventory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CakesRepository {
    Cakes getCakesByID(String id);
    List<Cakes> getAllCakes();
}

@Repository
public interface BakeryRepository {

}
