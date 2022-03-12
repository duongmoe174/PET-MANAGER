package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Bill implements Serializable {
    private String id;
    private Customer customer;
    private ArrayList<Pet> pets;
    private double totalOfBill;

    public Bill(String id, Customer customer, ArrayList<Pet> pets, double totalOfBill) {
        this.id = id;
        this.customer = customer;
        this.pets = pets;
        this.totalOfBill = totalOfBill;
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    public double getTotalOfBill() {
        return totalOfBill;
    }

    public void setTotalOfBill(double totalOfBill) {
        this.totalOfBill = totalOfBill;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        String result = "Bill id: " + id + "\n" +
                "Customer: " + customer + "\n" +
                "Total Price: " + totalOfBill + "\n" +
                "Name of pets: ";
        for (int i = 0; i < pets.size(); i++) {
            result += pets.get(i).getName() + " at id " + pets.get(i).getId() + "    ";
        }
        return result;
    }
}


