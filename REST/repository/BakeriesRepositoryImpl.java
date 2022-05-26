package repository;

import domain.Bakeries;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class BakeriesRepositoryImpl implements BakeriesRepository {
    private Map<String, Bakeries> bakeryMap = new HashMap<>();

    @Override
    public Bakeries getBakeriesByID(String id){
        return bakeryMap.get(id);
    }

    @Override
    public List<Bakeries> getAllBakeries(){
        return bakeryMap.values().stream().collect(Collectors.toList());
    }
}

