//package com.example.Transport.schedule.controller;
//
//import com.example.Transport.schedule.models.ScheduleDto;
//import com.example.Transport.schedule.models.Station;
//import com.example.Transport.schedule.service.ScheduleService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@Controller
//@RequiredArgsConstructor
//public class MyController {
//    @Autowired
//    private final ScheduleService scheduleService;
//
//    @GetMapping("/")
//    public String index(Model model) {
//        List<Station> stations = List.of(
//                new Station("Битца", "9875609"),
//                new Station("Саларьево", "9876347"),
//                new Station("Северные ворота", "9872014")
//        );
//
//        model.addAttribute("stations", stations);
//        return "Main";
//    }
//
//    @PostMapping("/getSchedule")
//    public String getSchedule(String stationCode, Model model) {
//        List<ScheduleDto> schedule = scheduleService.getSchedule(stationCode);
//        model.addAttribute("schedule", schedule);
//        return "Main";
//    }
//
//    @GetMapping("/")
//    public  String index(){
//        return "redirect:/Main";
//    }
//
//    @GetMapping("/Main")
//    public String Main(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "Main";
//    }
//}
package com.example.Transport.schedule.controller;

import com.example.Transport.schedule.models.ScheduleDto;
import com.example.Transport.schedule.service.ScheduleService;
import com.example.Transport.schedule.models.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class MyController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/Main")
    public String index(Model model) {
        List<Station> stations = List.of(
                new Station("Битца", "9875609"),
                new Station("Саларьево", "9876347"),
                new Station("Северные ворота", "9872014")
        );

        model.addAttribute("stations", stations);
        return "Main";
    }

    @PostMapping("/getSchedule")
    public String getSchedule(String stationCode, Model model) {
        List<ScheduleDto> schedule = scheduleService.getSchedule(stationCode);
        model.addAttribute("schedule", schedule);
        return "Main";
    }

    @GetMapping("/")
    public  String index(){
        return "redirect:/Main";
    }

}