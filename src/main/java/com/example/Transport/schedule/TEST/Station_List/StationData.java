package com.example.Transport.schedule.TEST.Station_List;


import jakarta.persistence.*;
import lombok.Getter;

import java.util.Objects;

@Entity
@Getter
public class StationData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String code;
    private String station_type;

    // геттеры и сеттеры

    public StationData() {
    }

    // конструктор для создания StationData из Station
    public StationData(Country.CountryData.Station station) {
        this.title = station.getTitle();
        this.code = station.getCodes().getYandexCode();
        this.station_type = station.getStation_type();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationData that = (StationData) o;
        return Objects.equals(title, that.title) && Objects.equals(code, that.code) && Objects.equals(station_type, that.station_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, code, station_type);
    }
}
