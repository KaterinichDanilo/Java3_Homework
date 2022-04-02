package Homework5;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class MainClass {
    public static final int CARS_COUNT = 4;
    private static boolean raceStarted = false;
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT, new StartFinishRace());
    private static Semaphore semaphore = new Semaphore(CARS_COUNT/2);
    private static AtomicInteger winnerNumber = new AtomicInteger(-1);

    public static boolean isRaceStarted() {
        return raceStarted;
    }

    public static void setRaceStarted(boolean raceStarted) {
        MainClass.raceStarted = raceStarted;
    }

    public static CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }

    public static Semaphore getSemaphore() {
        return semaphore;
    }

    public static AtomicInteger getWinnerNumber() {
        return winnerNumber;
    }

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cyclicBarrier);
        }
        for (Car car : cars) {
            new Thread(car).start();
        }
    }
}
