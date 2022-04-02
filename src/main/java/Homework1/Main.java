package Homework1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Task 1
        Integer [] arr = new Integer[] {2, 4, 1, 7, 5};
        String [] arrs = new String[] {"2", "4", "1", "7", "5"};
        Task1.<Integer>changeValues(arr, 2, 4);
        Task1.<String>changeValues(arrs, 2, 4);
        System.out.println(Arrays.toString(arr));// 2, 4, 5, 7, 1
        System.out.println(Arrays.toString(arrs));

        //Task2
        String [] arr2 = new String[]{"2", "6", "4", ".l"};
        System.out.println(Arrays.toString(arr2).getClass());
        System.out.println(Task2.arrayTolist(arr2).getClass());

        //Task3
        Box<Apple> box = new Box<>();
        Box<Orange> box2 = new Box<>();
        Box<Orange> box3 = new Box<>();
        for (int i = 0; i < 9; i++) {
            box.add(new Apple());
            box3.add(new Orange());
        }
        for (int i = 0; i < 6; i++) {
            box2.add(new Orange());
        }
        System.out.println(box.weight(box.list.get(0).getWEIGHT()));
        System.out.println(box2.weight(box2.list.get(0).getWEIGHT()));
        System.out.println(box.compareWeight(box2));
        box3.empty(box2);
        System.out.println(box2.list.size());
        System.out.println(box3.list.size());


    }

}
