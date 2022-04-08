package Homework6;

import java.util.Arrays;

public class Task1 {
    public static Integer [] getArrayAfter4(Integer [] array) throws RuntimeException{
        if (!Arrays.asList(array).contains(4)) {
            throw new RuntimeException("There is no number 4 in array");
        }
        int position = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                position = i;
            }
        }

        Integer [] resultArray = new Integer[array.length - position - 1];
        System.arraycopy(array, position + 1, resultArray, 0, array.length - position - 1);
        return resultArray;
    }

    public static boolean ifArrayConsistsOf1And4(Integer [] array) {
        if (!Arrays.asList(array).contains(4) || !Arrays.asList(array).contains(1)) {
            return false;
        }

        for (Integer integer : array) {
            if (integer != 4 && integer != 1) {
                return false;
            }
        }
        return true;
    }
}
