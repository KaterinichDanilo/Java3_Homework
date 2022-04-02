package Homework5;

import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable{
    private static int CARS_COUNT;
    private CyclicBarrier cyclicBarrier;

    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CyclicBarrier cyclicBarrier) {
        this.race = race;
        this.speed = speed;
        this.cyclicBarrier = cyclicBarrier;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cyclicBarrier.await();

            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
                if (i == race.getStages().size() - 1) {
                    if (MainClass.getWinnerNumber().compareAndSet(-1, CARS_COUNT)) {
                        System.out.println(this.name + " - WIN!");
                    }
                    this.cyclicBarrier.await();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
