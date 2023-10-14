package com.example.Transport.schedule.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

public class Stop {
    @Id
    @GeneratedValue
    private UUID StopId;

    private String StopName;

}
