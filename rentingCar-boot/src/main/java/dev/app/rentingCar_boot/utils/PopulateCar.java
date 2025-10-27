package dev.app.rentingCar_boot.utils;

import dev.app.rentingCar_boot.model.Car;
import dev.app.rentingCar_boot.model.CarExtras;
import dev.app.rentingCar_boot.repository.CarExtrasRepository;
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

    @Autowired
    private CarExtrasRepository carExtrasRepository;


    //----------------------------GENERATE CARS----------------------------
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
    //--------------------------------------------------------------------------


    //----------------------------GENERATE CARSEXTRAS---------------------------
    public List<CarExtras> generateCarExtras(int qtyCars){

        List<CarExtras> generatedCarExtras = new ArrayList<>();
        Random random = new Random();

        String[] extraNames = {"GPS Navigation", "Child Seat", "Roof Rack", "Ski Rack", "Bike Rack",
                "WiFi Hotspot", "Dash Cam", "Premium Insurance", "Roadside Assistance",
                "Additional Driver", "Fuel Service", "Car Wash"};

        String[] descriptions = {
                "Professional GPS navigation system with real-time traffic updates",
                "Safety-certified child seat for secure transportation",
                "Heavy-duty roof rack for additional cargo capacity",
                "Specialized ski equipment carrier for winter sports",
                "Secure bike mounting system for cycling enthusiasts",
                "High-speed internet connectivity on the go",
                "HD recording device for trip documentation and security",
                "Comprehensive coverage with reduced deductible",
                "24/7 emergency assistance and towing service",
                "Allow additional qualified driver at no extra cost",
                "Pre-filled fuel tank with return flexibility",
                "Professional car cleaning service included"
        };

        String[] categories = {"Navigation", "Safety", "Sport", "Technology", "Insurance", "Service"};

        for (int i=0; i<qtyCars; i++){
            String id = "EXT" + String.format("%04d", i + 1);
            String name = extraNames[random.nextInt(extraNames.length)];
            String description = descriptions[random.nextInt(descriptions.length)];
            double dailyPrice = 5.0 + (random.nextDouble() * 45.0); // Price between 5-50
            boolean available = random.nextBoolean();
            String category = categories[random.nextInt(categories.length)];

            CarExtras carExtra = new CarExtras(id, name, description, dailyPrice, available, category);
            generatedCarExtras.add(carExtra);
            carExtrasRepository.save(carExtra);
        }

        return generatedCarExtras;
    }
    //--------------------------------------------------------------------------




}
