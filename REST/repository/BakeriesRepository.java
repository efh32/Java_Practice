package repository;

import domain.Bakeries;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BakeriesRepository {

    Bakeries getBakeriesByID(String id);
    List<Bakeries> getAllBakeries();
}
