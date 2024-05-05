package ru.gb.homework_rick_and_morty.controller.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.gb.homework_rick_and_morty.configuration.ConfigProperties;
import ru.gb.homework_rick_and_morty.domain.characters.Characters;
import ru.gb.homework_rick_and_morty.domain.characters.Result;
import ru.gb.homework_rick_and_morty.domain.episode.Episode;
import ru.gb.homework_rick_and_morty.service.characters.CharacterServiceApi;
import ru.gb.homework_rick_and_morty.service.episodes.EpisodeServiceApi;

import java.util.List;

@Controller
@AllArgsConstructor
public class CharacterControllerWeb {
    private CharacterServiceApi characterServiceApi;
    private EpisodeServiceApi episodeServiceApi;
    private ConfigProperties config;

    /**
     * Метод, который перенаправляет на первую страницу с персонажами
     * @return
     */
    @GetMapping("/web/characters")
    public String getFirstPage() {
        return "redirect:/web/characters/pages/1";
    }

    /**
     * Метод, который отображает конкретную страницу с персонажами
     * Принимает номер страницы и передает в model следующее:
     * 1. Список все персонажей для конкретной страницы.
     * 2. Номер следующей страницы (если страница null, то -1).
     * 3. Номер предыдущей страницы (если страница null, то -1).
     * 4. Заголовок страницы.
     * @param page
     * @param model
     * @return
     */
    @GetMapping("/web/characters/pages/{page}")
    public String getCharactersByPage(@PathVariable(name = "page") int page, Model model) {
        String url = config.getCHARACTER_API() + "/?page=" + page;
        Characters allCharacters = characterServiceApi.getAllCharacters(url);

        model.addAttribute("characters", allCharacters.getResults());
        model.addAttribute("next_page", characterServiceApi.getNextPage(allCharacters));
        model.addAttribute("prev_page", characterServiceApi.getPrevPage(allCharacters));
        model.addAttribute("title", "Characters");

        return "characters-web";
    }

    /**
     * Метод, который отображает страницу с персонажем по id
     * Принимает id персонажа и передает в model слудующее:
     * 1. Заголовок страницы.
     * 2. Конкретного персонажа.
     * 3. Список эпизодов с конкретным персонажем.
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/web/character/{id}")
    public String getCharacterById(@PathVariable(name = "id") int id, Model model) {
        String url = config.getCHARACTER_API() + "/" + id;
        Result character = characterServiceApi.getCharacterById(url);
        List<Episode> episodes = episodeServiceApi.getAllEpisodeWithCharacter(character.getEpisode());

        model.addAttribute("title", "character");
        model.addAttribute("character", character);
        model.addAttribute("episodes", episodes);


        return "character-web";
    }
}
