package homework6;

import java.util.Arrays;

public class Tasks {

    public static int[] task1(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {
                return Arrays.copyOfRange(arr, i + 1, arr.length);
            }
        }
        throw new RuntimeException("В массиве нет ни одной 4-ки");
    }

    public static boolean task2(int[] arr) {
        boolean cons1 = false;
        boolean cons4 = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 1 && arr[i] != 4) {
                return false;
            }
            if (arr[i] == 1) {
                cons1 = true;
            }
            if (arr[i] == 4) {
                cons4 = true;
            }
        }
        return cons1 && cons4;
    }

}
