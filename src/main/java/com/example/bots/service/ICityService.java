package com.example.bots.service;

import com.example.bots.entity.City;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public interface ICityService {

    City getByName(String name);

    City save(City city);

    void deleteById(Long id);

    List<City> getAll();

    City
    update(City city);
}
