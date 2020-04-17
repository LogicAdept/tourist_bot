package com.example.bots.web;

import com.example.bots.entity.City;
import com.example.bots.web.dto.CityDto;
import com.example.bots.web.dto.CreateUpdateCityDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Api(tags = "City management")
public interface ICityRestApi {

    @ApiOperation(
            value = "Get city"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "The city has been successfully found!"),
    })
    CityDto getByName(@PathVariable String name);

    @ApiOperation(
            value = "Get all cities"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "The cities has been successfully found!"),
    })
    List<CityDto> getAll();

    @ApiOperation(
            value = "Delete city"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "The city has been successfully deleted!"),
    })
    void delete(@PathVariable Long id);

    @ApiOperation(
            value = "Update city"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "The city has been successfully updated!"),
    })
    CityDto update(@PathVariable Long id, @RequestBody @Validated CreateUpdateCityDto cityDto);

    @ApiOperation(
            value = "Create city"
    )
    @ApiResponses({
            @ApiResponse(code = 201, message = "The city has been successfully created!"),
    })
    CityDto create(@RequestBody @Validated CreateUpdateCityDto cityDto);
}

