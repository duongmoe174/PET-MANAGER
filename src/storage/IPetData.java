package storage;

import model.Pet;

import java.io.IOException;
import java.util.ArrayList;

public interface IPetData {
    ArrayList<Pet> readfile();

    void writeFile(ArrayList<Pet> petList) throws IOException;
}
