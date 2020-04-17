package com.example.bots.web;

import com.example.bots.service.ICityService;
import com.example.bots.web.dto.CityDto;
import com.example.bots.web.dto.CreateUpdateCityDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor
public class CityRestApi implements ICityRestApi {

    final ICityService service;

    @Override
    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public CityDto getByName(@PathVariable String name) {
        return CityDto.fromModel(service.getByName(name));
    }

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CityDto> getAll() {
        return service.getAll().stream().map(CityDto::fromModel).collect(Collectors.toList());

    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @Override
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CityDto update(@PathVariable Long id, @RequestBody @Validated CreateUpdateCityDto cityDto) {
        return CityDto.fromModel(service.update(cityDto.toModel(id)));
    }


    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CityDto create(@RequestBody @Validated CreateUpdateCityDto cityDto) {
        return CityDto.fromModel(service.save(cityDto.toModel()));
    }


}
