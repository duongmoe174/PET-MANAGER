package model;

import java.io.Serializable;

public class Bill implements Serializable {
    private String id;
    private int quantity;
    private Pet pet;
    private Customer customer;

    public Bill(String id, int quantity, Pet pet, Customer customer) {
        this.id = id;
        this.quantity = quantity;
        this.pet = pet;
        this.customer = customer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getTotalPrice () {
        double total = pet.getPrice() * quantity;
        return total;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id='" + id + '\'' +
                ", quantity=" + quantity +
                ", pet=" + pet.getName()+
                ", customer=" + customer.getName() +
                ", toltalPrice=" + getTotalPrice() +
                '}';
    }
}


