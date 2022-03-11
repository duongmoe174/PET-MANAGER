package storage;

import model.Bill;

import java.io.*;
import java.util.ArrayList;

public class BillFromBinaryFile implements IBillData{
    @Override
    public ArrayList<Bill> readFile() {
        File file = new File("Bill.data");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object result = objectInputStream.readObject();
            ArrayList<Bill> billList = (ArrayList<Bill>) result;
            objectInputStream.close();
            fileInputStream.close();
            return billList;
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
    public void writeFile(ArrayList<Bill> billList) throws IOException {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("Bill.data");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(billList);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            objectOutputStream.close();
            fileOutputStream.close();
        }
    }
}
