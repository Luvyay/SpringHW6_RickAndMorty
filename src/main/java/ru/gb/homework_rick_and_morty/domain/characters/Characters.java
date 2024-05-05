package ru.gb.homework_rick_and_morty.domain.characters;

import lombok.Data;

import java.util.List;

@Data
public class Characters {
     Info info;
     List<Result> results;
}
