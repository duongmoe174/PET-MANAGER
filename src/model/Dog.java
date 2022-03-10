package model;

public class Dog extends Pet implements Discount{
    private String typeOfEar;
    public Dog() {
    }

    public Dog(String id, String name, int age, String gender, double weight, String color, Breed breed, double price, String typeOfEar) {
        super(id, name, age, gender, weight, color, breed, price);
        this.typeOfEar = typeOfEar;
    }

    public String getTypeOfEar() {
        return typeOfEar;
    }

    public void setTypeOfEar(String typeOfEar) {
        this.typeOfEar = typeOfEar;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", gender=" + getGender() +
                ", weight=" + getWeight() +
                ", color='" + getColor() + '\'' +
                ", breed=" + getBreed().nameBreed +
                ", price=" + getPrice() +
                ", typeOfEar='" + typeOfEar + '\'' +
                '}';
    }


    @Override
    public double getRealMoney() {
        double total = 0;
        int percentAge = getAge() / getBreed().longevity * 100;
        if (percentAge <= 10) {
            total = getPrice() - getPrice()/100*10;
        }
        if(percentAge <= 40 && percentAge > 10) {
            total = getPrice() - getPrice()/100*30;
        }
        else if (percentAge > 40) {
            total = getPrice() - getPrice()/100*50;
        }
        return total;
    }
}
