package com.example.Transport.schedule.TEST.Suburban;

import com.example.Transport.schedule.TEST.Station_List.ListOfStationsApiService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<ScheduleResponse> processData(ScheduleRequest request) {
        ScheduleResponse result = myService.getSchedule(request.getStation(), request.getTransportType());
        return ResponseEntity.ok(result);
    }

}
