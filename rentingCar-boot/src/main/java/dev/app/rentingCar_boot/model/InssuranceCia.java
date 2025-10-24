package dev.app.rentingCar_boot.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class InssuranceCia {

    @Id
    private String id;

    private String name;
    private String description;
    private int qtyEmployee;
    private boolean isActive;


    // construction of Car:
    public InssuranceCia(){
    }

    // getters and setters of InssuranceCia:
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

    public int getQtyEmployee() {
        return qtyEmployee;
    }

    public void setQtyEmployee(int qtyEmployee) {
        this.qtyEmployee = qtyEmployee;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    // other methods
    @Override
    public String toString() {
        return "InssuranceCia{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", qtyEmployee=" + qtyEmployee +
                ", isActive=" + isActive +
                '}';
    }


}
