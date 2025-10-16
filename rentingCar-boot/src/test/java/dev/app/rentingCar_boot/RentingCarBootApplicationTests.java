package dev.app.rentingCar_boot;


import dev.app.rentingCar_boot.model.Car;
import dev.app.rentingCar_boot.repository.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RentingCarBootApplicationTests {

    @Autowired // FOR WHAT????
    CarRepository carRepository;

	@Test
	void contextLoads() {
	}

    @Test
    void testCarRepository(){

//        Car car1 = new Car("1", "Toyota", "Corolla", "123456", 2022, 100.0);
//        carRepository.save(car1);
//
//        Car car2 = new Car("2", "Toyota", "Corolla", "123456", 2022, 100.0);
//        carRepository.save(car2);

    }








}
