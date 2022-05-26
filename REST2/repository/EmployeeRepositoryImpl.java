package repository;


import domain.Employees;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private Map<Integer, List<Employees>> ageMap = new HashMap<>();

    @Override
    public void putEmployees(Integer age, Employees emp){
        if(ageMap.containsKey(age)){

        }else{
            List<Employees> addList = new ArrayList<>();
            addList.add(emp);
            ageMap.put(age, emp);
        }

    }

    @Override
    public void deleteEmployees(Integer age, Employees emp){
        ageMap.remove(age, emp);
    }

    @Override
    public List<Employees> getEmployeesOlderThan(Integer age){
        List<Employees> ret = new ArrayList<>();

        Iterator<Integer> it = ageMap.keySet().iterator();

        while(it.hasNext()){
            int k = it.next();
            if(k > age){
                ret.add(ageMap.get(k));
            }
        }

        return ret;
    }

    @Override
    public List<List<Employees>> getEmployeesByAgeGroup(){
        List<List<Employees>> ret = new ArrayList<>();

        Iterator<Integer> it = ageMap.keySet().iterator();

        while(it.hasNext()){
            int k = it.next();
            List<Employees> addList;

            ageMap.get(k);

        }

        return ret;
    };

}
