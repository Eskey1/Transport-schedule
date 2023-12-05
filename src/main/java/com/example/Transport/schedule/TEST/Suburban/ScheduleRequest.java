package com.example.Transport.schedule.TEST.Suburban;

import lombok.Getter;

@Getter
public class ScheduleRequest {
    private String station;
    private String transportType;

    // геттеры и сеттеры

    public void setStation(String station) {
        this.station = station;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }
}
