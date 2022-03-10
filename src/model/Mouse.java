package model;

public class Mouse extends Pet implements Discount {
    private double size;

    public Mouse() {
    }

    public Mouse(String id, String name, int age, String gender, double weight, String color, Breed breed, double price, double size) {
        super(id, name, age, gender, weight, color, breed, price);
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                ", id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", gender=" + getGender() +
                ", weight=" + getWeight() +
                ", color='" + getColor() + '\'' +
                ", breed=" + getBreed().nameBreed +
                ", price=" + getPrice() +
                ", size=" + size +
                '}';
    }

    @Override
    public double getRealMoney() {
        double total = 0;
        int percentAge = getAge() / getBreed().longevity * 100;
        if (percentAge <= 10) {
            total = getPrice() - getPrice() / 100 * 1;
        }
        if (percentAge <= 40 && percentAge > 10) {
            total = getPrice() - getPrice() / 100 * 2;
        } else if (percentAge > 40) {
            total = getPrice() - getPrice() / 100 * 5;
        }
        return total;
    }
}
