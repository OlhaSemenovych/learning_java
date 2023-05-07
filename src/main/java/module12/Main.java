package module12;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static final String INTERRUPTED = "Interrupted!";

    public static void main(String[] args) {

        log.info("----- Eternal Printer using Thread(Runnable) -----");
        EternalPrinter.eternalPrinterWithThread();

        log.info("----- Eternal Printer using 'ScheduledExecutorService' -----");
        EternalPrinter.eternalPrinterWithScheduledExecutorService();


        log.info("----- FizzBuzz 4 Threads -----");
        FizzBuzz fizzBuzz = new FizzBuzz(17);

        Thread threadA = new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> log.info("fizz"));
            } catch (InterruptedException e) {
                log.warn(INTERRUPTED, e);
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> log.info("buzz"));
            } catch (InterruptedException e) {
                log.warn(INTERRUPTED, e);
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                fizzBuzz.fizzBuzz(() -> log.info("fizzbuzz"));
            } catch (InterruptedException e) {
                log.warn(INTERRUPTED, e);
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        });

        Thread threadD = new Thread(() -> {
            try {
                fizzBuzz.number(System.out::println);
            } catch (InterruptedException e) {
                log.warn(INTERRUPTED, e);
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }

}
