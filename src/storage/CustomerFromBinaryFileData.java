package storage;

import model.Customer;

import java.io.*;
import java.util.ArrayList;

public class CustomerFromBinaryFileData implements ICustomerData {
    @Override
    public ArrayList<Customer> readfile() {
        File file = new File("Customer.data");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object result = objectInputStream.readObject();
            ArrayList<Customer> customerList = (ArrayList<Customer>) result;
            objectInputStream.close();
            fileInputStream.close();
            return customerList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public void writeFile(ArrayList<Customer> customerList) throws IOException {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("Customer.data");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(customerList);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            objectOutputStream.close();
            fileOutputStream.close();
        }
    }
}
