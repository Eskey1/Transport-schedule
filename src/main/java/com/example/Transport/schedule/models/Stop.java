package com.example.Transport.schedule.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "Stop")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Stop {
    @Id
    @GeneratedValue
    private UUID StopId;

    private String StopName;

}
