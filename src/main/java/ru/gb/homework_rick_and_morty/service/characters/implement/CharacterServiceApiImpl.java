package ru.gb.homework_rick_and_morty.service.characters.implement;

import ru.gb.homework_rick_and_morty.domain.characters.Characters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.gb.homework_rick_and_morty.domain.characters.Result;
import ru.gb.homework_rick_and_morty.service.characters.CharacterServiceApi;

import java.util.List;

/**
 * Сервис по получению персонажей из вселенной Rick and Morty
 */
@Service
public class CharacterServiceApiImpl implements CharacterServiceApi {

    @Autowired
    private RestTemplate template;

    @Autowired
    private HttpHeaders headers;

    /**
     * Метод для получения списка персонажей из вселенной Rick and Morty
     * Возвращаются не все сразу, а постранично
     * @param url
     * @return - страница со списком персонажей
     */
    @Override
    public Characters getAllCharacters(String url) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> responce = template.exchange(url, HttpMethod.GET,entity, Characters.class);

        return responce.getBody();
    }

    /**
     * Метод для получения конкретного персонажа из вселенной Rick and Morty
     * @param url
     * @return - Result, который представляет из себя информацию о персонаже
     */
    @Override
    public Result getCharacterById(String url) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Result> response = template.exchange(url, HttpMethod.GET, entity, Result.class);

        return response.getBody();
    }

    /**
     * Метод для получения следующей страницы с персонажами из вселенной Rick and Morty
     * Принимает текущую страницу, вытягивет из нее ссылку на следующую страницу и оставляет только номер страницы
     * @param characters
     * @return - номер страницы, если номер страницы равен null, то возвращается -1
     */
    @Override
    public int getNextPage(Characters characters) {
        String nextPage = characters.getInfo().getNext();

        if (nextPage  != null) {
            nextPage = nextPage.split("=")[1];

            return Integer.parseInt(nextPage);
        }

        return -1;
    }

    /**
     * Метод для получения предыдущей страницы с персонажами из вселенной Rick and Morty
     * Принимает текущую страницу, вытягивет из нее ссылку на предыдущую страницу и оставляет только номер страницы
     * @param characters
     * @return - номер страницы, если номер страницы равен null, то возвращается -1
     */
    @Override
    public int getPrevPage(Characters characters) {
        String prevPage = characters.getInfo().getPrev();

        if (prevPage != null) {
            prevPage = prevPage.split("=")[1];

            return Integer.parseInt(prevPage);
        }

        return -1;
    }
}
