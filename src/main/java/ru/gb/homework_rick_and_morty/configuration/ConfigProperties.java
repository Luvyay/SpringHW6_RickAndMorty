package ru.gb.homework_rick_and_morty.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "url")
@Getter
@Setter
public class ConfigProperties {
    private String CHARACTER_API;
}
