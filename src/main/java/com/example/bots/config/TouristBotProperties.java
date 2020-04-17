package com.example.bots.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "telegram.tourist")
public class TouristBotProperties {

    private String token;
    private String username;

}
