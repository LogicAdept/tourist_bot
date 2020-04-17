package com.example.bots.web.dto;

import com.example.bots.entity.City;
import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ApiModel("City model")
@EqualsAndHashCode
public class CityDto {

    private Long id;
    private String name;
    private String description;

    public static CityDto fromModel(City city) {
        return new CityDto(city.getId(), city.getName(), city.getDescription());
    }
}
