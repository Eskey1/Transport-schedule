package com.example.Transport.schedule.TEST.Station_List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ListOfStationsService {
    private final StationDataRepository stationDataRepository;
    private final ListOfStationsApiService listOfStationsApiService;

    @Autowired
    public ListOfStationsService(StationDataRepository stationDataRepository, ListOfStationsApiService listOfStationsApiService) {
        this.stationDataRepository = stationDataRepository;
        this.listOfStationsApiService = listOfStationsApiService;
    }

    public void processAndSaveData() {
        Country countries = listOfStationsApiService.getData();
        List<StationData> trainStations = new ArrayList<>();

        // Итерируем по каждой стране в массиве
        for (Country.CountryData country : countries.getCountries()) {
            for (Country.CountryData.Region region : country.getRegions()) {
                for (Country.CountryData.Settlement settlement : region.getSettlements()) {
                    if (Objects.equals(settlement.getTitle(), "Москва")) {
                        for (Country.CountryData.Station station : settlement.getStations()) {
                            // Создаем объект StationData из Station
                            StationData existingStationData = stationDataRepository.findByTitle(station.getTitle());

                            if (existingStationData == null && (Objects.equals(station.getTransportType(), "train") ||
                                    Objects.equals(station.getTransportType(), "suburban") ||
                                    Objects.equals(station.getTransportType(), "bus")) ) {
                                // Создаем объект StationData из Station
                                StationData stationData = new StationData(station);
                                // Сохраняем в базу данных
                                stationDataRepository.save(stationData);

                            }
                        }
                    }
                }
            }
        }
    }
}
