package se.vert.chuck.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import se.vert.chuck.model.ChuckModel;

import java.io.IOException;

@Service
public class ChuckService {

    private final static String BASE_URL = "https://api.chucknorris.io/jokes/";

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final RestTemplate restTemplate;

    public ChuckService() {
        final RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        this.restTemplate = restTemplateBuilder //
                .interceptors(new XUserAgentInterceptor()) //
                .build();
    }

    public ChuckModel obtainRandom() {
        return this.restTemplate.getForObject(BASE_URL + "random", ChuckModel.class);

    }

    public ChuckModel obtainRandom(String category) {
        return this.restTemplate.getForObject(BASE_URL + "random?category={category}", ChuckModel.class, category);
    }

    public String[] obtainCategories() {
        return this.restTemplate.getForObject(BASE_URL + "categories", String[].class);
    }
}
