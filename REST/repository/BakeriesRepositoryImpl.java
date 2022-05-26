package repository;

import domain.Bakeries;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class BakeriesRepositoryImpl implements BakeriesRepository {
    private Map<String, Bakeries> bakeryMap = new HashMap<>();

    @PostConstruct
    public void init() {
        Bakeries bakery1 = new Bakeries("BID-09203", "Joe's Bakery", "Raleigh", "North Carolina",
                new ArrayList<>(), new Date(), new Date(), true);
        Bakeries bakery2 = new Bakeries("BID-05543", "Le Bakery", "Charleston", "South Carolina",
                new ArrayList<>(), new Date(), new Date(), true);

        bakeryMap.put(bakery1.getId(), bakery1);
        bakeryMap.put(bakery2.getId(), bakery2);

    }

    @Override
    public Bakeries getBakeriesByID(String id){
        return bakeryMap.get(id);
    }

    @Override
    public List<Bakeries> getAllBakeries(){
        return bakeryMap.values().stream().collect(Collectors.toList());
    }
}

