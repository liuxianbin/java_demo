package controller;

import domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.CityService;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @PostMapping
    public boolean save(@RequestBody City city) {
        return cityService.save(city);
    }

    @PutMapping
    public boolean update(@RequestBody City city) {
        return cityService.update(city);
    }

    @GetMapping("/{id}")
    public City getById(@PathVariable Integer id) {
        return cityService.getById(id);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return cityService.delete(id);
    }

    @GetMapping
    public List<City> getAll() {
        return cityService.getAll();
    }

}
