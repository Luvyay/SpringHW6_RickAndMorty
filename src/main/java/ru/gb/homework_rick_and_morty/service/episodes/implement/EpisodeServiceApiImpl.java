package ru.gb.homework_rick_and_morty.service.episodes.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.gb.homework_rick_and_morty.domain.episode.Episode;
import ru.gb.homework_rick_and_morty.service.episodes.EpisodeServiceApi;

import java.util.ArrayList;
import java.util.List;

/**
 * Сервис по получению эпизодов из вселенной Rick and Morty
 */
@Service
public class EpisodeServiceApiImpl implements EpisodeServiceApi {
    @Autowired
    private RestTemplate template;

    @Autowired
    private HttpHeaders headers;

    /**
     * Метод для получения всех эпизодов с конкретным персонажем
     * @param urlsEpisodeWithCharacter - список ссылок на эпизоды у конкретного персонажа
     * @return - список эпизодов
     */
    @Override
    public List<Episode> getAllEpisodeWithCharacter(String[] urlsEpisodeWithCharacter) {
        List<Episode> responseList = new ArrayList<>();

        for (String url : urlsEpisodeWithCharacter) {
            responseList.add(getEpisodeByUrl(url));
        }

        return responseList;
    }

    /**
     * Метод для получения конкретного эпизода по ссылке
     * @param url
     * @return - эпизод
     */
    private Episode getEpisodeByUrl(String url) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Episode> responce = template.exchange(url, HttpMethod.GET, entity, Episode.class);

        return responce.getBody();
    }
}
