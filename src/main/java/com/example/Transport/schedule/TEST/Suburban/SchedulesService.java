package com.example.Transport.schedule.TEST.Suburban;

import com.example.Transport.schedule.TEST.Station_List.StationData;
import com.example.Transport.schedule.TEST.Station_List.StationDataRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class SchedulesService {
    private final StationDataRepository stationDataRepository;
    private String apiKey = "c06c01e5-8f55-492c-b275-9e5db52ba287";

    @Autowired
    public SchedulesService(StationDataRepository stationDataRepository) {
        this.stationDataRepository = stationDataRepository;
    }

    public ScheduleResponse getSchedule(String station, String transport_type) {

        String stationCode = getStationCode(station);

        String apiUrl = "https://api.rasp.yandex.net/v3.0/schedule/?apikey=" + apiKey + "&station=" + stationCode + "&transport_types=" + transport_type;


        try {
            // Используем RestTemplate для выполнения GET-запроса к API
            RestTemplate restTemplate = new RestTemplate();
            String jsonString = restTemplate.getForObject(apiUrl, String.class);

            // Инициализация ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Преобразование JSON-строки в объект
            ScheduleResponse yourObject = objectMapper.readValue(jsonString, ScheduleResponse.class);

            return yourObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getStationCode(String stationName) {
        Optional<StationData> stationData = Optional.ofNullable(stationDataRepository.findByTitle(stationName));

        if (stationData.isPresent()) {
            StationData station = stationData.get();
            return station.getCode();
        }

        return "";
    }
}
