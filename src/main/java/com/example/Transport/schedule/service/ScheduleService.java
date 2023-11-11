package com.example.Transport.schedule.service;

import com.example.Transport.schedule.models.ScheduleDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ScheduleService {

    @Value("${yandex.api.key}")
    private String apiKey;

    public List<ScheduleDto> getSchedule(String stationCode) {
        String apiUrl = "https://api.rasp.yandex.net/v3.0/search/?apikey=" + apiKey
                + "&from=" + stationCode
                + "&to=&format=json&transport_types=bus";

        RestTemplate restTemplate = new RestTemplate();
        ScheduleDto[] scheduleArray = restTemplate.getForObject(apiUrl, ScheduleDto[].class);

        if (scheduleArray != null) {
            return Arrays.asList(scheduleArray);
        } else {
            return List.of();
        }
    }
}