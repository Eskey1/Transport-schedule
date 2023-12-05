package com.example.Transport.schedule.TEST.Suburban;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScheduleResponse {

    private String date;
    private Station station;
    private String event;
    private Pagination pagination;
    private List<ScheduleItem> schedule;
    private List<Object> interval_schedule;

    // геттеры и сеттеры

    // внутренние классы
    public static class Station {
        private String type;
        private String title;
        private String short_title;
        private String popular_title;
        private String code;
        private String station_type;
        private String station_type_name;
        private String transport_type;

        // геттеры и сеттеры
    }

    public static class Pagination {
        private int total;
        private int limit;
        private int offset;

        // геттеры и сеттеры
    }

    public static class ScheduleItem {
        private Thread thread;
        private boolean is_fuzzy;
        private String platform;
        private String terminal;
        private String days;
        private String except_days;
        private String stops;
        private String departure;
        private String arrival;

        // геттеры и сеттеры
    }

    public static class Thread {
        private String number;
        private String title;
        private String short_title;
        private String express_type;
        private String transport_type;
        private Carrier carrier;
        private String uid;
        private Object vehicle;
        private TransportSubtype transport_subtype;

        // геттеры и сеттеры
    }

    public static class Carrier {
        private int code;
        private String title;
        private Codes codes;

        // геттеры и сеттеры
    }

    public static class Codes {
        private Object sirena;
        private Object iata;
        private Object icao;

        // геттеры и сеттеры
    }

    public static class TransportSubtype {
        private String title;
        private String code;
        private String color;

        // геттеры и сеттеры
    }
}
