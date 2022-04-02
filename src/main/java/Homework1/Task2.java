package Homework1;

import java.util.ArrayList;
import java.util.Arrays;

public class Task2 {
    public static <T> ArrayList<T> arrayTolist(T [] array){
        ArrayList arrayList = new ArrayList(Arrays.asList(array));
        return arrayList;
    }
}
