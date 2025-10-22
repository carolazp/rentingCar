package dev.app.rentingCar_boot.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Entity
public class Car {

    @Id
    private String id;

    private String brand;
    private String model;
    private String plate;

    @Column(name="car_year")
    private int year;
    private double price;



    // Connection with CarExtra.java model and this model
    // one-to-many relationship: one car have many carExtras
    @OneToMany(mappedBy = "carFK", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CarExtras> carExtras = new ArrayList<>(); // new attribute for Car model: carExtras



    // Generate 4-digits UUID for the car
    // @return a 4-digit string ID
    private String generateFourDigitUuid(){
        Random random = new Random();
        int uuid = 1000 + random.nextInt(9000); // generate number between 1000-9999

        return String.valueOf(uuid);
    }

    public Car(String brand, String model, String plate, int year, double price){
        this.id = generateFourDigitUuid();
        this.brand = brand;
        this.model = model;
        this.plate = plate;
        this.year = year;
        this.price = price;
    }



    // other constructions of Car:
    public Car() {
        this.id = generateFourDigitUuid();
    }

    public Car(String id){
        this.id = id;
        this.carExtras = new ArrayList<>();
    }

    // methods belonging to the Car class
    // 1º getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


   // getters and setters of new attribute carExtras  (carExtras:List<CarExtras>)
    public List<CarExtras> getCarExtras() {
        return carExtras;
    }

    public void setCarExtras(List<CarExtras> carExtras) {
        this.carExtras = carExtras;
    }


    // 2º other methods
    public int carAge(){
        return 2025 - year;
    }

    @Override
    public String toString(){
        return "Car{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", plate='" + plate + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
