package repository;


//import com.example.java92022.week4.day17.domain.Employee;
import domain.Cakes;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Repository
public class CakeRepositoryImpl implements CakesRepository {

    private Map<String, Cakes> cakesMap = new HashMap<>();

    @PostConstruct
    public void init() {
        Employee employee1 = new Employee("Tom", "1", new Date(), new Date(), true);
        Employee employee2 = new Employee("Jerry", "2", new Date(), new Date(), true);
        employeeMap.put(employee1.getId(), employee1);
        employeeMap.put(employee2.getId(), employee2);

        Cakes cake1 = new Cakes();
        Cakes cake2 = new Cakes();
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
