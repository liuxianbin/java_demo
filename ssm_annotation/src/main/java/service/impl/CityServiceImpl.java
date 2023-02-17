package service.impl;

import dao.CityDao;
import domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CityService;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao cityDao;

    @Override
    public boolean save(City city) {
        cityDao.save(city);
        return true;
    }

    @Override
    public boolean update(City city) {
        cityDao.update(city);
        if (city.getId() == 1) {
            throw new RuntimeException("mock exception...");
        }
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        cityDao.delete(id);
        return true;
    }

    @Override
    public City getById(Integer id) {
        return cityDao.getById(id);
    }

    @Override
    public List<City> getAll() {
        return cityDao.getAll();
    }
}
