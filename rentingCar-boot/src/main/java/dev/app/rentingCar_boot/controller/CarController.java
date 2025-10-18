package dev.app.rentingCar_boot.controller;

import dev.app.rentingCar_boot.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController{

    @Autowired // injects an instance of CarRepository into the controller
    CarRepository carRepository;

    @GetMapping("/cars")
    public String listCar(Model model){
        model.addAttribute("cars", carRepository.findAll());

        System.out.println("Cars (Controller /cars): " + carRepository.findAll());

        return "cars"; // This is cars.html ( src.main.resources.templates. "CARS.HTML" )

    }

    @GetMapping("/cars-nocss")
    public String listCarNoCss(Model model){
        model.addAttribute("car", carRepository.findAll());
        System.out.println("Cars (Controller /cars-nocss): " + carRepository.findAll());
        return "cars-nocss";
    }

    @GetMapping("/cars-nocss-data")
    public String listCarNoCssData(Model model){
        model.addAttribute("cars", carRepository.findAll());

        System.out.println("Cars (Controller /cars-nocss-data): " + carRepository.findAll());

        return "cars-nocss-data"; // This is cars.html ( src.main.resources.templates. "CARS.HTML" )

    }

}