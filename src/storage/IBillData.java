package storage;

import model.Bill;

import java.io.IOException;
import java.util.ArrayList;

public interface IBillData {
    ArrayList<Bill> readFile ();
    void writeFile (ArrayList<Bill> billList) throws IOException;
}
