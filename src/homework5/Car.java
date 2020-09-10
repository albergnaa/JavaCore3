package homework5;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static AtomicBoolean winner = new AtomicBoolean(false);
    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier waitPreparingBarrier;
    private FinishNotification finishNotification;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier waitPreparingBarrier, FinishNotification finishNotification) {
        this.race = race;
        this.speed = speed;
        this.waitPreparingBarrier = waitPreparingBarrier;
        this.finishNotification = finishNotification;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            waitPreparingBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        checkWin();
        finishNotification.notifyAboutFinish();
    }

    public void checkWin() {
        if (!winner.getAndSet(true)) {
            System.out.println(this.name + "-WIN");
        }
    }
}


