package com.example.Transport.schedule.TEST.Station_List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StationDataRepository extends JpaRepository<StationData, Long> {

    StationData findByTitle(String title);
}

