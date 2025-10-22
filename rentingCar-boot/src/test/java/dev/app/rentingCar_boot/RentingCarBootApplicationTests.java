package dev.app.rentingCar_boot;

import dev.app.rentingCar_boot.model.Car;
import dev.app.rentingCar_boot.repository.CarRepository;

import dev.app.rentingCar_boot.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class RentingCarBootApplicationTests {

    // dependency injection
    @Autowired
    CarRepository carRepository;

    @Autowired
    CarService carService;


    // tests
	@Test
	void contextLoads() {
	}

    @Test
    void testCarRepository(){

//        Car car1 = new Car("1", "Toyota", "Corolla", "123456", 2022, 100.0);
//        carRepository.save(car1); // save(): this save this instance in the database (like an insert in SQL)
//
//        Car car2 = new Car("2", "Toyota", "Corolla", "123456", 2022, 100.0);
//        carRepository.save(car2);
//
//        Car car5 = new Car("5", "Toyota", "Corolla", "123456", 2020, 100.0);
//        carRepository.save(car5);



    }

    @Test
    void testFindCarById(){
        String id = "10";

        Optional<Car> car = carService.findCarById(id);
    }

    @Test
    void testDeleteById(){
        String id = "1";

        carService.deleteCarById(id);
    }

}
