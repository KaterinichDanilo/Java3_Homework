package Homework1;

import java.util.ArrayList;

public class Box <T extends Fruit>{
    ArrayList<T> list = new ArrayList<>();
    int amountOfFruits = 0;

    public void add(T element){
        list.add(element);
        amountOfFruits++;
    }

    public double weight(double weight){
        return this.amountOfFruits * weight;
    }

    public <K extends Fruit>boolean compareWeight(Box<K> box2){
        return this.weight(this.list.get(0).getWEIGHT()) == box2.weight(box2.list.get(0).getWEIGHT());
    }

    public void empty(Box<T> box2){
        box2.list.addAll(this.list);
        this.list.removeAll(this.list);
    }
}
