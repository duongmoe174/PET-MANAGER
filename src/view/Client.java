package view;

import controller.BillManager;
import controller.CustomerManager;
import controller.PetManager;
import controller.Validate;
import model.*;

import java.sql.SQLOutput;
import java.util.*;

public class Client {
    private static List<Pet> petListClient = PetManager.petList;
    private static List<Customer> customerListClient = CustomerManager.customerList;
    private static List<Bill> billListClient = BillManager.billList;

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
            System.out.println("5. Remove Pet");
            System.out.println("6. Add new bill");
            System.out.println("7. Show bill");
            System.out.println("8. Show customer");
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
                case 4:
                    int choiceCase4 = -1;
                    Scanner inputCase4 = new Scanner(System.in);
                    while (choiceCase4 != 0) {
                        System.out.println("1. Sort Pet by Age");
                        System.out.println("2. Sort Pet by Price");
                        System.out.println("3. Sort Cat by real money");
                        System.out.println("4. Sort Dog by real money");
                        System.out.println("5. Sort Mouse by real money");
                        System.out.println("0. Return");
                        choiceCase4 = inputCase4.nextInt();
                        switch (choiceCase4) {
                            case 1:
                                sortPetByAge();
                                break;
                            case 2:
                                sortPetByPrice();
                                break;
                            case 3:
                                sortCatByRealMoney();
                                break;
                            case 4:
                                sortDogByRealMoney();
                                break;
                            case 5:
                                sortMouseByRealMoney();
                                break;
                            case 0:
                                break;
                            default:
                                System.err.println("Please let's choose one");
                        }
                    }
                    break;
                case 5:
                    removePetByIndex();
                    break;
                case 6:
                    addNewBill();
                    break;
                case 7:
                    showBill();
                    break;
                case 8:
                    showCustomer();
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

    public static void showBill() {
        for (Bill bill : billListClient
        ) {
            System.out.println(bill);
        }
    }

    public static void showCustomer() {
        for (Customer c : customerListClient
        ) {
            System.out.println(c);
        }
    }

    public static void addNewBill() {
        Bill bill = createNewBill();
        BillManager.addNewBill(bill);
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

                System.out.println("Edit name of breed: " + "(" + petListClient.get(index).getBreed().getNameBreed() + ")");
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

                Cat editCat = new Cat(editId, editName, editAge, editGender, editWeight, editColor, newBreed, editPrice, editLeg, editHair);
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

                System.out.println("Edit name of breed: " + "(" + petListClient.get(index).getBreed().getNameBreed() + ")");
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

                System.out.println("Edit name of breed: " + "(" + petListClient.get(index).getBreed().getNameBreed() + ")");
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

    public static void sortPetByAge() {
        Collections.sort(petListClient);
        for (Pet pet : petListClient
        ) {
            System.out.println(pet);
        }
    }

    public static void sortPetByPrice() {
        Collections.sort(petListClient, new Comparator<Pet>() {
            @Override
            public int compare(Pet o1, Pet o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
        for (Pet e : petListClient
        ) {
            System.out.println(e);
        }
    }

    public static void sortCatByRealMoney() {
        Collections.sort(petListClient, new Comparator<Pet>() {
            @Override
            public int compare(Pet o1, Pet o2) {
                return (int) (((Cat) o1).getRealMoney() - ((Cat) o2).getRealMoney());
            }
        });
        for (Pet e : petListClient
        ) {
            if (e instanceof Cat) {
                System.out.println(e);
            }
        }
    }

    public static void sortDogByRealMoney() {
        Collections.sort(petListClient, new Comparator<Pet>() {
            @Override
            public int compare(Pet o1, Pet o2) {
                return (int) (((Dog) o1).getRealMoney() - ((Dog) o2).getRealMoney());
            }
        });
        for (Pet e : petListClient
        ) {
            if (e instanceof Dog) {
                System.out.println(e);
            }
        }
    }

    public static void sortMouseByRealMoney() {
        Collections.sort(petListClient, new Comparator<Pet>() {
            @Override
            public int compare(Pet o1, Pet o2) {
                return (int) (((Mouse) o1).getRealMoney() - ((Mouse) o2).getRealMoney());
            }
        });
        for (Pet e : petListClient
        ) {
            if (e instanceof Mouse) {
                System.out.println(e);
            }
        }
    }

    public static void removePetByIndex() {
        System.out.println("Input Pet's id need remove");
        String id = validate.checkStringNotNull();
        int index = PetManager.getPetById(id);
        PetManager.deletePet(index);
    }

    public static Bill createNewBill() {
        System.out.println("Input bill's id");
        String idBill = validate.checkStringNotNull();

        System.out.println("Input customer's id");
        String idCustomer = validate.checkStringNotNull();

        System.out.println("Input customer's name");
        String nameCustomer = validate.checkStringNotNull();

        System.out.println("Input customer's phone");
        String phoneCustomer = validate.checkStringNotNull();

        System.out.println("Input customer's address");
        String addressCustomer = validate.checkStringNotNull();

        Customer newCustomer = new Customer(idCustomer, nameCustomer, phoneCustomer, addressCustomer);
        CustomerManager.addNewCustomer(newCustomer);

        Scanner inputNumberPet = new Scanner(System.in);
        System.out.println("Input number type pet you need:");
        int number = inputNumberPet.nextInt();


        double sum = 0;
        Bill bill = null;
        ArrayList<Pet> billPetList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            System.out.println("Input id Pet of " + (i + 1));
            String idPet = validate.checkStringNotNull();
            int index = PetManager.getPetById(idPet);

            System.out.println("Input quantity:");
            int quantity = validate.checkInt();

            Pet pet = petListClient.get(index);
            billPetList.add(pet);

            System.out.println("Price: " + pet.getPrice());
            sum += quantity * petListClient.get(index).getPrice();

            bill = new Bill(idBill, newCustomer,billPetList, sum);
        }
        return bill;
    }
}
