package dev.app.rentingCar_boot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
public class CarExtras {

    @Id
    private String id;

    private String name;
    private String description;
    private double dailyPrice;
    private boolean available;
    private String category;



    // Connection with car.java model and this model
    // many-to-one relationship: many carExtras to one car
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CAR_FK")
    private Car carFK;



    public CarExtras(String id, String name, String description, double dailyPrice, boolean available, String category){
        this.id = id;
        this.name = name;
        this.description = description;
        this.dailyPrice = dailyPrice;
        this.available = available;
        this.category = category;
    }



    // other construction of CarExtras:
    public CarExtras(){
    }

    // getters and setters methods:

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    // getter and setter of new attriute carFK  (carKF:Car)
    public Car getCarFK() {
        return carFK;
    }

    public void setCarFK(Car carFK) {
        this.carFK = carFK;
    }


    // other methods:
    @Override
    public String toString(){
        return "CarExtras{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dailyPrice='" + dailyPrice + '\'' +
                ", available=" + available +
                ", category=" + category +
                '}';

    }

}
