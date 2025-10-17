package dev.app.rentingCar_boot.repository;

import dev.app.rentingCar_boot.model.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking, String>{

}