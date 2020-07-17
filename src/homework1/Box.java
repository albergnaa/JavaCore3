package homework1;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits;

    public Box(T... items) {
        this.fruits = new ArrayList<T>(Arrays.asList(items));
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public void add(T... items) {
        fruits.addAll(Arrays.asList(items));
    }

    public float getWeight() {
        float weight = 0;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box anotherBox) {
        return Math.abs(getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    public void transfer(Box<T> anotherBox) {
        anotherBox.getFruits().addAll(fruits);
        fruits.clear();
    }
}
