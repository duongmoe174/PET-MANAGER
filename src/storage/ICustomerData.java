package storage;

import model.Customer;

import java.io.IOException;
import java.util.ArrayList;

public interface ICustomerData {
    ArrayList<Customer> readfile();
    void writeFile (ArrayList<Customer> customerList ) throws IOException;
}
