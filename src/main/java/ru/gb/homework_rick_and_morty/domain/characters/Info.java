package ru.gb.homework_rick_and_morty.domain.characters;

import lombok.Data;

@Data
public class Info {
    private Integer count;
    private Integer pages;
    private String next;
    private String prev;
}
