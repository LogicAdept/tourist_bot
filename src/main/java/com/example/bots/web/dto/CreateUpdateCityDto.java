package com.example.bots.web.dto;

import com.example.bots.entity.City;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ApiModel("Create-update city")
public class CreateUpdateCityDto {

    @Length(min = 1, max = 200)
    @ApiModelProperty(required = true)
    private String name;

    @Length(max = 200)
    @ApiModelProperty(required = true)
    private String description;

    public City toModel(Long id) {
        return City.of(id, name, description);
    }

    public City toModel() {
        return City.of(name, description);
    }
}
