package Homework5;

public class StartFinishRace implements Runnable{

    @Override
    public void run() {
        if (MainClass.isRaceStarted()) {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } else {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        }
        MainClass.setRaceStarted(!MainClass.isRaceStarted());
    }
}
