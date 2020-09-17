package homework5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        FinishNotification finishNotification = new FinishNotification(CARS_COUNT);
        ExecutorService executorService = Executors.newFixedThreadPool(CARS_COUNT);
        CarCreator carCreator = new CarCreator(CARS_COUNT, finishNotification, () -> System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!"));
        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = carCreator.createCar(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            executorService.execute(cars[i]);
        }

        carCreator.waitAllCarsStart();
        //System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        finishNotification.waitAllCarsFinish();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        executorService.shutdown();
    }
}
