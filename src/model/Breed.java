package model;

import java.io.Serializable;

public class Breed implements Serializable {
    String nameBreed;
    int longevity;

    public Breed(String nameBreed, int longevity) {
        this.nameBreed = nameBreed;
        this.longevity = longevity;
    }

    public String getNameBreed() {
        return nameBreed;
    }

    public void setNameBreed(String nameBreed) {
        this.nameBreed = nameBreed;
    }

    public int getLongevity() {
        return longevity;
    }

    public void setLongevity(int longevity) {
        this.longevity = longevity;
    }
}
