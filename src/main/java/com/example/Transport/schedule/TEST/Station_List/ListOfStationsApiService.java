package com.example.Transport.schedule.TEST.Station_List;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ListOfStationsApiService {

    private String apiKey = "c06c01e5-8f55-492c-b275-9e5db52ba287";


    public Country getData() {
        String apiUrl = "https://api.rasp.yandex.net/v3.0/stations_list/?apikey=" + apiKey + "&format=json&lang=ru_RU";

        try {
            // Используем RestTemplate для выполнения GET-запроса к API
            RestTemplate restTemplate = new RestTemplate();
            String jsonString = restTemplate.getForObject(apiUrl, String.class);

            // Инициализация ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Преобразование JSON-строки в объект
            Country yourObject = objectMapper.readValue(jsonString, Country.class);

            return yourObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}


