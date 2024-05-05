package ru.gb.homework_rick_and_morty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import ru.gb.homework_rick_and_morty.configuration.ConfigProperties;

@SpringBootApplication
@ConfigurationPropertiesScan
public class HomeworkRickAndMortyApplication {

	@Bean
	public RestTemplate template(){
		return new RestTemplate();
	};

	@Bean
	public HttpHeaders headers()
	{
		return new HttpHeaders();
	}

	public static void main(String[] args) {
		SpringApplication.run(HomeworkRickAndMortyApplication.class, args);
	}

}
