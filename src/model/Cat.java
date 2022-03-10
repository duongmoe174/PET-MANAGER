package model;

public class Cat extends Pet implements Discount {
    private String typeOfLeg;
    private String typeOfHair;

    public Cat() {
    }

    public Cat(String id, String name, int age, String gender, double weight, String color, Breed breed, double price, String typeOfLeg, String longOfHair) {
        super(id, name, age, gender, weight, color, breed, price);
        this.typeOfLeg = typeOfLeg;
        this.typeOfHair = longOfHair;
    }

    public String getTypeOfLeg() {
        return typeOfLeg;
    }

    public void setTypeOfLeg(String typeOfLeg) {
        this.typeOfLeg = typeOfLeg;
    }

    public String getTypeOfHair() {
        return typeOfHair;
    }

    public void setTypeOfHair(String typeOfHair) {
        this.typeOfHair = typeOfHair;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", gender=" + getGender() +
                ", weight=" + getWeight() +
                ", color='" + getColor() + '\'' +
                ", breed=" + getBreed().nameBreed +
                ", price=" + getPrice() +
                ", lengthOfLeg='" + typeOfLeg + '\'' +
                ", lengthOfHair='" + typeOfHair + '\'' +
                '}';
    }

    @Override
    public double getRealMoney() {
        double total = 0;
        int percentAge = getAge() / getBreed().longevity * 100;
        if (percentAge <= 10) {
            total = getPrice() - getPrice() / 100 * 5;
        }
        if (percentAge <= 40 && percentAge > 10) {
            total = getPrice() - getPrice() / 100 * 15;
        } else if (percentAge > 40) {
            total = getPrice() - getPrice() / 100 * 20;
        }
        return total;
    }
}
