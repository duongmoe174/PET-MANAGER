package view;

import controller.PetManager;
import controller.Validate;
import model.*;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Client {
    private static List<Pet> petListClient = PetManager.petList;
    private static Validate validate = new Validate();

    public static void main(String[] args) {
        int choiceMain = -1;
        Scanner inputChoiceMain = new Scanner(System.in);
        while (choiceMain != 0) {
            System.out.println("Menu");
            System.out.println("1. Add new pet");
            System.out.println("2. Show all pet");
            System.out.println("3. Edit Pet");
            System.out.println("4. Sort Pet");
            System.out.println("0. Exit");
            choiceMain = inputChoiceMain.nextInt();
            switch (choiceMain) {
                case 1:
                    addNewPet();
                    break;
                case 2:
                    showAllPet();
                    break;
                case 3:
                    editPetByID();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.err.println("Please let's choose one! ");
            }
        }
    }

    public static void showAllPet() {
        for (Pet pet : petListClient
        ) {
            System.out.println(pet);
        }
    }

    public static void addNewPet() {
        System.out.println("Input type Pet");
        Scanner inputType = new Scanner(System.in);
        try {
            PetType type = PetType.valueOf(inputType.nextLine());
            Pet pet = PetFactory.createNewPet(type);
            PetManager.addNewPet(pet);
        } catch (Exception e) {
            System.err.println("We don't have this Pet");
        }
    }

    public static void editPetByID() {
        System.out.println("Input Pet's id need edit: ");
        String id = validate.checkStringNotNull();
        int check = -1;
        if (PetManager.getPetById(id) == check) {
            System.err.println("Can't find the Pet, Please try again");
        } else {
            int index = PetManager.getPetById(id);
            if (petListClient.get(index) instanceof Cat) {
                System.out.println("Editing Cat: " + petListClient.get(index).getName());
                System.out.println("Edit id: " + "(" + petListClient.get(index).getId() + ")");
                String editId = validate.checkStringNotNull();

                System.out.println("Edit name: " + "(" + petListClient.get(index).getName() + ")");
                String editName = validate.checkStringNotNull();

                System.out.println("Edit age: " + "(" + petListClient.get(index).getAge() + ")");
                int editAge = validate.checkInt();

                System.out.println("Edit gender: " + "(" + petListClient.get(index).getGender() + ")");
                String editGender = validate.checkStringNotNull();

                System.out.println("Edit weight: " + "(" + petListClient.get(index).getWeight() + ")");
                double editWeight = validate.checkDouble();

                System.out.println("Edit color: " + "(" + petListClient.get(index).getColor() + ")");
                String editColor = validate.checkStringNotNull();

                System.out.println("Edit name of breed: " + "(" + petListClient.get(index).getBreed().getNameBreed()+ ")");
                String editNameBreed = validate.checkStringNotNull();

                System.out.println("Edit longevity: " + "(" + petListClient.get(index).getBreed().getLongevity() + ")");
                int editLongevity = validate.checkInt();

                Breed newBreed = new Breed(editNameBreed, editLongevity);

                System.out.println("Edit price: " + "(" + petListClient.get(index).getPrice() + ")");
               double editPrice = validate.checkDouble();

                System.out.println("Edit type of leg: " + "(" + ((Cat) petListClient.get(index)).getTypeOfLeg() + ")");
                String editLeg = validate.checkStringNotNull();

                System.out.println("Edit type of hair: " + "(" + ((Cat) petListClient.get(index)).getTypeOfHair() + ")");
                String editHair = validate.checkStringNotNull();

                Cat editCat = new Cat(editId, editName, editAge, editGender, editWeight, editColor, newBreed, editPrice, editLeg, editHair );
                PetManager.editPetByIndex(index, editCat);
            }
            if (petListClient.get(index) instanceof Dog) {
                System.out.println("Editing dog: " + petListClient.get(index).getName());
                System.out.println("Edit id: " + "(" + petListClient.get(index).getId() + ")");
                String editId = validate.checkStringNotNull();

                System.out.println("Edit name: " + "(" + petListClient.get(index).getName() + ")");
                String editName = validate.checkStringNotNull();

                System.out.println("Edit age: " + "(" + petListClient.get(index).getAge() + ")");
                int editAge = validate.checkInt();

                System.out.println("Edit gender: " + "(" + petListClient.get(index).getGender() + ")");
                String editGender = validate.checkStringNotNull();

                System.out.println("Edit weight: " + "(" + petListClient.get(index).getWeight() + ")");
                double editWeight = validate.checkDouble();

                System.out.println("Edit color: " + "(" + petListClient.get(index).getColor() + ")");
                String editColor = validate.checkStringNotNull();

                System.out.println("Edit name of breed: " + "(" + petListClient.get(index).getBreed().getNameBreed()+ ")");
                String editNameBreed = validate.checkStringNotNull();

                System.out.println("Edit longevity: " + "(" + petListClient.get(index).getBreed().getLongevity() + ")");
                int editLongevity = validate.checkInt();

                Breed newBreed = new Breed(editNameBreed, editLongevity);

                System.out.println("Edit price: " + "(" + petListClient.get(index).getPrice() + ")");
                double editPrice = validate.checkDouble();

                System.out.println("Edit type of ear: " + ((Dog) petListClient.get(index)).getTypeOfEar());
                String editType = validate.checkStringNotNull();

                Dog editDog = new Dog(editId, editName, editAge, editGender, editWeight, editColor, newBreed, editPrice, editType);
                PetManager.editPetByIndex(index, editDog);
            }
            if (petListClient.get(index) instanceof Mouse) {
                System.out.println("Editing mouse: " + petListClient.get(index).getName());
                System.out.println("Edit id: " + "(" + petListClient.get(index).getId() + ")");
                String editId = validate.checkStringNotNull();

                System.out.println("Edit name: " + "(" + petListClient.get(index).getName() + ")");
                String editName = validate.checkStringNotNull();

                System.out.println("Edit age: " + "(" + petListClient.get(index).getAge() + ")");
                int editAge = validate.checkInt();

                System.out.println("Edit gender: " + "(" + petListClient.get(index).getGender() + ")");
                String editGender = validate.checkStringNotNull();

                System.out.println("Edit weight: " + "(" + petListClient.get(index).getWeight() + ")");
                double editWeight = validate.checkDouble();

                System.out.println("Edit color: " + "(" + petListClient.get(index).getColor() + ")");
                String editColor = validate.checkStringNotNull();

                System.out.println("Edit name of breed: " + "(" + petListClient.get(index).getBreed().getNameBreed()+ ")");
                String editNameBreed = validate.checkStringNotNull();

                System.out.println("Edit longevity: " + "(" + petListClient.get(index).getBreed().getLongevity() + ")");
                int editLongevity = validate.checkInt();

                Breed newBreed = new Breed(editNameBreed, editLongevity);

                System.out.println("Edit price: " + "(" + petListClient.get(index).getPrice() + ")");
                double editPrice = validate.checkDouble();

                System.out.println("Edit size: " + "(" + ((Mouse) petListClient.get(index)).getSize() + ")");
                double editSize = validate.checkDouble();

                Mouse editMouse = new Mouse(editId, editName, editAge, editGender, editWeight, editColor, newBreed, editPrice, editSize);
                PetManager.editPetByIndex(index, editMouse);
            }
        }
    }
    public static void sortPetByPrice (){
        Collections.sort(petListClient);
        for (Pet pet: petListClient
             ) {
            System.out.println(pet);
        }
    }
}
