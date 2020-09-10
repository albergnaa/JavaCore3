package homework5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CarCreator {
    private final CyclicBarrier waitPreparingBarrier;
    private FinishNotification finishNotification;


    public CarCreator(int carCount, FinishNotification finishNotification, Runnable action) {
        this.waitPreparingBarrier = new CyclicBarrier(carCount+1, action);
        this.finishNotification = finishNotification;
    }

    public Car createCar(Race race, int speed) {
        return new Car(race, speed, waitPreparingBarrier, finishNotification);
    }

    public void waitAllCarsStart() {
        try {
            waitPreparingBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
