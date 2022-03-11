package controller;

import model.Bill;
import model.Customer;
import storage.BillFromBinaryFile;
import storage.IBillData;

import java.io.IOException;
import java.util.ArrayList;

public class BillManager {
    public static IBillData billData = new BillFromBinaryFile();
    public static ArrayList<Bill> billList = billData.readFile();

    public static void addNewBill(Bill bill ) {
        billList.add(bill);
        try {
            billData.writeFile(billList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
