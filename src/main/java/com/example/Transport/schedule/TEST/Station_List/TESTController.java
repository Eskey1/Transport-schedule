package com.example.Transport.schedule.TEST.Station_List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class TESTController {

    private final ListOfStationsService listOfStationsService;

    @Autowired
    public TESTController(ListOfStationsService listOfStationsService) {
        this.listOfStationsService = listOfStationsService;
    }

    @GetMapping("/data")
    public String processData() {
        // Вызывает метод вашего сервиса для обработки и сохранения данных
        listOfStationsService.processAndSaveData();

        return "good";
    }
}