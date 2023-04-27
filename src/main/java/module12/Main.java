package module12;

public class Main {

    public static void main(String[] args) {

        System.out.println("----- Eternal Printer using Thread(Runnable) -----");
        EternalPrinter.eternalPrinterWithThread();

        System.out.println("----- Eternal Printer using 'ScheduledExecutorService' -----");
        EternalPrinter.eternalPrinterWithScheduledExecutorService();


        System.out.println("----- FizzBuzz 4 Threads -----");
        FizzBuzz fizzBuzz = new FizzBuzz(17);

        Thread threadA = new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.println("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                fizzBuzz.fizzBuzz(() -> System.out.println("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadD = new Thread(() -> {
            try {
                fizzBuzz.number(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }

}
