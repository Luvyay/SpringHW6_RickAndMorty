package ru.gb.homework_rick_and_morty.domain.characters;

import lombok.Data;
import ru.gb.homework_rick_and_morty.domain.location.Location;
import ru.gb.homework_rick_and_morty.domain.location.Origin;

import java.util.Date;

@Data
public class Result {
    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Origin origin;
    private Location location;
    private String image;
    private String[] episode;
    private String url;
    private Date created;
}
