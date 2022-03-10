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
        int totalYear = getBreed().longevity - getAge();
        if (totalYear > 0 && totalYear <= 20) {
            total = getPrice() - getPrice()/100*30;
        }
        if(totalYear > 20  && totalYear <= 40) {
            total = getPrice() - getPrice()/100*10;
        }
        return total;
    }
}
