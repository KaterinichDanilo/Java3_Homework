package Homework1;

public class Task1 {
    public static <T> void changeValues(T [] array, int index1, int index2){
        T c = array[index1];
        array[index1] = array[index2];
        array[index2] = c;
    }
}
