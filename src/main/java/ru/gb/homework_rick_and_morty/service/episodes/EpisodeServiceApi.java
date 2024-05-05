package ru.gb.homework_rick_and_morty.service.episodes;

import ru.gb.homework_rick_and_morty.domain.episode.Episode;

import java.util.List;

public interface EpisodeServiceApi {
    List<Episode> getAllEpisodeWithCharacter(String[] urlEpisodeWithCharacter);
}
