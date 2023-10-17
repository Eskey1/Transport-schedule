package com.example.Transport.schedule.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Entity
@Table(name = "Shedule")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Shedule {

    @Id
    @GeneratedValue
    private UUID SheduleId;

    private String DepartureTime;

    private UUID RouteId;
}
