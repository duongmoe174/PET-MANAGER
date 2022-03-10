package view;

import controller.PetManager;
import model.*;

import java.util.List;
import java.util.Scanner;

public class Client {
    private static List<Pet> petListClient = PetManager.petList;

    public static void main(String[] args){
        int choiceMain = -1;
        Scanner inputChoiceMain = new Scanner(System.in);
        while (choiceMain != 0) {
            System.out.println("Menu");
            System.out.println("1. Add new pet");
            System.out.println("2. Show all pet");
            System.out.println("0. Exit");
            choiceMain = inputChoiceMain.nextInt();
            switch (choiceMain) {
                case 1:
                    addNewPet();
                    break;
                case 2:
                    showAllPet();
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

    public static void addNewPet(){
        System.out.println("Input type Pet");
        Scanner inputType = new Scanner(System.in);
        try {
            PetType type = PetType.valueOf(inputType.nextLine());
            Pet  pet = PetFactory.createNewPet(type);
            PetManager.addNewPet(pet);
        }
        catch (Exception e) {
            System.err.println("We don't have this Pet");
        }
    }
}
