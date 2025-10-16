package org.example;

public class Client {
    // Create Client Class
    private String id;
    private String name;
    private String lastName;
    private String address;
    private String email;
    private boolean premium;

    public Client(String id, String name, String lastName, String address, String email, boolean premium){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.premium = premium;
    }

    // No getters, No Setters
}
