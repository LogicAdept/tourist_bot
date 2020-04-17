package com.example.bots.entity;

import com.sun.xml.bind.v2.model.core.ID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "city")
@EqualsAndHashCode
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public static City of(Long id, String name, String description) {
        City city = new City();
        city.setId(id);
        city.setName(name);
        city.setDescription(description);
        return city;
    }

    public static City of(String name, String description) {
        City city = new City();
        city.setName(name);
        city.setDescription(description);
        return city;
    }
}
