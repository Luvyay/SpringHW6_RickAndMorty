package ru.gb.homework_rick_and_morty.domain.episode;

import lombok.Data;

@Data
public class Episode {
    private Integer id;
    private String name;
    private String air_date;
    private String episode;
}
