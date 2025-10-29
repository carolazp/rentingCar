package dev.app.rentingCar_boot.utils;

import dev.app.rentingCar_boot.model.Car;
import dev.app.rentingCar_boot.model.CarExtras;
import dev.app.rentingCar_boot.model.InssuranceCia;
import dev.app.rentingCar_boot.repository.CarExtrasRepository;
import dev.app.rentingCar_boot.repository.CarRepository;
import dev.app.rentingCar_boot.repository.InssuranceCiaRepository;
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

    @Autowired
    private InssuranceCiaRepository inssuranceCiaRepository;



    // populate Cars
    public void populateCar(int qty){
        List<Car> cars = generateCars(qty);
        List<CarExtras> carExtrass = generateCarExtras(qty);
        List<InssuranceCia> inssuranceCias = generateInssuranceCias(qty);

        assignCarToCarExtras(cars, carExtrass);
        assignInssuranceCiaToCar(cars, inssuranceCias);

    }


    // pair Car---CarExtras relationship
    public void assignCarToCarExtras(List<Car> cars, List<CarExtras> carExtrass){
        Random random = new Random();

        for (CarExtras carExtras:carExtrass){
            Car car = cars.get(random.nextInt(cars.size()));
            carExtras.setCarFK(car);
            carExtrasRepository.save(carExtras);
        }

    }


    // pair InssuranceCia(one)---Car(many) relationship
    public void assignInssuranceCiaToCar(List<Car> cars, List<InssuranceCia> inssuranceCias){
        Random random = new Random();

        for (Car car:cars){
            InssuranceCia inssuranceCia = inssuranceCias.get(random.nextInt(inssuranceCias.size()));
            car.setInssuranceCia(inssuranceCia);
            carRepository.save(car);
        }

    }



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


    //----------------------------GENERATE InssuranceCias---------------------------
    public List<InssuranceCia> generateInssuranceCias(int qty){

        List<InssuranceCia> generatedInssuranceCias = new ArrayList<>();
        Random random = new Random();

        String[] companyNames = {"State Farm", "Geico", "Progressive", "Allstate", "Liberty Mutual",
                "USAA", "Farmers", "Nationwide", "American Family", "Travelers"};

        String[] descriptions = {
                "Comprehensive auto insurance with excellent customer service",
                "Affordable car insurance with 24/7 claims support",
                "Innovative insurance solutions with competitive rates",
                "Full coverage auto insurance with roadside assistance",
                "Trusted insurance provider with nationwide coverage",
                "Premium insurance services for military families",
                "Local insurance expertise with personal touch",
                "Reliable coverage with accident forgiveness programs",
                "Family-focused insurance with multi-policy discounts",
                "Professional insurance services with quick claims processing"
        };

        for (int i = 0; i < qty ; i++) {
            InssuranceCia inssuranceCia = new InssuranceCia();

            String id = "INS" + String.format("%04d", i + 1);
            String name = companyNames[random.nextInt(companyNames.length)];
            String description = descriptions[random.nextInt(descriptions.length)];
            int qtyEmployee = 50 + random.nextInt(950); // between 50-1000 employees
            boolean isActive = random.nextBoolean();

            inssuranceCia.setId(id);
            inssuranceCia.setName(name);
            inssuranceCia.setDescription(description);
            inssuranceCia.setQtyEmployee(qtyEmployee);
            inssuranceCia.setActive(isActive);

            generatedInssuranceCias.add(inssuranceCia); // add it in the list of inssurancecias
            inssuranceCiaRepository.save(inssuranceCia); // save it in the database
        }

        return generatedInssuranceCias;

    }
    //--------------------------------------------------------------------------


}
