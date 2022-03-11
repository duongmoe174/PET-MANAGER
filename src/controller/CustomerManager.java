package controller;

import model.Customer;
import model.Pet;
import storage.CustomerFromBinaryFileData;
import storage.ICustomerData;

import java.io.IOException;
import java.util.ArrayList;

public class CustomerManager {
    public static ICustomerData customerData = new CustomerFromBinaryFileData();
    public static ArrayList<Customer> customerList = customerData.readfile();

    public static void addNewCustomer(Customer customer ) {
        customerList.add(customer);
        try {
            customerData.writeFile(customerList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
