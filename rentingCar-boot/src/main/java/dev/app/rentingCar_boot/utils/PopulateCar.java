package dev.app.rentingCar_boot.utils;

import dev.app.rentingCar_boot.model.Car;
import dev.app.rentingCar_boot.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class PopulateCar {

    @Autowired
    private CarRepository carRepository;


    // generate ramdom plate for Cars
    public String generateRandomPlate(Random random){
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
    public List<Car> generateCars(int qtyCars){

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
        return generatedCars;
    }




}
