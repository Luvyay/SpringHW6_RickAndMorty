package ru.gb.homework_rick_and_morty.service.characters;

import ru.gb.homework_rick_and_morty.domain.characters.Characters;
import ru.gb.homework_rick_and_morty.domain.characters.Result;

public interface CharacterServiceApi {
    Characters getAllCharacters(String url);

    Result getCharacterById(String url);

    int getNextPage(Characters characters);

    int getPrevPage(Characters characters);

}
