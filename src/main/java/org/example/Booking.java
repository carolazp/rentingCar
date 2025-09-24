package org.example;

public class Booking {

    private String id;
    private boolean isActive;
    private int days;
    private double price;
    private Car car;
    private Client client;

    public Booking(String id, boolean isActive, int days, double price, Car car, Client client){
        this.id = id;
        this.isActive = isActive;
        this.days = days;
        this.price = price;
        this.car = car;
        this.client = client;
    }

    public Booking(){}

    // getters and setters of Booking class
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String toString(){
        return "Booking {" +
                "id='" + id + '\'' +
                ", car=" + car +
                ", days=" + days +
                ", price=" + price +
                ", isActive=" + isActive +
                '}';
    }
}
