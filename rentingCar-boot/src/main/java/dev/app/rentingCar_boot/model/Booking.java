package dev.app.rentingCar_boot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Booking {

    @Id
    private String id;
}