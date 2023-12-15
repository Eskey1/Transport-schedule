package com.example.Transport.schedule.TEST.Suburban;

import com.example.Transport.schedule.TEST.DTO.ScheduleResponse;
import com.example.Transport.schedule.TEST.Station_List.ListOfStationsApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/apiv1")
public class ScheduleController {


    private final SchedulesService myService;
    private final ListOfStationsApiService listOfStationsApiService;

    @Autowired
    public ScheduleController(SchedulesService myService, ListOfStationsApiService listOfStationsApiService) {
        this.myService = myService;
        this.listOfStationsApiService = listOfStationsApiService;
    }

    @PostMapping("/getData")
    public ResponseEntity<ScheduleResponse> processData(@RequestBody ScheduleRequest request) {
        ScheduleResponse result = myService.getSchedule(request.getStation(), request.getTransportType());
        return ResponseEntity.ok(result);
    }

}
