package repository;

import domain.Cakes;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;


@Repository
public class CakeRepositoryImpl implements CakesRepository {

    private Map<String, Cakes> cakesMap = new HashMap<>();

    @PostConstruct
    public void init() {
        Cakes cake1 = new Cakes("CID-00020", "Raspberry CheeseCake", "Made with cream cheese and raspberries",
                new ArrayList<>(), new Date(), new Date(), true);

        Cakes cake2 = new Cakes("CID-00022", "Ice Cream cake", "Cake made with ice cream",
                new ArrayList<>(), new Date(), new Date(), true);

        cakesMap.put(cake1.getId(), cake1);
        cakesMap.put(cake2.getId(), cake2);
    }

    @Override
    public Cakes getCakesByID(String id){
        return cakesMap.get(id);
    }

    @Override
    public List<Cakes> getAllCakes(){
        return cakesMap.values().stream().collect(Collectors.toList());
    }
}
