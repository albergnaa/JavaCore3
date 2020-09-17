package homework5;

import java.util.concurrent.CountDownLatch;

public class FinishNotification {

    private final CountDownLatch countDownLatch;

    public FinishNotification(int carCount) {
        this.countDownLatch = new CountDownLatch(carCount);
    }

    public void waitAllCarsFinish() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void notifyAboutFinish() {
        countDownLatch.countDown();
    }
}
