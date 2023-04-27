package module12;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EternalPrinter {

    public static void eternalPrinterWithScheduledExecutorService() {

        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        long startTime = System.nanoTime();

        service.scheduleAtFixedRate(
                () -> {
                    long endTime = System.nanoTime();
                    long time = endTime - startTime;
                    System.out.println(time);
                },
                0,
                1,
                TimeUnit.SECONDS
        );

        service.scheduleAtFixedRate(
                () -> System.out.println("5 seconds have been passed"),
                5,
                5,
                TimeUnit.SECONDS
        );
    }


    public static void eternalPrinterWithThread() {
        long startTime = System.nanoTime();

        Thread threadA = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    System.out.println("5 seconds have been passed");
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(exception);
                }
            }
        });

        Thread threadB = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    long endTime = System.nanoTime();
                    long time = endTime - startTime;
                    System.out.println(time);
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(exception);

                }
            }
        });

        threadA.start();
        threadB.start();
    }

}

