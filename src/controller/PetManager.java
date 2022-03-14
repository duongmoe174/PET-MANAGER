package controller;

import model.Pet;
import model.PetFactory;
import storage.IPetData;
import storage.PetFromBinaryFile;

import java.io.IOException;
import java.util.ArrayList;

public class PetManager {
    public static IPetData petData = PetFactory.petFactoryData;
    public static ArrayList<Pet> petList = PetFactory.petFactoryList;

    public static void addNewPet(Pet pet) {
        petList.add(pet);
        try {
            petData.writeFile(petList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getPetById(String petId) {
        for (int i = 0; i < petList.size(); i++) {
            if (petList.get(i).getId().equals(petId)) {
                return i;
            }
        }
        return -1;
    }

    public static void editPetByIndex(int index, Pet pet) {
        petList.set(index, pet);
        try {
            petData.writeFile(petList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deletePet (int index) {
        petList.remove(index);
        try {
            petData.writeFile(petList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getPetByName(String petName) {
        for (int i = 0; i < petList.size(); i++) {
            if(petName.equals(petList.get(i).getName()))
                return i;
        }
        return -1;
    }
}
