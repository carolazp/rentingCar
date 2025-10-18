package dev.app.rentingCar_boot.service;

import dev.app.rentingCar_boot.model.Car;
import dev.app.rentingCar_boot.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;


    // Method findALl
    // not return, return Iterable
    public Iterable<Car> findAll(){

        Iterable<Car> foundCar = new ArrayList<>();

        foundCar = carRepository.findAll();

        return foundCar;

    }


    // Method findCarById
    // not return, return Optional
    public Optional<Car> findCarById (String id) {

        Optional<Car> foundCar = carRepository.findById(id);

        if (foundCar.isEmpty())
            System.out.println("Car not found!");
        else
            System.out.println("Car found: " + foundCar.get());

        return foundCar;

    }


    // Method deleteCarById
    // void: does NOT return anything
    public void deleteCarById(String id){

        carRepository.deleteById(id);

        Optional<Car> foundCar = carRepository.findById(id);

        if (foundCar.isEmpty())
            System.out.println("Car not found: we can not delete the car");
        else
            System.out.println("Car found and deleted: " + foundCar);

    }


    // Method Delete all cars
    public void deleteAllCar(){
        carRepository.deleteAll();
    }


    // Method Update: update a car info and save it
    public void updateCar(Car car){
        carRepository.save(car);
    }











}
