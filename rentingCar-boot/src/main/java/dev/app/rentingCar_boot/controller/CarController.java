package dev.app.rentingCar_boot.controller;

import dev.app.rentingCar_boot.model.Car;
import dev.app.rentingCar_boot.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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


    // generate ramdom plate for Cars
    private String generateRandomPlate(Random random){
        StringBuilder plate = new StringBuilder();

        // generate 3 letters: one letter in each loop
        for (int i=0 ; i<3; i++){
            plate.append((char) ('A' + random.nextInt(26))); // A + 25 = Z
        }

        // generate 4 numbers: one number in each loop
        for (int i=0; i<4; i++){
            plate.append(random.nextInt(10));
        }

        return plate.toString();
    }

    // populate Cars (Car model) with fake/random data
    @GetMapping("/cars/generate")
    public String generateCars(@RequestParam int qtyCars){

        List<Car> generatedCars = new ArrayList<>();
        Random random = new Random();

        String[] brands = {"Toyota", "Honda", "Ford", "BMW", "Mercedes", "Audi", "Volkswagen", "Nissan", "Hyundai", "Kia"};
        String[] models = {"Sedan", "SUV", "Hatchback", "Coupe", "Convertible", "Wagon", "Pickup", "Crossover"};

        for (int i = 0; i < qtyCars; i++){
            String brand = brands[random.nextInt(brands.length)];
            String model = models[random.nextInt(models.length)];
            String plate = generateRandomPlate(random);
            int year = 2010 + random.nextInt(15); // Years between 2010-2024
            double price = 50.0 + (random.nextDouble() * 450.0); // Price between 50-500

            Car car = new Car(brand, model, plate, year, price);
            generatedCars.add(car);
            carRepository.save(car);
        }

        // return "Successfully generated " + qtyCars + " cars. Total cars in database: " + carRepository.count();
        return "cars"; // This is cars.html ( src.main.resources.templates. "CARS.HTML" )

    }









}