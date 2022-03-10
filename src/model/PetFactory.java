package model;

import controller.Validate;

public class PetFactory {
    private static Validate validate = new Validate();
    private PetFactory() {
    }

    public static final Pet createNewPet(PetType petType) throws IllegalAccessException {
        switch (petType) {
            case Cat: {
                return createNewCat();
            }
            case Dog: {
                return createNewDog();
            }
            case Mouse: {
                return createNewMouse();
            }
            default:
                throw new IllegalAccessException("We don't have this pet");
        }
    }

    public static Cat createNewCat() {
        System.out.println("Input id:");
        String id = validate.checkStringNotNull();

        System.out.println("Input name:");
        String name = validate.checkStringNotNull();

        System.out.println("Input age: ");
        int age = validate.checkInt();

        System.out.println("Input gender:");
        String gender = validate.checkStringNotNull();

        System.out.println("Input weight: ");
        double weight = validate.checkDouble();

        System.out.println("Input color: ");
        String color = validate.checkStringNotNull();

        System.out.println("Input longevity:");
        int longevity = validate.checkInt();

        System.out.println("Input nameBreed");
        String nameBreed = validate.checkStringNotNull();

        Breed breed = new Breed(nameBreed, longevity);

        System.out.println("Input price: ");
        double price = validate.checkDouble();

        System.out.println("Input type of leg");
        String typeOfLeg = validate.checkStringNotNull();

        System.out.println("Input tye of hair");
        String typeOfHair = validate.checkStringNotNull();

        return new Cat(id, name, age, gender, weight, color, breed, price, typeOfLeg, typeOfHair);
    }

    public static Dog createNewDog() {
        System.out.println("Input id:");
        String id = validate.checkStringNotNull();

        System.out.println("Input name:");
        String name = validate.checkStringNotNull();

        System.out.println("Input age: ");
        int age = validate.checkInt();

        System.out.println("Input gender:");
        String gender = validate.checkStringNotNull();

        System.out.println("Input weight: ");
        double weight = validate.checkDouble();

        System.out.println("Input color: ");
        String color = validate.checkStringNotNull();

        System.out.println("Input longevity:");
        int longevity = validate.checkInt();

        System.out.println("Input nameBreed");
        String nameBreed = validate.checkStringNotNull();

        Breed breed = new Breed(nameBreed, longevity);

        System.out.println("Input price: ");
        double price = validate.checkDouble();

        System.out.println("Input type of ear");
        String type = validate.checkStringNotNull();

        return new Dog(id, name, age, gender, weight, color, breed, price, type);
    }

    public static Mouse createNewMouse() {
        System.out.println("Input id:");
        String id = validate.checkStringNotNull();

        System.out.println("Input name:");
        String name = validate.checkStringNotNull();

        System.out.println("Input age: ");
        int age = validate.checkInt();

        System.out.println("Input gender:");
        String gender = validate.checkStringNotNull();

        System.out.println("Input weight: ");
        double weight = validate.checkDouble();

        System.out.println("Input color: ");
        String color = validate.checkStringNotNull();

        System.out.println("Input longevity:");
        int longevity = validate.checkInt();

        System.out.println("Input nameBreed");
        String nameBreed = validate.checkStringNotNull();

        Breed breed = new Breed(nameBreed, longevity);

        System.out.println("Input price: ");
        double price = validate.checkDouble();

        System.out.println("Input size: ");
        double size = validate.checkDouble();

        Mouse mouse = new Mouse(id, name, age, gender, weight,color,breed, price, size);
        return mouse;
    }
}

