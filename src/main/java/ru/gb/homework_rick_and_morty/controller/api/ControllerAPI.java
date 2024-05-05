package ru.gb.homework_rick_and_morty.controller.api;

import lombok.AllArgsConstructor;
import ru.gb.homework_rick_and_morty.configuration.ConfigProperties;
import ru.gb.homework_rick_and_morty.domain.characters.Characters;
import ru.gb.homework_rick_and_morty.service.characters.CharacterServiceApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ControllerAPI {
    private CharacterServiceApi serviceApi;
    private ConfigProperties config;

    @GetMapping("/api")
    public ResponseEntity<Characters> getCharacters()
    {
        String url = config.getCHARACTER_API();
        Characters allCharacters = serviceApi.getAllCharacters(url);
        return new ResponseEntity<>(allCharacters, HttpStatus.OK);
    }
}
