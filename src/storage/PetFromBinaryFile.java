package storage;

import model.Pet;

import java.io.*;
import java.util.ArrayList;

public class PetFromBinaryFile implements IPetData {
    @Override
    public ArrayList<Pet> readfile() {
        File file = new File("FileData/pet.data");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object result = objectInputStream.readObject();
            ArrayList<Pet> petList = (ArrayList<Pet>) result;
            objectInputStream.close();
            fileInputStream.close();
            return petList;
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
    public void writeFile(ArrayList<Pet> petList) throws IOException {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("FileData/pet.data");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(petList);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            objectOutputStream.close();
            fileOutputStream.close();
        }
    }
}
