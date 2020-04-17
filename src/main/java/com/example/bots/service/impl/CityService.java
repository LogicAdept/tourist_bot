package com.example.bots.service.impl;

import com.example.bots.entity.City;
import com.example.bots.repository.ICityRepository;
import com.example.bots.service.ICityService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CityService implements ICityService {

    ICityRepository repository;

    public CityService(ICityRepository repository) {
        this.repository = repository;
    }

    @Override
    public City getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<City> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public City save(City city) {
        return repository.save(city);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public City update(City city) {
        return repository.save(city);
    }
}

