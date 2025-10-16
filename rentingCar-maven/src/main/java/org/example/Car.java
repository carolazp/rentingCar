package org.example;

public class Car {

    // Construyendo/definiendo la clase con sus parametros
    private String id;
    private String brand;
    private String model;
    private String plate;
    private int year;
    private double price;

    public Car(String id, String brand, String model, String plate, int year, double price){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.plate = plate;
        this.year = year;
        this.price = price;
    }

    // other constructions of Car:
    public Car() {}

    public Car(String id){
        this.id = id;
    }

    // los metodos propios de la clase Car
    // 1º getters y setters

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
