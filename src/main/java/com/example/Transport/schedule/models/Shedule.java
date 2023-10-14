package com.example.Transport.schedule.models;

import jakarta.persistence.*;

import java.util.UUID;

public class Shedule {

    @Id
    @GeneratedValue
    private UUID SheduleId;

    private String DepartureTime;

    private UUID RouteId;


}
