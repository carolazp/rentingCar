package dev.app.rentingCar_boot.repository;

import dev.app.rentingCar_boot.model.Car;
import org.springframework.data.repository.CrudRepository;

// This following line represents a book object in our application
public interface CarRepository extends CrudRepository<Car, String> {
}
