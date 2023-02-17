package service;

import domain.City;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CityService {
    boolean save(City city);

    boolean update(City city);

    boolean delete(Integer id);

    City getById(Integer id);

    List<City> getAll();
}
