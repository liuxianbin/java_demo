package service;

import domain.City;

import java.util.List;

public interface CityService {
    boolean save(City city);

    boolean update(City city);

    boolean delete(Integer id);

    City getById(Integer id);

    List<City> getAll();
}
