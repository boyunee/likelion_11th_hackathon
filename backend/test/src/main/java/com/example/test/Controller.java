package com.example.test;

import com.example.test.dto.GymReviewDto;
import com.example.test.dto.TrainerReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@CrossOrigin(origins = "*")
@RestController
public class Controller {
    @Autowired
    private Service service;

    public Controller(Service service) {

        this.service=service;
    }
    @PostMapping("/gym")
    public String test(@RequestBody GymReviewDto gymReviewDto) {
        service.addGymData(gymReviewDto);
        System.out.println(service.getGymList());
        return "result";
    }

    @RequestMapping("/gym/req")
    public ArrayList<GymReviewDto> test() {
        return service.getGymList();
    }

    @PostMapping("/trainer")
    public String trainer(@RequestBody TrainerReviewDto trainerReviewDto) {
        service.addTrainerData(trainerReviewDto);
        System.out.println(service.getTrainerList());
        return "result1";
    }

    @RequestMapping("/trainer/req")
    public ArrayList<TrainerReviewDto> trainer() {
        return service.getTrainerList();
    }

}
