package dev.app.rentingCar_boot.repository;

import dev.app.rentingCar_boot.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, String>{

}