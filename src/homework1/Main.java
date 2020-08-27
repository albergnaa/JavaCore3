package homework1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //Task1
        System.out.println("Task1:");
        Integer[] arrInt1 = {23, 4, 5678, 5443, 21435, 567, 8, 9, 4, -2343};
        Object[] arrObj1 = {345, 4567, -1232435, "dfgh", "sdfgh", 'f'};
        System.out.println(Arrays.toString(arrInt1));
        swap(arrInt1, 2, 6);
        System.out.println(Arrays.toString(arrInt1));
        System.out.println(Arrays.toString(arrObj1));
        swap(arrObj1, 2, 4);
        System.out.println(Arrays.toString(arrObj1));
        System.out.println();

        //Task2
        System.out.println("Task2:");
        Integer[] arrInt2 = {23, 4, 5678, 5443, 21435, 567, 8, 9, 4, -2343};
        Object[] arrObj2 = {345, 4567, -1232435, "dfgh", "sdfgh", 'f'};
        String[] arrStr2 = {"dsfgh", "qwertgfd1234", "2345szdfgfv"};
        System.out.println(convertToArrayList(arrInt2));
        System.out.println(convertToArrayList(arrObj2));
        System.out.println(convertToArrayList(arrStr2));
        System.out.println();

        //Task3
        System.out.println("Task3:");
        Apple apple = new Apple();
        Orange orange = new Orange();
        Box<Apple> appleBox = new Box<>(apple, apple);
        Box<Orange> orangeBox = new Box<>(orange, orange, orange);

        //2 apple != 3 orange
        System.out.println(appleBox.getWeight() + " " + orangeBox.getWeight());
        System.out.println(appleBox.compare(orangeBox));
        appleBox.add(apple, apple, apple, apple);
        orangeBox.add(orange);
        //6 apple == 4 orange
        System.out.println(appleBox.getWeight() + " " + orangeBox.getWeight());
        System.out.println(appleBox.compare(orangeBox));

        Box<Apple> appleBox1 = new Box<>(apple, apple);
        System.out.println(appleBox.getWeight());
        System.out.println(appleBox1.getWeight());
        appleBox1.transfer(appleBox);
        System.out.println(appleBox.getWeight());
        System.out.println(appleBox1.getWeight());
    }


    public static void swap(Object[] arr, int index1, int index2) {
        Object tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static <T> ArrayList<T> convertToArrayList(T[] array) {
        return new ArrayList<T>(Arrays.asList(array));
    }

}
